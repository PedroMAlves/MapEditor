package org.academiadecodigo.bootcamp8;

import org.academiadecodigo.bootcamp8.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by Prashanta on 31/05/17.
 */
public class MapEditor {
    private Controller controller;
    private StateKeeper keeper;
    private Pointer pointer;
    private Grid grid;

    public MapEditor(){
        controller = new Controller();
        keeper = new StateKeeper();
        grid = new Grid(30, 30);
        pointer = new Pointer(grid.makeGridPosition(15, 15), grid);
    }

    public void init(){
        grid.init();
    }

    public void action(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        switch (key) {
            case KeyboardEvent.KEY_UP:
                pointer.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                pointer.moveDown();
                break;
            case KeyboardEvent.KEY_LEFT:
                pointer.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                pointer.moveRight();
                break;
            case KeyboardEvent.KEY_S:
                keeper.saveState(grid);
                break;
            case KeyboardEvent.KEY_L:
                keeper.loadState(grid);
                break;
            case KeyboardEvent.KEY_SPACE:
                pointer.togglePaint();
                break;
            case KeyboardEvent.KEY_C:
                pointer.changeColor();
                break;
            case KeyboardEvent.KEY_R:
                pointer.clearAll();
                break;
        }
    }

    private class Controller implements KeyboardHandler {
        private Keyboard myKey;
        private KeyboardEvent[] events;

        public Controller() {
            myKey = new Keyboard(this);
            events = new KeyboardEvent[18];
            createEvent();
            setEvents();
            addEventListener();
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            action(keyboardEvent);
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {}

        public void createEvent() {
            for (int i = 0; i < events.length; i++) {
                events[i] = new KeyboardEvent();
            }
        }

        public void addEventListener() {
            for (KeyboardEvent event : events) {
                myKey.addEventListener(event);
            }
        }

        public void setEvents() {
            events[0].setKey(KeyboardEvent.KEY_UP);
            events[0].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[1].setKey(KeyboardEvent.KEY_DOWN);
            events[1].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[2].setKey(KeyboardEvent.KEY_LEFT);
            events[2].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[3].setKey(KeyboardEvent.KEY_RIGHT);
            events[3].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[4].setKey(KeyboardEvent.KEY_UP);
            events[4].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[5].setKey(KeyboardEvent.KEY_DOWN);
            events[5].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[6].setKey(KeyboardEvent.KEY_LEFT);
            events[6].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[7].setKey(KeyboardEvent.KEY_RIGHT);
            events[7].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[8].setKey(KeyboardEvent.KEY_S);
            events[8].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[9].setKey(KeyboardEvent.KEY_L);
            events[9].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[10].setKey(KeyboardEvent.KEY_SPACE);
            events[10].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[11].setKey(KeyboardEvent.KEY_S);
            events[11].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[12].setKey(KeyboardEvent.KEY_L);
            events[12].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[13].setKey(KeyboardEvent.KEY_SPACE);
            events[13].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[14].setKey(KeyboardEvent.KEY_C);
            events[14].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[15].setKey(KeyboardEvent.KEY_C);
            events[15].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            events[16].setKey(KeyboardEvent.KEY_R);
            events[16].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            events[17].setKey(KeyboardEvent.KEY_R);
            events[17].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        }
    }
}
