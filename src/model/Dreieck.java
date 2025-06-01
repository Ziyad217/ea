package model;

import controller.VektorController;
import resources.NummerKonstanten;

import java.util.Set;

/**
 * Repräsentiert ein Dreieck als spezielle Form eines Polygons mit genau drei Kanten und Ecken.
 * Berechnet Fläche und Umfang des Dreiecks.
 *
 * @author ziyad
 */
public class Dreieck extends Polygon
{

    public Dreieck(Kante[] kanten, Set<Eckpunkt> ecken) {
        super(kanten, ecken);
        this.ueberpruefeObDreieck();
    }

    /**
     * Prüft, ob das Polygon genau drei Kanten hat.
     * @return true, wenn genau drei Kanten vorhanden sind, sonst false.
     */
    private boolean ueberpruefeObDreieck()
    {
        return this.getKanten().length == NummerKonstanten.DREI;
    }

    /**
     * Berechnet die Fläche des Dreiecks mit Hilfe des Kreuzprodukts.
     * @return die Fläche als double
     */
    @Override
    public double berechneFlaeche()
    {
        VektorController vektorController = new VektorController();

        Eckpunkt a = getKanten()[NummerKonstanten.NULL].getEckpunktA();
        Eckpunkt b = getKanten()[NummerKonstanten.NULL].getEckpunktB();
        Eckpunkt c;
        if (getKanten()[NummerKonstanten.EINS].getEckpunktA() != a &&
                getKanten()[NummerKonstanten.EINS].getEckpunktA() != b)
        {
            c = getKanten()[NummerKonstanten.EINS].getEckpunktA();
        } else
        {
            c = getKanten()[NummerKonstanten.EINS].getEckpunktB();
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
    @Override
    public float berechneUmfang()
    {
        float umfang = NummerKonstanten.FLOAT_NULL;

        for (Kante kante : this.getKanten()) {
            Vektor vektor = kante.gebeVektorZurueck();
            umfang += vektor.getLaenge();
        }
        return umfang;
    }
}
