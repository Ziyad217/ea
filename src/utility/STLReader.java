package utility;

import resources.IsNotASTLFile;
import resources.Konstanten;

import java.io.FileNotFoundException;

/**
 * Interface für Leser von STL-Dateien (ASCII oder Binär).
 * Definiert Methoden zum Einlesen von Kopf, Anzahl der Dreiecke und Körperdaten.
 */
public interface STLReader
{

    /**
     * Prüft, ob der Dateiname auf die gültige STL-Endung endet.
     *
     * @param fileName der Name der Datei.
     * @return true, wenn die Datei die gültige STL-Endung hat, sonst false.
     */
    default boolean pruefeAufSTL(String fileName)
    {
        return fileName.endsWith(Konstanten.DATEIENDE);
    }

    /**
     * Liest den Kopf der STL-Datei ein.
     *
     * @param <T> der Typ der Kopf-Daten.
     * @return ein Array mit Kopf-Daten.
     */
    <T> T[] leseKopfEin();

    /**
     * Liest die Anzahl der Dreiecke aus der STL-Datei.
     *
     * @return die Anzahl der Dreiecke.
     */
    int leseAnzahlDreieckeEin();

    /**
     * Liest die Körperdaten der STL-Datei ein.
     *
     * @param <T> der Typ der Körper-Daten.
     * @return ein Array mit Körper-Daten.
     */
    <T> T[] leseKoerperEin();
}
