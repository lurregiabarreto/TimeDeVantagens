package br.com.zup.gerenciadorCompeticoes.exceptions;

public class UsuarioNEncontrado extends RuntimeException {
    public UsuarioNEncontrado(String message) {
        super(message);
    }
}
