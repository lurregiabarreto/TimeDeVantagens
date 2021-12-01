package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.dtos.ExibirDetalheJogoDTO;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.*;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.ExibirTrocaVantagemUsuarioDTO;
import br.com.zup.gerenciadorCompeticoes.usuario.dtos.TrocaVantagemUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibirUsuarioCadastroDTO cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDTO cadastroRecebido) {
        Usuario usuario = usuarioService.salvarUsuario(modelMapper.map(cadastroRecebido, Usuario.class));

        return modelMapper.map(usuario, ExibirUsuarioCadastroDTO.class);
    }

    @GetMapping
    public List<ExibirDetalheJogoDTO> exibirJogos() {
        List<ExibirDetalheJogoDTO> listaDeJogos = new ArrayList<>();

        for (Jogo jogo : usuarioService.exibirTodosJogos()) {
            ExibirDetalheJogoDTO exibirDetalheJogoDTO = modelMapper.map(jogo, ExibirDetalheJogoDTO.class);
            listaDeJogos.add(exibirDetalheJogoDTO);
        }

        return listaDeJogos;
    }

    @GetMapping("/{id}")
    public ExibirDetalheJogoDTO exibirJogoPorId(@PathVariable int id) {
        return modelMapper.map(usuarioService.pesquisarJogoPorID(id), ExibirDetalheJogoDTO.class);
    }

    @PutMapping
    public ExibirUsuarioCadastroDTO checkin(@RequestBody CheckinUsuarioDTO atualizarJogo) {
        Usuario usuarioAtualizado = usuarioService.checkinUsuario(atualizarJogo.getEmail(), atualizarJogo.getId());

        return modelMapper.map(usuarioAtualizado, ExibirUsuarioCadastroDTO.class);
    }

    @PutMapping("/{id}")
    public ExibirTrocaVantagemUsuarioDTO realizarTrocaVantagens(@PathVariable int id,
                                                                @RequestBody TrocaVantagemUsuarioDTO trocaSolicitada) {
        Usuario usuario = usuarioService.atualizarTrocaVantagens(id, trocaSolicitada.getEmail(),
                trocaSolicitada.getVantagem());

        return modelMapper.map(usuario, ExibirTrocaVantagemUsuarioDTO.class);
    }

}
