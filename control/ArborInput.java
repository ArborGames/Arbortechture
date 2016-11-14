/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.control;

import arbor.util.ArborVector;
import arbor.view.Camera;
import javafx.scene.input.KeyCode;
import javax.swing.JPanel;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ArborInput {

    private ArborInput() {

    }

    private static Keyboard keyboard = new Keyboard();
    private static Mouse mouse = new Mouse();

    public static void register(JPanel relativeTo) {
        relativeTo.addKeyListener(keyboard);
        relativeTo.addMouseListener(mouse);
        relativeTo.addMouseMotionListener(mouse);
        relativeTo.addMouseWheelListener(mouse);
    }

    public static void update() {
        keyboard.update();
        mouse.update();
    }

    // ***********************
    //        KEYBOARD
    // ***********************
    public static boolean getKey(KeyCode key) {
        return keyboard.getKey(key);
    }

    public static boolean getKeyDown(KeyCode key) {
        return keyboard.getKeyDown(key);
    }

    public static boolean getKeyUp(KeyCode key) {
        return keyboard.getKeyUp(key);
    }

    // ***********************
    //         MOUSE
    // ***********************
    public static int getMouseWheelDelta() {
        return mouse.getMouseWheelDelta();
    }

    public static boolean getMouseButton(int buttonId) {
        return mouse.getMouseButton(buttonId);
    }

    public static boolean getMouseButtonDown(int buttonId) {
        return mouse.getMouseButtonDown(buttonId);
    }

    public static boolean getMouseButtonUp(int buttonId) {
        return mouse.getMouseButtonUp(buttonId);
    }

    public static ArborVector getMousePosition() {
        return mouse.getMousePosition();
    }

    public static ArborVector getScaledMousePoisition() {
        return ArborVector.div(mouse.getMousePosition(), Camera.main.getScale());
    }
}
