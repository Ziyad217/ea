package utility;

import resources.IsNotASTLFile;

import java.io.DataInputStream;
import java.io.InputStream;

public class BinaerReader extends DataInputStream implements STLReader{
    /**
     * Creates a DataInputStream that uses the specified
     * underlying InputStream.
     * @param in the specified input stream
     */
    public BinaerReader(InputStream in) throws IsNotASTLFile {
        super(in);
        if (!pruefeAufSTL(null))
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
    public Float[] leseKoerperEin() {
        return null;
    }

}
