/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.model;

import arbor.util.ArborVector;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public abstract class ArborObject {

    protected ArborVector position = new ArborVector();
    protected float rotation = 0;

    public ArborObject() {
    }

    public ArborObject(float x, float y, float rotation) {
        position.set(x, y);
        this.rotation = rotation;
    }
    
    public ArborObject(ArborVector position, float rotation){
        this.position = position;
        this.rotation = rotation;
    }

    public ArborVector getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public abstract void update();

    @Override
    public String toString() {
        return "Position: " + position.toString() + ", Rotation: " + rotation;
    }
}
