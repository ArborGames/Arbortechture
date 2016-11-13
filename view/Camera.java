/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view;

import arbor.util.ArborVector;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class Camera {

    public static Camera main = new Camera();

    private Camera() {
    };
    
    private ArborVector position = new ArborVector();
    private float scale = 1f;

    public ArborVector getPosition(){
        return position;
    }
    
    public void setPosition(ArborVector newPosition) {
        position = newPosition;
    }

    public void translate(ArborVector translate) {
        position.x += translate.x;
        position.y += translate.y;
    }

    public void setScale(float newScale) {
        scale = newScale;
    }

    public void shiftScale(float scaleShift) {
        scale += scaleShift;
    }

    public float getScale() {
        return scale;
    }
}
