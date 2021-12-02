package br.com.zup.gerenciadorCompeticoes.config;

import br.com.zup.gerenciadorCompeticoes.exceptions.CodigoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> manipularErroValidacao(MethodArgumentNotValidException exception) {
        List<MensagemErro> errosValidacao = new ArrayList<>();
        for (FieldError referencia : exception.getFieldErrors()) {
            MensagemErro mensagemErro = new MensagemErro(referencia.getDefaultMessage());
            errosValidacao.add(mensagemErro);
        }

        return errosValidacao;
    }


    @ExceptionHandler(CodigoInvalidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro manipularCodigoInvalido(CodigoInvalidoException exception) {
        return new MensagemErro(exception.getMessage());
    }


}
