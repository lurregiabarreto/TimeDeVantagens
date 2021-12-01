package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.exceptions.EmailJaCadastradoException;
import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.exceptions.UsuarioNEncontrado;
import br.com.zup.gerenciadorCompeticoes.exceptions.VantagemInvalidaException;
import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoRepository;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoService;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    JogoService jogoService;


    public Usuario salvarUsuario(Usuario usuarioRecebido) {
        verificarEmail(usuarioRecebido.getEmail());
        usuarioRecebido.setPontos(0);

        return usuarioRepository.save(usuarioRecebido);
    }

    public void verificarEmail(String email){
        Optional<Usuario> emailExiste = usuarioRepository.findById(email);
        if (emailExiste.isPresent()){
            throw new EmailJaCadastradoException("Email já cadastrado!");
        }
    }


    public List<Jogo> exibirTodosJogos() {
        List<Jogo> jogos = (List<Jogo>) jogoRepository.findAll();

        return jogos;
    }

    public Jogo pesquisarJogoPorID(int id) {
        Optional<Jogo> jogoId = jogoRepository.findById(id);

        if (jogoId.isEmpty()) {
            throw new JogoNaoEncontradoException("Este Id de Jogo é inválido,jogo não foi encontrado");
        }

        return jogoId.get();
    }

    public Usuario checkinUsuario(String email, int id) {
        Jogo jogo = pesquisarJogoPorID(id);
        jogoService.verificarData(jogo);
        var pontosCheckin = 5;

        Usuario usuarioAtualizado = buscarUsuarioId(email);
        usuarioAtualizado.setPontos(usuarioAtualizado.getPontos() + pontosCheckin);
        usuarioRepository.save(usuarioAtualizado);

        return usuarioAtualizado;
    }

    public Usuario buscarUsuarioId(String email) {
        Optional<Usuario> usuarioBuscar = usuarioRepository.findById(email);
        if (usuarioBuscar.isEmpty()) {
            throw new UsuarioNEncontrado("Este usuário não foi encontrado");
        }

        return usuarioBuscar.get();
    }

    public Usuario atualizarTrocaVantagens(int id, String email, Vantagem vantagem) {
        Jogo jogo = pesquisarJogoPorID(id);
        Usuario usuario = buscarUsuarioId(email);
        jogoService.verificarData(jogo);

        for (Vantagem referencia : jogo.getVantagens()) {
            if (vantagem.getBeneficio().equals(referencia.getBeneficio())) {
                referencia.setDataValidade(jogo.getDataDoJogo().plusDays(1));
                usuario.getVantagensAdquiridas().add(referencia);
            }
        }

        return usuario;
    }

}
