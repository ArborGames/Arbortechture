/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.control;

import arbor.util.ArborVector;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {

    private Map<Integer, Boolean> prevMouse = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> currMouse = new HashMap<Integer, Boolean>();
    ArborVector mousePosition = new ArborVector();
    private int mouseWheelDelta = 0;

    void update() {
        prevMouse.putAll(currMouse);
    }

    //TODO: Implement all mouse methods
    @Override
    public void mouseClicked(MouseEvent e) {
        //Use mouse pressed/released instead
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currMouse.put(e.getButton(), Boolean.TRUE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currMouse.put(e.getButton(), Boolean.FALSE);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //User should do this themselves using getMouse and mouseMoved (positional data)
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition.set(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        mouseWheelDelta = e.getScrollAmount();
    }

    //Accessor methods
    public int getMouseWheelDelta() {
        return mouseWheelDelta;
    }

    public boolean getMouseButton(int buttonId) {
        return currMouse.getOrDefault(buttonId, Boolean.FALSE);
    }

    public boolean getMouseButtonDown(int buttonId) {
        return (!prevMouse.getOrDefault(buttonId, Boolean.FALSE) && currMouse.getOrDefault(buttonId, Boolean.FALSE));
    }

    public boolean getMouseButtonUp(int buttonId) {
        return (prevMouse.getOrDefault(buttonId, Boolean.FALSE) && !currMouse.getOrDefault(buttonId, Boolean.FALSE));
    }

    public ArborVector getMousePosition() {
        return mousePosition;
    }
    
    //TODO: MousePositionDelta?
}
