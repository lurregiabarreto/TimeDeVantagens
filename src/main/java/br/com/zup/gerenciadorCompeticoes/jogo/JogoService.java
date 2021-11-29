package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.vantagem.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    VantagemRepository vantagemRepository;

    public Jogo salvarJogo(Jogo jogoRecebido){
        jogoRecebido.setDataDeCadastro(LocalDateTime.now());
        jogoRecebido.setVantagens(atualizarVantagens(jogoRecebido.getVantagens()));
        return jogoRepository.save(jogoRecebido);
    }

    public List<Vantagem> atualizarVantagens(List<Vantagem> vantagensCadastradas) {
        List<Vantagem> vantagensAtualizada = new ArrayList<>();

        for (Vantagem referencia : vantagensCadastradas) {
            if (vantagemRepository.existsById(referencia.getBeneficio())) {
                vantagensAtualizada.add(vantagemRepository.findByBeneficio(referencia.getBeneficio()));
            } else {
                vantagensAtualizada.add(referencia);
            }
        }

        return vantagensAtualizada;
    }

}
