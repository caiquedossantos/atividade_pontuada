package atividade.aula.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice // Captura exceções lançadas em qualquer controller REST
public class GlobalExceptionHandler {

    // Captura exceções genéricas de tempo de execução (ex: IllegalArgumentException)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRunimeException(RuntimeException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }

    // Captura exceções de validação dos campos com @Valid/@NotBlank/etc
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                // Pega só o primeiro erro de validação
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    // Captura exceções para métodos HTTP não suportados (ex: usar PUT em um endpoint que só aceita GET)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Recurso não encontrado"));
    }
}
