package model;

import controller.VektorController;
import resources.NummerKonstanten;

import java.util.Set;

public class Dreieck extends Polygon {

    public Dreieck(Kante[] kante, Set<Eckpunkt> ecken) {
        super(kante, ecken);
        this.ueberpruefeObDreieck();
    }

    private boolean ueberpruefeObDreieck (){
        if (this.getKanten().length != NummerKonstanten.DREI){
            return false;
        }
        return true;
    }



    @Override
    public double berechneFlaeche() {
        VektorController vektorController = new VektorController();
        Eckpunkt a = getKanten()[NummerKonstanten.NULL].getEckpunktA();
        Eckpunkt b = getKanten()[NummerKonstanten.NULL].getEckpunktB();
        Eckpunkt c = null;

        if (getKanten()[NummerKonstanten.EINS].getEckpunktA() != a && getKanten()[NummerKonstanten.EINS].getEckpunktA() != b) {
            c = getKanten()[NummerKonstanten.EINS].getEckpunktA();
        } else {
            c = getKanten()[NummerKonstanten.EINS].getEckpunktB();
        }
        Vektor ab = vektorController.erzeugeVektor(b, a);
        Vektor ac = vektorController.erzeugeVektor(c, a);
        Vektor kreuzprodukt = vektorController.berechneKreuzprodukt(ab, ac);
        return NummerKonstanten.DOUBLE_EINHALB * kreuzprodukt.getLaenge();
    }

    @Override
    public float berechneUmfang() {
        float umfang = NummerKonstanten.FLOAT_NULL;

        for (Kante kante : this.getKanten()) {
            Vektor vektor = kante.gebeVektorZurueck();
            umfang += vektor.getLaenge();
        }
        return umfang;
    }


}
