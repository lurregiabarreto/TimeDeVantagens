package br.com.zup.gerenciadorCompeticoes.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario salvarUsuario(Usuario usuarioRecebido){
        usuarioRecebido.setPontos(0);
        return usuarioRepository.save(usuarioRecebido);
    }

}
