package br.com.zup.gerenciadorCompeticoes.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;

    public Jogo salvarJogo(Jogo jogoRecebido){
        jogoRecebido.setDataDeCadastro(LocalDateTime.now());
        return jogoRepository.save(jogoRecebido);
    }

}
