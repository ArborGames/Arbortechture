/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
class Keyboard implements KeyListener {

    private Map<String, Boolean> prevKeyboard = new HashMap<>();
    private Map<String, Boolean> currKeyboard = new HashMap<>();

    @Override
    public void keyTyped(KeyEvent e) {
        //Dont use, use keypressed instead
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currKeyboard.put(KeyEvent.getKeyText(e.getKeyCode()), Boolean.TRUE);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currKeyboard.put(KeyEvent.getKeyText(e.getKeyCode()), Boolean.FALSE);
    }

    void update() {
        prevKeyboard = currKeyboard;
    }

    public boolean getKey(KeyCode key) {
        return currKeyboard.getOrDefault(key.toString(), Boolean.FALSE);
    }
    
    //TODO: Other 'getKey' type functions, e.g. getKeyDown()
}
