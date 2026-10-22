package registroSpeseBackEnd.RegistroSpese.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto
{
    private String errorCode, message;
    private LocalDateTime timestamp;

    public ErrorResponseDto(String errorCode, String message)
    {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}