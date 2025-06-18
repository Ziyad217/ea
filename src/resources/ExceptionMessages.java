package resources;

public interface ExceptionMessages
{
    String STL_MESSAGE = "Diese Datei ist keine STL-datei";
    String HEADER_MESSAGE = "Datei ist beschädigt oder nicht vollständig: STL-Header fehlt oder ist zu kurz.";
    String UNEXPECTED_ASCIIHEADER = "Warnung: Header enthält 'solid' – möglicherweise ASCII-STL!";
    }

