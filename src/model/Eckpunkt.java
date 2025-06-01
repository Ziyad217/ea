package model;

/**
 * Repräsentiert einen Punkt im 3D-Raum mit x-, y- und z-Koordinate.
 * @author ziyad
 */
public class Eckpunkt
{
    private final float XKoordinate;
    private final float YKoordinate;
    private final float ZKoordinate;

    /**
     * Konstruktor zum Erzeugen eines Eckpunkts mit den angegebenen Koordinaten.
     * @param XKoordinate x-Koordinate des Punktes
     * @param YKoordinate y-Koordinate des Punktes
     * @param ZKoordinate z-Koordinate des Punktes
     */
    public Eckpunkt(float XKoordinate, float YKoordinate, float ZKoordinate)
    {
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
}
