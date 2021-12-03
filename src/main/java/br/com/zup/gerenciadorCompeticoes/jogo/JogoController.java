package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.adm.Administrador;
import br.com.zup.gerenciadorCompeticoes.jogo.dtos.CadastroJogoDTO;
import br.com.zup.gerenciadorCompeticoes.jogo.dtos.ExibirDetalheJogoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    JogoService jogoService;
    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibirDetalheJogoDTO cadastrarJogo(@RequestBody @Valid CadastroJogoDTO cadastroRecebido) {
        Administrador adm = modelMapper.map(cadastroRecebido.getAdm(), Administrador.class);
        Jogo jogo = jogoService.salvarJogo(modelMapper.map(cadastroRecebido, Jogo.class), adm);

        return modelMapper.map(jogo, ExibirDetalheJogoDTO.class);
    }

    @GetMapping
    public List<ExibirDetalheJogoDTO> exibirJogos() {
        List<ExibirDetalheJogoDTO> listaDeJogos = new ArrayList<>();

        for (Jogo jogo : jogoService.exibirTodosJogos()) {
            ExibirDetalheJogoDTO exibirDetalheJogoDTO = modelMapper.map(jogo, ExibirDetalheJogoDTO.class);
            listaDeJogos.add(exibirDetalheJogoDTO);
        }

        return listaDeJogos;
    }

    @GetMapping("/{id}")
    public ExibirDetalheJogoDTO exibirJogoPorId(@PathVariable int id) {
        return modelMapper.map(jogoService.pesquisarJogoPorID(id), ExibirDetalheJogoDTO.class);
    }

}
