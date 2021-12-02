package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.exceptions.EmailJaCadastradoException;
import br.com.zup.gerenciadorCompeticoes.exceptions.PontosInsuficientesException;
import br.com.zup.gerenciadorCompeticoes.exceptions.UsuarioNaoEncontradoException;
import br.com.zup.gerenciadorCompeticoes.jogo.Jogo;
import br.com.zup.gerenciadorCompeticoes.jogo.JogoService;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;
import br.com.zup.gerenciadorCompeticoes.voucher.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JogoService jogoService;


    public Usuario salvarUsuario(Usuario usuarioRecebido) {
        verificarEmail(usuarioRecebido.getEmail());
        usuarioRecebido.setPontos(0);

        return usuarioRepository.save(usuarioRecebido);
    }

    public void verificarEmail(String email) {
        Optional<Usuario> emailExiste = usuarioRepository.findById(email);

        if (emailExiste.isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado!");
        }

    }

    public Usuario buscarUsuarioId(String email) {
        Optional<Usuario> usuario = usuarioRepository.findById(email);

        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Este usuário não foi encontrado");
        }

        return usuario.get();
    }

    public Usuario checkinUsuario(String email, int id, String codigoValidacao) {
        Jogo jogo = jogoService.validarJogo(id, codigoValidacao);
        var pontosCheckin = 5;

        Usuario usuarioAtualizado = buscarUsuarioId(email);
        usuarioAtualizado.setPontos(usuarioAtualizado.getPontos() + pontosCheckin);

        if (usuarioAtualizado.getTimeCoracao().equals(jogo.getTime1())){
            usuarioAtualizado.setPontos(usuarioAtualizado.getPontos() + pontosCheckin);
        }else if (usuarioAtualizado.getTimeCoracao().equals(jogo.getTime2())){
            usuarioAtualizado.setPontos(usuarioAtualizado.getPontos() + pontosCheckin * 2);
        }

        usuarioRepository.save(usuarioAtualizado);

        return usuarioAtualizado;
    }

    public Usuario atualizarTrocaVantagens(int id, String email, Vantagem vantagem, String codigoValidacao) {
        Jogo jogo = jogoService.validarJogo(id, codigoValidacao);
        Usuario usuario = buscarUsuarioId(email);

        for (Vantagem referencia : jogo.getVantagens()) {

            if (vantagem.getBeneficio().equals(referencia.getBeneficio())) {
                if (usuario.getPontos() >= referencia.getPontos()) {
                    usuario.setPontos(usuario.getPontos() - referencia.getPontos());
                    Voucher voucher = new Voucher(UUID.randomUUID().toString(),
                            referencia.getBeneficio(), jogo.getDataDoJogo().plusDays(1));
                    usuario.getVouchers().add(voucher);
                } else {
                    throw new PontosInsuficientesException("Pontos insuficientes para troca!");
                }

            }

        }

        usuarioRepository.save(usuario);

        return usuario;
    }

}
