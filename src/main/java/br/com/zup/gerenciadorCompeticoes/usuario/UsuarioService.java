package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.exceptions.UsuarioNEncontrado;
import br.com.zup.gerenciadorCompeticoes.exceptions.IdInvalid;
import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JogoRepository jogoRepository;


    public Usuario salvarUsuario(Usuario usuarioRecebido) {
        usuarioRecebido.setPontos(0);

        return usuarioRepository.save(usuarioRecebido);
    }

    public List<Jogo> exibirTodosJogos() {
        List<Jogo> jogos = (List<Jogo>) jogoRepository.findAll();

        return jogos;
    }


    public Jogo pesquisarUsuarioPorID(int id) {
        Optional<Jogo> jogoId = jogoRepository.findById(id);

        if (jogoId.isPresent()) {
            return jogoId.get();
        }

        throw new JogoNaoEncontradoException("Jogo não encontrado");

    }


    public Usuario checkinUsuario(String email, int id) {
        Optional<Jogo> verificarJogo = jogoRepository.findById(id);
        if (verificarJogo.isEmpty()) {
            throw new IdInvalid("Este Id de Jogo é inválido, não foi encontrado");
        }

        Usuario usuarioAtualizado = buscarUsuarioId(email);
        usuarioAtualizado.setPontos(usuarioAtualizado.getPontos()+5);
        usuarioRepository.save(usuarioAtualizado);

        return usuarioAtualizado;
    }

    public Usuario buscarUsuarioId(String email) {
        Optional<Usuario>usuarioBuscar = usuarioRepository.findById(email);
        if(usuarioBuscar.isEmpty()){
            throw new UsuarioNEncontrado( "Este usuário não foi encontrado");
        }
        return usuarioBuscar.get();
    }






}
