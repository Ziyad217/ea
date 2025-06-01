package utility;

import resources.IsNotASTLFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
/**
 * ASCIIReader liest ASCII-STL-Dateien ein und implementiert das STLReader-Interface.
 * Es prüft beim Erstellen, ob die Datei eine gültige STL-Datei ist.
 */
public class ASCIIReader extends FileReader implements STLReader {

    /**
     * Konstruktor für ASCIIReader.
     * Überprüft, ob die übergebene Datei eine STL-Datei ist.
     *
     * @param fileName Der Name der einzulesenden Datei.
     * @throws FileNotFoundException Wenn die Datei nicht gefunden wird.
     * @throws IsNotASTLFile Wenn die Datei keine STL-Datei ist.
     */
    public ASCIIReader(String fileName) throws FileNotFoundException, IsNotASTLFile {
        super(fileName);
        if (!pruefeAufSTL(fileName))
            throw new IsNotASTLFile();
    }

    /**
     * Liest den Kopf der STL-Datei ein.
     *
     * @param <T> Der Typ des zurückgegebenen Kopfes.
     * @return Ein Array mit den Kopf-Daten oder null.
     */
    @Override
    public <T> T[] leseKopfEin() {
        return null;
    }

    /**
     * Liest die Anzahl der Dreiecke in der STL-Datei ein.
     *
     * @return Die Anzahl der Dreiecke.
     */
    @Override
    public int leseAnzahlDreieckeEin() {
        return 0;
    }

    /**
     * Liest die Körperdaten der STL-Datei ein.
     *
     * @param <T> Der Typ der zurückgegebenen Körperdaten.
     * @return Ein Array mit den Körperdaten oder null.
     */
    @Override
    public <T> T[] leseKoerperEin() {
        return null;
    }
}
