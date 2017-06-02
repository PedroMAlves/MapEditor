package org.academiadecodigo.bootcamp8.Grid;

/**
 * Created by Prashanta on 31/05/17.
 */
public enum GridColor {
    BLUE(1),
    GREEN(2),
    RED(3),
    ORANGE(4),
    PINK(5),
    MAGENTA(6),
    BLACK(7),
    LIGHT_GRAY(8);

    private int colorIndex;
    GridColor(int ind){
        colorIndex = ind;
    }

    public int getColorIndex() {
        return colorIndex;
    }
}
