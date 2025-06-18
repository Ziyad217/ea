package utility;

import resources.IsNotASTLFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ASCIIReader liest ASCII-STL-Dateien ein und implementiert das STLReader-Interface.
 * Es prüft beim Erstellen, ob die Datei eine gültige STL-Datei ist.
 */
public class ASCIIReader extends BufferedReader implements STLReader {

    /**
     * Konstruktor für ASCIIReader.
     * Überprüft, ob die übergebene Datei eine STL-Datei ist.
     *
     * @param datei Die einzulesende Datei.
     * @throws FileNotFoundException  Wenn die Datei nicht gefunden wird.
     * @throws IsNotASTLFileException Wenn die Datei keine STL-Datei ist.
     */


    public ASCIIReader(File datei) throws IsNotASTLFileException, FileNotFoundException {
        super(new FileReader(datei));
        if (!pruefeAufSTL(datei.getName()))
            throw new IsNotASTLFileException();
    }

    /**
     * Liest den Kopf der STL-Datei ein.
     *
     * @return String, der Typ des zurückgegebenen Kopfes.
     * @return Ein Array mit den Kopf-Daten oder null.
     */
    @Override
    public String[] leseKopfEin() {
        try {
            return this.readLine().split(" ");
        } catch (IOException e) {
            e.getMessage();
            return null;
        }
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
     * @return Ein Array mit den Körperdaten oder null.
     */
    @Override
    public List<Float> leseKoerperEin() {
        try {
            String zeile;
            ArrayList<Float> zahlenWerte = new ArrayList<>();
            while ((zeile = this.readLine()) != null) {
                if (zeile.trim().startsWith("vertex")) {
                    String[] teile = zeile.trim().split("\\s+");
                    if (teile.length == 4) {
                        zahlenWerte.add(Float.parseFloat(teile[1]));
                        zahlenWerte.add(Float.parseFloat(teile[2]));
                        zahlenWerte.add(Float.parseFloat(teile[3]));
                    }
                } else if (zeile.startsWith("facet normal")) {
                    String[] teile = zeile.split("\\s+");
                    if (teile.length == 5) {
                        zahlenWerte.add(Float.parseFloat(teile[2]));
                        zahlenWerte.add(Float.parseFloat(teile[3]));
                        zahlenWerte.add(Float.parseFloat(teile[4]));
                    }
//                if (zeile.contains("vertex")) {
//                    String[] zeilenTeile = Arrays.copyOfRange(zeile.split(" "), 1,
//                            3);
//                    zahlenWerte.addAll(Arrays.stream(zeilenTeile).map(Float::valueOf)
//                            .collect(Collectors.toList()));
//                } else if (zeile.contains("normal")) {
//                    String[] zeilenTeile = Arrays.copyOfRange(zeile.split(" "), 2,
//                            4);
//                    zahlenWerte.addAll(Arrays.stream(zeilenTeile).map(Float::valueOf)
//                            .collect(Collectors.toList()));
//                }
                    }
                }
            return zahlenWerte;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
