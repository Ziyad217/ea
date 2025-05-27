package controller;

import model.Eckpunkt;
import model.Vektor;
import model.VektorMathematik;

public class VektorController implements VektorMathematik {
    @Override
    public Vektor addiere(Vektor v1, Vektor v2) {
        return new Vektor(
                v1.getXKomponente() + v2.getXKomponente(),
                v1.getYKomponente() + v2.getYKomponente(),
                v1.getZKomponente() + v2.getZKomponente()
        );
    }

    @Override
    public Vektor subtrahiere(Vektor v1, Vektor v2) {
        return new Vektor(
                v1.getXKomponente() - v2.getXKomponente(),
                v1.getYKomponente() - v2.getYKomponente(),
                v1.getZKomponente() - v2.getZKomponente()
        );
    }

    @Override
    public Vektor berechneKreuzprodukt(Vektor v1, Vektor v2) {
        float x = v1.getYKomponente() * v2.getZKomponente() - v1.getZKomponente() * v2.getYKomponente();
        float y = v1.getZKomponente() * v2.getXKomponente() - v1.getXKomponente() * v2.getZKomponente();
        float z = v1.getXKomponente() * v2.getYKomponente() - v1.getYKomponente() * v2.getXKomponente();
        return new Vektor(x, y, z);
    }

    public Vektor erzeugeVektor(Eckpunkt eckpunkt1, Eckpunkt eckpunkt2){
        float x = eckpunkt1.getXKoordinate() - eckpunkt2.getXKoordinate();
        float y = eckpunkt1.getYKoordinate() - eckpunkt2.getYKoordinate();
        float z = eckpunkt1.getZKoordinate() - eckpunkt2.getZKoordinate();
        return new Vektor(x, y, z);
    }
}
