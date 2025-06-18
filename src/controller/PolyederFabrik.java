package controller;

import model.Dreieck;
import model.Polyeder;

public class PolyederFabrik {
public Polyeder erstellePolyeder (Dreieck[] dreiecke){
    return new Polyeder(dreiecke);
}
}
