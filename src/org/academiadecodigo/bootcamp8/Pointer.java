package org.academiadecodigo.bootcamp8;

import org.academiadecodigo.bootcamp8.grid.Grid;
import org.academiadecodigo.bootcamp8.grid.GridColor;
import org.academiadecodigo.bootcamp8.grid.GridDirection;
import org.academiadecodigo.bootcamp8.grid.GridPosition;

/**
 * Created by Prashanta on 31/05/17.
 */
public class Pointer {
    private Grid grid;
    private GridPosition pos;
    private GridColor color;
    private int colorChanger;

    public Pointer(GridPosition pos, Grid grid){
        this.grid = grid;
        this.pos = pos;
        color = GridColor.BLUE;
        pos.setColor(color);
        pos.show();
        colorChanger = 0;
    }

    public void changeColor(){
        if (colorChanger == 0){
            color = GridColor.GREEN;
            pos.setColor(color);
            colorChanger = 1;
            return;
        }
        if (colorChanger == 1){
            color = GridColor.RED;
            pos.setColor(color);
            colorChanger = 2;
            return;
        }
        if (colorChanger == 2){
            color = GridColor.ORANGE;
            pos.setColor(color);
            colorChanger = 3;
            return;
        }
        if (colorChanger == 3){
            color = GridColor.PINK;
            pos.setColor(color);
            colorChanger = 4;
            return;
        }
        if (colorChanger == 4){
            color = GridColor.BLUE;
            pos.setColor(color);
            colorChanger = 0;
        }


    }

    public void moveUp(){
        pos.moveInDirection(GridDirection.UP);
    }

    public void moveDown(){
        pos.moveInDirection(GridDirection.DOWN);
    }

    public void moveLeft(){
        pos.moveInDirection(GridDirection.LEFT);
    }

    public void moveRight(){
        pos.moveInDirection(GridDirection.RIGHT);
    }

    public void togglePaint(){
        grid.paintPos(pos, color);
    }

    public void clearAll(){
        grid.clearAll();
    }
}