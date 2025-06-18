package resources;

public class UnexpectedASCIIHeaderException extends Exception
{
    public UnexpectedASCIIHeaderException(){super(ExceptionMessages.UNEXPECTED_ASCIIHEADER);}
}
