package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Jogo> exibirTodosJogos (){
        List<Jogo> jogos = (List<Jogo>) jogoRepository.findAll();
        return jogos;

    }

    }













