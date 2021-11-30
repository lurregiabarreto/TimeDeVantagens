package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

}
