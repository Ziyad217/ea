package model;

public class Kante {
    private Eckpunkt eckpunktA;
    private Eckpunkt eckpunktB;


    public Kante(Eckpunkt eckpunktA, Eckpunkt eckpunktB) {
        this.eckpunktA = eckpunktA;
        this.eckpunktB = eckpunktB;
    }

    public Eckpunkt getEckpunktA() {
        return eckpunktA;
    }

    public Eckpunkt getEckpunktB() {
        return eckpunktB;
    }
    public Vektor gebeVektorZurueck() {
        float x = getEckpunktA().getXKoordinate() - getEckpunktB().getXKoordinate();
        float y = getEckpunktA().getYKoordinate() - getEckpunktB().getYKoordinate();
        float z = getEckpunktA().getZKoordinate() - getEckpunktB().getZKoordinate();
        return new Vektor(x, y, z);    }


}
