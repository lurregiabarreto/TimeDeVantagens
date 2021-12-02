package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.exceptions.DataPosteriorException;
import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.vantagem.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    public void verificarData(Jogo jogo) {
        LocalDateTime dataAtual = LocalDateTime.now();

        if (jogo.getDataDoJogo().isBefore(dataAtual)) {
            throw new DataPosteriorException("Data atual posterior a data do jogo");
        }

    }

    public List<Jogo> exibirTodosJogos() {
        List<Jogo> jogos = (List<Jogo>) jogoRepository.findAll();

        return jogos;
    }

    public Jogo pesquisarJogoPorID(int id) {
        Optional<Jogo> jogoId = jogoRepository.findById(id);

        if (jogoId.isEmpty()) {
            throw new JogoNaoEncontradoException("Este Id de Jogo é inválido,jogo não foi encontrado");
        }

        return jogoId.get();
    }

}
