package br.com.zup.gerenciadorCompeticoes.config;

public class MensagemErro {

    private String mensagem;

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
