package ru.spbu.arts.java.figures;

import javafx.scene.paint.Color;

public interface GrayscalePalette {
    static Color getColor(double c){
        return Color.gray(c);
    }
}
