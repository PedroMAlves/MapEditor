package org.academiadecodigo.bootcamp8.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by Prashanta on 31/05/17.
 */
public class GridPosition {
    private int col;
    private int row;
    private GridColor color;
    private Grid grid;
    private boolean painted;
    private Rectangle rectangle;


    public GridPosition(int col, int row, Grid grid){
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.color = GridColor.BLACK;
        rectangle = new Rectangle(grid.columnToX(col),
                grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        draw();
    }

    public Grid getGrid() {
        return grid;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isPainted() {
        return painted;
    }

    public void draw() {
        setColor(GridColor.BLACK);
        rectangle.draw();
    }

    public void show(){
        rectangle.fill();
    }

    public void togglePaint(GridColor color) {
        if (painted) {
            draw();
            painted = false;
            return;
        }
        if (!painted){
            painted = true;
            setColor(color);
            show();
        }
    }

    public GridColor getColor() {
        return color;
    }

    public void setColor(GridColor color) {
        rectangle.setColor(GridColorMapper.getColor(color));
        this.color = color;
        show();
    }

    public void moveInDirection(GridDirection direction) {
        switch (direction) {
            case UP:
                if (getRow() - 1 >= 0) {
                    setPos(getCol(), getRow() -1);
                    rectangle.translate(0, -grid.getCellSize());
                }
                break;
            case DOWN:
                if (getRow() + 1 <= grid.getRows() -1){
                    setPos(getCol(), getRow() +1);
                    rectangle.translate(0, grid.getCellSize());
                }
                break;
            case LEFT:
                if (getCol() - 1 >= 0) {
                    setPos(getCol() -1, getRow());
                    rectangle.translate(-grid.getCellSize(), 0);
                }
                break;
            case RIGHT:
                if (getCol() +1 <= grid.getCols() -1){
                    setPos(getCol() +1, getRow());
                    rectangle.translate(grid.getCellSize(), 0);
                }
                break;
        }
    }
}

