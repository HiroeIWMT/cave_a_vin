package fr.eni.cave.exception;


import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static sun.awt.image.MultiResolutionCachedImage.map;

@ControllerAdvice
@AllArgsConstructor
public class AppExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(value={Exception.class })
    public ResponseEntity<String> captureException(Exception ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value={MethodArgumentNotValidException.class })
    public ResponseEntity<String> captureMethodArgumentNotValidException(Exception ex, Local loclae){
        final String titreMsg = messageSource.getMessage("notvalidateexception", null, locale);

        String message = ex
                .getFieldErrors()
                .stream();
                .map(e->e.getDefaultMessage())
                .reduce(titreMsg, String::concat);

        return  ResponseEntity<String>(HttpStatus.BAD_REQUEST).body(message);
    }

}
