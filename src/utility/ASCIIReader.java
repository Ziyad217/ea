package utility;

import resources.IsNotASTLFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ASCIIReader extends FileReader implements STLReader {


    public ASCIIReader(String fileName) throws FileNotFoundException, IsNotASTLFile {
        super(fileName);
        if (!pruefeAufSTL(fileName))
            throw new IsNotASTLFile();
    }

    @Override
    public <T> T[] leseKopfEin() {
        return null;
    }

    @Override
    public int leseAnzahlDreieckeEin() {
        return 0;
    }

    @Override
    public <T> T[] leseKoerperEin() {
        return null;
    }
}
