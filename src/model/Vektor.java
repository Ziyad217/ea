package model;

public class Vektor {
private float XKomponente;
private float YKomponente;
private float ZKomponente;

    public Vektor(float XKomponente, float YKomponente, float ZKomponente) {
        this.XKomponente = XKomponente;
        this.YKomponente = YKomponente;
        this.ZKomponente = ZKomponente;
    }

    public float getXKomponente() {
        return XKomponente;
    }

    public float getYKomponente() {
        return YKomponente;
    }

    public float getZKomponente() {
        return ZKomponente;
    }

    public double getLaenge() {
        return Math.sqrt(getXKomponente() * getXKomponente() +
                getYKomponente() * getYKomponente() + getZKomponente() * getZKomponente());
    }
    public Vektor erzeugeVektor(Eckpunkt eckpunkt1, Eckpunkt eckpunkt2){
        float x = eckpunkt1.getXKoordinate() - eckpunkt2.getXKoordinate();
        float y = eckpunkt1.getYKoordinate() - eckpunkt2.getYKoordinate();
        float z = eckpunkt1.getZKoordinate() - eckpunkt2.getZKoordinate();
        return new Vektor(x, y, z);
    }
}
