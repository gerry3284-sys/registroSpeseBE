package registroSpeseBackEnd.RegistroSpese.exceptionHandler;

public class AppExceptions
{
    public static class DuplicateResourceException extends RuntimeException
    {
        public DuplicateResourceException(String message) { super(message); }
    }

    public static class ResourceNotFoundException extends RuntimeException
    {
        public ResourceNotFoundException(String message) { super(message); }
    }
}