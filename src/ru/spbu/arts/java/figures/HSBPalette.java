package ru.spbu.arts.java.figures;

import javafx.scene.paint.Color;

public interface HSBPalette {
    static Color getColor(double c){
        return Color.hsb(c * 360, 1 ,1);
    }
}
