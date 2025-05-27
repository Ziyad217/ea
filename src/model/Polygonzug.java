package model;
import resources.NummerKonstanten;

import java.util.Set;

public class Polygonzug {
private Kante[] kante;
private Set<Eckpunkt> ecken;


    public Polygonzug(Kante[] kante, Set<Eckpunkt> ecken) {
        this.kante = kante;
        this.ecken = ecken;
    }

    public boolean sindKantenVerbunden(Kante[] kante) {
        for (int i = NummerKonstanten.NULL; i < kante.length - NummerKonstanten.EINS; i++) {
            Kante aktuelle = kante[i];
            Kante naechste = kante[i + NummerKonstanten.EINS];

            if (!aktuelle.getEckpunktB().equals(naechste.getEckpunktA())) {
                return false;
            }
        }
        return true;
    }

    public Kante[] getKanten() {
        return kante;
    }

    public Set<Eckpunkt> getEcken() {
        return ecken;
    }
}
