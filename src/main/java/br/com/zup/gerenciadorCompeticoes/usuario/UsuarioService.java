package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.exceptions.UsuarioNEncontrado;
import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Jogo pesquisarJogoPorID(int id) {
        Optional<Jogo> jogoId = jogoRepository.findById(id);

        if (jogoId.isEmpty()) {
            throw new JogoNaoEncontradoException("Este Id de Jogo é inválido,jogo não foi encontrado");
        }

        return jogoId.get();
    }

    public Usuario checkinUsuario(String email, int id) {
        Jogo jogo = pesquisarJogoPorID(id);
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

}
