package controller;

import model.Dreieck;
import model.Eckpunkt;
import model.Kante;
import model.Vektor;
import resources.NummerKonstanten;

public class DreieckController {
    /**
     * Berechnet die Fläche des Dreiecks mit Hilfe des Kreuzprodukts.
     * @return die Fläche als double
     */
    public double berechneFlaeche(Dreieck dreieck)
    {
        VektorController vektorController = new VektorController();

        Eckpunkt a = dreieck.getKanten()[NummerKonstanten.NULL].getEckpunktA();
        Eckpunkt b = dreieck.getKanten()[NummerKonstanten.NULL].getEckpunktB();
        Eckpunkt c;
        if (dreieck.getKanten()[NummerKonstanten.EINS].getEckpunktA() != a &&
                dreieck.getKanten()[NummerKonstanten.EINS].getEckpunktA() != b)
        {
            c = dreieck.getKanten()[NummerKonstanten.EINS].getEckpunktA();
        } else
        {
            c = dreieck.getKanten()[NummerKonstanten.EINS].getEckpunktB();
        }
        Vektor ab = vektorController.erzeugeVektor(b, a);
        Vektor ac = vektorController.erzeugeVektor(c, a);
        Vektor kreuzprodukt = vektorController.berechneKreuzprodukt(ab, ac);
        return NummerKonstanten.DOUBLE_EINHALB * kreuzprodukt.getLaenge();
    }

    /**
     * Berechnet den Umfang des Dreiecks als Summe der Längen aller Kanten.
     * @return Umfang als float
     */

    public float berechneUmfang(Dreieck dreieck)
    {
        float umfang = NummerKonstanten.FLOAT_NULL;

        for (Kante kante : dreieck.getKanten()) {
            Vektor vektor = kante.gebeVektorZurueck();
            umfang += vektor.getLaenge();
        }
        return umfang;
    }
}
