package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.exceptions.DataPosteriorException;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.vantagem.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    VantagemRepository vantagemRepository;

    public Jogo salvarJogo(Jogo jogoRecebido) {
        verificarData(jogoRecebido);
        jogoRecebido.setDataDeCadastro(LocalDateTime.now());
        jogoRecebido.setVantagens(atualizarVantagens(jogoRecebido.getVantagens()));
        return jogoRepository.save(jogoRecebido);
    }

    public Set<Vantagem> atualizarVantagens(Set<Vantagem> vantagensCadastradas) {
        Set<Vantagem> vantagensAtualizada = new HashSet<>();

        for (Vantagem referencia : vantagensCadastradas) {
            if (vantagemRepository.existsById(referencia.getBeneficio())) {
                vantagensAtualizada.add(vantagemRepository.findByBeneficio(referencia.getBeneficio()));
            } else {
                vantagensAtualizada.add(referencia);
            }
        }

        return vantagensAtualizada;
    }

    public void verificarData(Jogo jogo){
        LocalDateTime dataAtual = LocalDateTime.now();
        if (jogo.getDataDoJogo().isBefore(dataAtual)){
            throw new DataPosteriorException("Data atual posterior a data do jogo");
        }
    }

}
