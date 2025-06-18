package resources;

public class IncompleteHeaderException extends Exception
{
    public IncompleteHeaderException(){super(ExceptionMessages.HEADER_MESSAGE);}
}
