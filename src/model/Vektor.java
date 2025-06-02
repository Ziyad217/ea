package model;

/**
 * Repräsentiert einen Vektor im 3D-Raum mit x-, y- und z-Komponenten.
 *
 * @author ziyad
 */
public class Vektor
{
    private float XKomponente;
    private float YKomponente;
    private float ZKomponente;

    /**
     * Konstruktor zum Erzeugen eines Vektors mit den angegebenen Komponenten.
     *
     * @param XKomponente x-Komponente des Vektors
     * @param YKomponente y-Komponente des Vektors
     * @param ZKomponente z-Komponente des Vektors
     */
    public Vektor(float XKomponente, float YKomponente, float ZKomponente)
    {
        this.XKomponente = XKomponente;
        this.YKomponente = YKomponente;
        this.ZKomponente = ZKomponente;
    }

    public float getXKomponente()
    {
        return XKomponente;
    }

    public float getYKomponente()
    {
        return YKomponente;
    }

    public float getZKomponente()
    {
        return ZKomponente;
    }

    public double getLaenge()
    {
        return Math.sqrt(getXKomponente() * getXKomponente() +
                getYKomponente() * getYKomponente() + getZKomponente() * getZKomponente());
    }

}
