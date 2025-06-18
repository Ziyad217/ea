package utility;

import resources.IncompleteHeaderException;
import resources.IsNotASTLFileException;
import resources.Konstanten;
import resources.UnexpectedASCIIHeaderException;

import java.io.*;
import java.util.ArrayList;

/**
 * BinaerReader liest binäre STL-Dateien und implementiert das STLReader-Interface.
 * Beim Erstellen prüft er, ob es sich um eine gültige STL-Datei handelt.
 */
public class BinaerReader extends FileInputStream implements STLReader
{

    /**
     * Konstruktor für BinaerReader.
     *
     * @throws IsNotASTLFileException wenn die Datei keine gültige STL-Datei ist.
     */
    public BinaerReader(File datei) throws FileNotFoundException, IsNotASTLFileException {
        super(datei);
        if (!pruefeAufSTL(datei.getName()))
            throw new IsNotASTLFileException();
    }
    /**
     * Liest den Kopf der STL-Datei.
     *
     * @return String der Typ der Kopf-Daten.
     * @return ein Array mit Kopf-Daten oder null.
     */
    @Override
    public String[] leseKopfEin()
    {
            try {
                byte[] headerBytes = new byte[80];
                int bytesRead = this.read(headerBytes);

                if (bytesRead != 80) {
                    throw new IncompleteHeaderException();
                }
                String header = new String(headerBytes);

                if (header.trim().toLowerCase().startsWith(Konstanten.SOLID)) {
                   throw new UnexpectedASCIIHeaderException();
                }
                return header.split(" ");
            } catch (IOException | IncompleteHeaderException | UnexpectedASCIIHeaderException e) {
                System.out.printf(e.getMessage());
                System.exit(-1);
                return null;
            }
    }

    /**
     * Liest die Anzahl der Dreiecke aus dem binären STL-Header.
     *
     * @return Anzahl der in der Datei enthaltenen Dreiecke.
     */
    @Override
    public int leseAnzahlDreieckeEin() {
        try {
            // Header (80 Byte) überspringen
            //this.skip(Konstanten.HEADER_LENGTH);

            // 4 Byte für Dreiecksanzahl lesen
            byte[] dreiecksAnzahlBytes = new byte[Konstanten.TRIANGLE_AMOUNT_LENGTH];
            int gelesen = this.read(dreiecksAnzahlBytes);
            if (gelesen != Konstanten.TRIANGLE_AMOUNT_LENGTH) {
                throw new IOException("Fehler beim Lesen der Dreiecksanzahl.");
            }

            // Umwandlung der Bytes in Integer (kleinste Byte zuerst)
            return java.nio.ByteBuffer.wrap(dreiecksAnzahlBytes)
                    .order(java.nio.ByteOrder.LITTLE_ENDIAN)
                    .getInt();

        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Lesen der Dreiecksanzahl: " + e.getMessage(), e);
        }
    }


    /**
     * Liest die geometrischen Daten aller Dreiecke aus der Datei.
     *
     * @return Liste mit Fließkommazahlen, die die Normalen und Eckpunkte beschreiben.
     */
    @Override
    public ArrayList<Float> leseKoerperEin() {
        ArrayList<Float> daten = new ArrayList<>();
        try {
            int anzahlDreiecke = this.leseAnzahlDreieckeEin();
            int bytesGesamt = anzahlDreiecke * Konstanten.TRIANGLE_DATA_SIZE;
            byte[] dreiecksDaten = new byte[bytesGesamt];

            int gelesen = this.read(dreiecksDaten);
            if (gelesen != bytesGesamt) {
                throw new IOException("Unvollständige Dreiecksdaten gelesen.");
            }

            java.nio.ByteBuffer buffer = java.nio.ByteBuffer.wrap(dreiecksDaten)
                    .order(java.nio.ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < anzahlDreiecke; i++) {
                for (int j = 0; j < 12; j++) {
                    daten.add(buffer.getFloat());
                }
                buffer.position(buffer.position() + 2);
            }

            return daten;

        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Einlesen der Körperdaten: " + e.getMessage(), e);
        }
    }
}
