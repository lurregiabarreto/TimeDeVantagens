package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.usuario.dtos.CadastroUsuarioDTO;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.ExibirUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibirUsuarioDTO cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroRecebido){
        Usuario usuario = usuarioService.salvarUsuario(modelMapper.map(cadastroRecebido,Usuario.class));

        return modelMapper.map(usuario,ExibirUsuarioDTO.class);
    }


}
