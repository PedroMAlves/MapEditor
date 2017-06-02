package org.academiadecodigo.bootcamp8.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by Prashanta on 31/05/17.
 */
public class GridColorMapper {
    private static final Color colors[] = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.LIGHT_GRAY,
            Color.BLACK,
            Color.ORANGE,
            Color.PINK
    };

    public static Color getColor(GridColor color){

        Color sGfxColor = null;

        switch (color) {
            case RED:
                sGfxColor = colors[0];
                break;
            case GREEN:
                sGfxColor = colors[1];
                break;
            case BLUE:
                sGfxColor = colors[2];
                break;
            case MAGENTA:
                sGfxColor = colors[3];
                break;
            case LIGHT_GRAY:
                sGfxColor = colors[4];
                break;
            case BLACK:
                sGfxColor = colors[5];
                break;
            case ORANGE:
                sGfxColor = colors[6];
                break;
            case PINK:
                sGfxColor = colors[7];
                break;
            default:
                System.out.println("something went terribly wrong...");
        }

        return sGfxColor;
    }
}
