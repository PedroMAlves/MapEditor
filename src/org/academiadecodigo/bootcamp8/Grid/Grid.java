package org.academiadecodigo.bootcamp8.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Prashanta on 31/05/17.
 */
public class Grid implements Iterable<GridPosition>{
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private int cellSize;
    private Rectangle rect;
    private List<GridPosition> list;


    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        cellSize = 20;
    }

    public void init() {
        rect = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rect.draw();
        list = new ArrayList<>();
        for (int i = 0; i < getCols(); i++){
            for(int j = 0; j < getRows(); j++){
              list.add(makeGridPosition(i, j));
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return rect.getWidth();
    }

    public int getHeight() {
        return rect.getHeight();
    }

    public int getX() {
        return rect.getX();
    }

    public int getY() {
        return rect.getY();
    }

    public int getCellSize() {
        return cellSize;
    }

    public GridPosition makeGridPosition(int col, int row) {
        return new GridPosition(col, row, this);
    }

    public void paintPos(GridPosition pos, GridColor color){
        for (GridPosition position : list) {
            if (pos.getCol() == position.getCol() && pos.getRow() == position.getRow()){
                position.togglePaint(color);
            }
        }
    }

    public void clearAll(){
        for (GridPosition position : list) {
            position.draw();
        }
    }

    public int rowToY(int row) {
        return (row*cellSize) + PADDING;
    }

    public int columnToX(int column) {
        return (column*cellSize) + PADDING;
    }

    @Override
    public Iterator<GridPosition> iterator() {
        return list.iterator();
    }
}

