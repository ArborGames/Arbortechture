/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.control;

import javafx.scene.input.KeyCode;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ArborInput {

    private ArborInput() {

    }

    private static Keyboard keyboard = new Keyboard();

    public static void update() {
        keyboard.update();
    }

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    public static boolean getKey(KeyCode key) {
        return keyboard.getKey(key);
    }
}
