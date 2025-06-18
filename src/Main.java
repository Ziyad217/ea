
import utility.ASCIIReader;
import utility.BinaerReader;
import resources.IsNotASTLFileException;
import java.nio.file.Paths;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

testeASCIISTL();
        File stlDatei =
                Paths.get(System.getProperty("user.home"), "Downloads", "RuffyBinär.stl").toFile();

                try (BinaerReader reader = new BinaerReader(stlDatei)) {
                    System.out.println("STL-Datei geöffnet: " + stlDatei.getName());

                    // Header einlesen
                    String[] header = reader.leseKopfEin();
                    System.out.println("Header: ");
                    for (String s : header) {
                        System.out.print(s + " ");
                    }
                    System.out.println();



                    ArrayList<Float> daten = reader.leseKoerperEin();

                    System.out.println("Erste paar Werte (max. 20): ");
                    for (int i = 0; i < Math.min(20, daten.size()); i++) {
                        System.out.print(daten.get(i) + " ");
                    }
                    System.out.println();
                    int anzahlDreiecke = daten.size() / 12;
                    System.out.println("Anzahl der Dreiecke: " + anzahlDreiecke);
                } catch (IsNotASTLFileException e) {
                    System.err.println("Ungültige STL-Datei: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Allgemeiner Fehler beim Einlesen: " + e.getMessage());
                }
            }

    /**
     * Testet das Einlesen einer ASCII STL-Datei.
     */
    private static void testeASCIISTL() {
        File stlDatei =
                Paths.get(System.getProperty("user.home"), "Downloads", "RuffyASCII.stl").toFile();

        try (ASCIIReader reader = new ASCIIReader(stlDatei)) {
            System.out.println("STL-Datei geöffnet (ASCII): " + stlDatei.getName());

            // Header einlesen
            String[] header = reader.leseKopfEin();
            System.out.println("Header:");
            if (header != null) {
                for (String s : header) {
                    System.out.print(s + " ");
                }
                System.out.println();
            } else {
                System.out.println("Kein Header gefunden.");
            }

            // Körperdaten einlesen
            ArrayList<Float> daten = new ArrayList<>(reader.leseKoerperEin());
            System.out.println("Erste paar Werte (max. 20): ");
            for (int i = 0; i < Math.min(20, daten.size()); i++) {
                System.out.print(daten.get(i) + " ");
            }
            System.out.println();

        } catch (IsNotASTLFileException e) {
            System.err.println("Ungültige STL-Datei (ASCII): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Fehler beim Einlesen (ASCII): " + e.getMessage());
        }
    }
}