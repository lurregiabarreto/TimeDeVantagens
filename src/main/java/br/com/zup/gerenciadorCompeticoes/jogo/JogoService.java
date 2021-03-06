package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.adm.AdmRepository;
import br.com.zup.gerenciadorCompeticoes.adm.Administrador;
import br.com.zup.gerenciadorCompeticoes.endereco.Endereco;
import br.com.zup.gerenciadorCompeticoes.endereco.EnderecoRepository;
import br.com.zup.gerenciadorCompeticoes.exceptions.*;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.vantagem.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class JogoService {

    JogoRepository jogoRepository;
    VantagemRepository vantagemRepository;
    EnderecoRepository enderecoRepository;
    AdmRepository admRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository, VantagemRepository vantagemRepository,
                       EnderecoRepository enderecoRepository, AdmRepository admRepository) {
        this.jogoRepository = jogoRepository;
        this.vantagemRepository = vantagemRepository;
        this.enderecoRepository = enderecoRepository;
        this.admRepository = admRepository;
    }

    public Jogo salvarJogo(Jogo jogoRecebido, Administrador adm) {
        atualizarDadosParaSalvar(jogoRecebido, adm);
        return jogoRepository.save(jogoRecebido);
    }

    public void atualizarDadosParaSalvar(Jogo jogoRecebido, Administrador administrador) {
        autenticarAdm(administrador);
        verificarData(jogoRecebido);
        verificarJogoJaCadastrado(jogoRecebido);
        jogoRecebido.setCodigoValidacao(UUID.randomUUID().toString());
        jogoRecebido.setVantagens(atualizarVantagens(jogoRecebido.getVantagens()));
        jogoRecebido.setEndereco(atualizarEndereco(jogoRecebido.getEndereco()));
    }

    public void autenticarAdm(Administrador adm) {
        for (Administrador referencia : admRepository.findAll()) {
            if (referencia.getLogin().equals(adm.getLogin())) {
                if (!referencia.getSenha().equals(adm.getSenha())) {
                    throw new AdmInvalidoException("Administrador inv??lido.");
                }
            } else {
                throw new AdmInvalidoException("Administrador inv??lido.");
            }
        }
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

    public Endereco atualizarEndereco(Endereco enderecoCadastrado) {
        Endereco endereco = enderecoCadastrado;

        for (Endereco referencia : enderecoRepository.findAll()) {
            if (referencia.getCep().equals(endereco.getCep())) {
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

    public void verificarJogoJaCadastrado(Jogo jogo) {

        for (Jogo referencia : jogoRepository.findAll()) {
            if (referencia.getTime1().equals(jogo.getTime1()) && referencia.getTime2().equals(jogo.getTime2())
                    && referencia.getDataDoJogo().isEqual(jogo.getDataDoJogo())) {
                throw new JogoJaCadastradoException("Jogo j?? cadastrado!");
            }
        }

    }

    public List<Jogo> exibirTodosJogos() {
        List<Jogo> jogos = (List<Jogo>) jogoRepository.findAll();

        return jogos;
    }

    public Jogo pesquisarJogoPorID(int id) {
        Optional<Jogo> jogoId = jogoRepository.findById(id);

        if (jogoId.isEmpty()) {
            throw new JogoNaoEncontradoException("Este Id de Jogo ?? inv??lido,jogo n??o foi encontrado");
        }

        return jogoId.get();
    }

    public Jogo validarJogo(int id, String codigoValidacao) {
        Jogo jogo = pesquisarJogoPorID(id);
        verificarData(jogo);
        verificarCodigoJogo(jogo, codigoValidacao);

        return jogo;
    }

    public void verificarCodigoJogo(Jogo jogo, String codigoValidacao) {
        if (!jogo.getCodigoValidacao().equals(codigoValidacao)) {
            throw new CodigoInvalidoException("C??digo de valida????o incorreto!");
        }
    }

}
