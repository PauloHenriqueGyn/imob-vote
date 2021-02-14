package br.com.imobvote.modelo.excecao;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class MapeamentoException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    protected ResponseEntity<Object> handleAuthenticationError(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Não é possível fazer o login, verifica o email ou senha.",  new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
	
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<Object> exception(Exception ex) {
		 return new ResponseEntity<>(getBody(HttpStatus.INTERNAL_SERVER_ERROR, ex, "Erro"), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	 public Map<String, Object> getBody(HttpStatus status, Exception ex, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("exception", ex.toString());

        Throwable cause = ex.getCause();
        if (cause != null) {
            body.put("exceptionCause", ex.getCause().toString());
        }
        return body;
	}
	
}
