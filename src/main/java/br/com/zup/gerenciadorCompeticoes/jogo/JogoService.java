package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.endereco.Endereco;
import br.com.zup.gerenciadorCompeticoes.endereco.EnderecoRepository;
import br.com.zup.gerenciadorCompeticoes.exceptions.DataPosteriorException;
import br.com.zup.gerenciadorCompeticoes.exceptions.JogoNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.vantagem.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    VantagemRepository vantagemRepository;
    @Autowired
    EnderecoRepository enderecoRepository;


    public Jogo salvarJogo(Jogo jogoRecebido) {
        verificarData(jogoRecebido);
        jogoRecebido.setCodigoValidacao(UUID.randomUUID().toString());
        jogoRecebido.setVantagens(atualizarVantagens(jogoRecebido.getVantagens()));
        jogoRecebido.setEndereco(atualizarEndereco(jogoRecebido.getEndereco()));

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

    public Endereco atualizarEndereco(Endereco enderecoCadastrado){
        Endereco endereco = enderecoCadastrado;

        for (Endereco referencia: enderecoRepository.findAll()){
            if (referencia.getCep().equals(endereco.getCep())){
                endereco = referencia;
            }
        }

        return endereco;
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
