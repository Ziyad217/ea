package model;

import resources.NummerKonstanten;

import java.util.Set;

/**
 * Diese Klasse repräsentiert einen Polygonzug bestehend aus mehreren Kanten und Ecken.
 * Sie stellt sicher, dass die Kanten verbunden sind.
 *
 * @author ziyad
 */
public class Polygonzug implements NummerKonstanten {

    private Kante[] kante;
    private Set<Eckpunkt> ecken;

    /**
     * Konstruktor für Polygonzug.
     *
     * @param kante Array von Kanten, die den Polygonzug bilden.
     * @param ecken Menge der Eckpunkte, die zu dem Polygonzug gehören.
     * @precondition kante darf nicht null sein und muss mindestens eine Kante enthalten.
     * @postcondition Ein Polygonzug-Objekt ist erzeugt und die Kanten sind verbunden.
     */
    public Polygonzug(Kante[] kante, Set<Eckpunkt> ecken)
    {
        this.kante = kante;
        this.ecken = ecken;
        this.ueberpruefeObVerbunden(this.kante);
    }

    /**
     * Diese Methode überprüft, ob alle Kanten miteinander verbunden sind.
     *
     * @param kante Array von Kanten, die geprüft werden sollen.
     * @return true, wenn alle Kanten verbunden sind, false sonst.
     * @precondition kante darf nicht null sein.
     * @postcondition Die Verbindungsprüfung wurde durchgeführt.
     */
    private boolean ueberpruefeObVerbunden(Kante[] kante)
    {
        for (int i = NummerKonstanten.NULL; i < kante.length - NummerKonstanten.EINS; i++)
        {
            Kante aktuelleKante = kante[i];
            Kante naechsteKante = kante[i + NummerKonstanten.EINS];
            if (!aktuelleKante.getEckpunktB().equals(naechsteKante.getEckpunktA()))
            {
                return false;
            }
        }
        return true;
    }

    public Kante[] getKanten()
    {
        return kante;
    }


    public Set<Eckpunkt> getEcken()
    {
        return ecken;
    }
}

