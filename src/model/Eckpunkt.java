package model;

public class Eckpunkt {
    private float XKoordinate;
    private float YKoordinate;
    private float ZKoordinate;

    public Eckpunkt(float XKoordinate, float YKoordinate, float ZKoordinate) {
        this.XKoordinate = XKoordinate;
        this.YKoordinate = YKoordinate;
        this.ZKoordinate = ZKoordinate;
    }

    public float getXKoordinate() {
        return XKoordinate;
    }

    public float getYKoordinate() {
        return YKoordinate;
    }

    public float getZKoordinate() {
        return ZKoordinate;
    }

    public Vektor subtrahiere(Eckpunkt eckpunkt) {
        float x = this.getXKoordinate() - eckpunkt.getXKoordinate();
        float y = this.getYKoordinate() - eckpunkt.getYKoordinate();
        float z = this.getZKoordinate() - eckpunkt.getZKoordinate();
        return new Vektor(x, y, z);
    }
}
