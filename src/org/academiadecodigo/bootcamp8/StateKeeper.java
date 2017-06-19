package org.academiadecodigo.bootcamp8;

import org.academiadecodigo.bootcamp8.grid.Grid;
import org.academiadecodigo.bootcamp8.grid.GridColor;
import org.academiadecodigo.bootcamp8.grid.GridPosition;

import java.io.*;

/**
 * Created by Prashanta on 31/05/17.
 */
public class StateKeeper {
    private static final String FILE_PATH = "resources/statekeeperlog.txt";


    public StateKeeper() {}

    public void saveState(Grid grid){
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;
        String str = "";
        for (GridPosition pos: grid) {
            if (pos.isPainted()){

                str += pos.getColor().getColorIndex();
            } else {
                str += "0";
            }
        }

        try {
            fWriter = new FileWriter(FILE_PATH);
            bWriter = new BufferedWriter(fWriter);
            bWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bWriter.flush();
                bWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadState(Grid grid) {
        FileReader fReader = null;
        BufferedReader bReader;

        try {
            fReader = new FileReader(FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bReader = new BufferedReader(fReader);
        try {
            String line;
            int i = 0;
            if ((line = bReader.readLine()) != null) {
                for (GridPosition pos : grid) {

                    switch (line.charAt(i)) {
                        case '0':
                            pos.draw();
                            break;
                        case '1':
                            pos.setColor(GridColor.BLUE);
                            pos.show();
                            break;
                        case '2':
                            pos.setColor(GridColor.GREEN);
                            pos.show();
                            break;
                        case '3':
                            pos.setColor(GridColor.RED);
                            pos.show();
                            break;
                        case '4':
                            pos.setColor(GridColor.ORANGE);
                            pos.show();
                            break;
                        case '5':
                            pos.setColor(GridColor.PINK);
                            pos.show();
                            break;
                    }
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


