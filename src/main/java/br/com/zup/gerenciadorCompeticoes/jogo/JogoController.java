package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.jogo.dtos.CadastroJogoDTO;
import br.com.zup.gerenciadorCompeticoes.jogo.dtos.ExibirDetalheJogoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/adm")
public class JogoController {

    @Autowired
    JogoService jogoService;
    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibirDetalheJogoDTO cadastrarJogo(@RequestBody @Valid CadastroJogoDTO cadastroRecebido) {
        Jogo jogo = jogoService.salvarJogo(modelMapper.map(cadastroRecebido, Jogo.class));

        return modelMapper.map(jogo, ExibirDetalheJogoDTO.class);
    }

}
