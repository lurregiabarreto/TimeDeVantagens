package br.com.zup.gerenciadorCompeticoes.jogo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
public class JogoController {

    @Autowired
    JogoService jogoService;
    @Autowired
    ModelMapper modelMapper;

}
