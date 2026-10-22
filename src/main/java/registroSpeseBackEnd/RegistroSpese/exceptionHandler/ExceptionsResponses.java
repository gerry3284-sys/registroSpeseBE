package registroSpeseBackEnd.RegistroSpese.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import registroSpeseBackEnd.RegistroSpese.dtos.ErrorResponseDto;

@RestControllerAdvice
public class ExceptionsResponses
{
    @ExceptionHandler(AppExceptions.DuplicateResourceException.class)
    public ResponseEntity<ErrorResponseDto> handleDuplicate(AppExceptions.DuplicateResourceException ex)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT) // 409
                .body(new ErrorResponseDto("409", ex.getMessage()));
    }

    @ExceptionHandler(AppExceptions.ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(AppExceptions.ResourceNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto("404", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGeneric(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto("500", "Errore interno del server"));
    }
}
