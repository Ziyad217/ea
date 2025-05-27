package utility;

import resources.IsNotASTLFile;
import resources.Konstanten;

import java.io.FileNotFoundException;

public interface STLReader {
    default boolean pruefeAufSTL(String fileName) {
        return fileName.endsWith(Konstanten.DATEIENDE);
    }
    <T> T[] leseKopfEin();

    int leseAnzahlDreieckeEin();

    <T> T[] leseKoerperEin();
}
