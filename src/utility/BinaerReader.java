package utility;

import resources.IsNotASTLFile;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * BinaerReader liest binäre STL-Dateien und implementiert das STLReader-Interface.
 * Beim Erstellen prüft er, ob es sich um eine gültige STL-Datei handelt.
 */
public class BinaerReader extends DataInputStream implements STLReader {

    /**
     * Konstruktor für BinaerReader.
     *
     * @param in InputStream der einzulesenden Datei.
     * @throws IsNotASTLFile wenn die Datei keine gültige STL-Datei ist.
     */
    public BinaerReader(InputStream in) throws IsNotASTLFile {
        super(in);
        if (!pruefeAufSTL(null)) // TODO: Hier sollte eigentlich ein Dateiname geprüft werden.
            throw new IsNotASTLFile();
    }

    /**
     * Liest den Kopf der STL-Datei.
     *
     * @param <T> der Typ der Kopf-Daten.
     * @return ein Array mit Kopf-Daten oder null.
     */
    @Override
    public <T> T[] leseKopfEin() {
        return null;
    }

    /**
     * Liest die Anzahl der Dreiecke aus der STL-Datei.
     *
     * @return die Anzahl der Dreiecke.
     */
    @Override
    public int leseAnzahlDreieckeEin() {
        return 0;
    }

    /**
     * Liest die Körperdaten der STL-Datei.
     *
     * @return ein Array mit Float-Werten der Körper-Daten oder null.
     */
    @Override
    public Float[] leseKoerperEin() {
        return null;
    }
}
