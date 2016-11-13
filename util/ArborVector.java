/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.util;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public final class ArborVector implements Cloneable {

    public float x, y;

    public ArborVector() {
        super();
        set(0, 0);
    }

    public ArborVector(float x, float y) {
        super();
        set(x, y);
    }

    public ArborVector(ArborVector copy) {
        super();
        set(copy);
    }

    public ArborVector normalize() {
        float mag = magnitude();
        x /= mag;
        y /= mag;
        return this;
    }

    public ArborVector getNormalized() {
        ArborVector toReturn = new ArborVector(this);
        return toReturn.normalize();
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float sqrMagnitude() {
        return x * x + y * y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(ArborVector copy) {
        x = copy.x;
        y = copy.y;
    }

    public static float angle(ArborVector from, ArborVector to) {
        float deltaX = to.x - from.x;
        float deltaY = to.y - from.y;

        return (float) Math.atan2(deltaY, deltaX);
    }

    public static float distance(ArborVector v1, ArborVector v2) {
        return ArborVector.sub(v1, v2).magnitude();
    }

    public static float dot(ArborVector v1, ArborVector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    //Clamp between 0-1
    public static ArborVector lerp(ArborVector start, ArborVector end, float t) {
        if (t < 0) {
            t = 0;
        } else if (t > 1) {
            t = 1;
        }
        return ArborVector.add(start, ArborVector.mult(ArborVector.sub(end, start), t));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public Object clone() {
        return new ArborVector(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArborVector) {
            ArborVector v = (ArborVector) obj;
            return (x == v.x && y == v.y);
        }
        return false;
    }

    /* **************************************
                VECTOR OPERATORS
       **************************************
        -Each Vector operation has a static
         and non-static version
        -The non-static version commits the
         operation to the Vector it is 
         called from
        -The static version creates a new
         Vector object and DOES NOT commit
         and changes to the Vector it is 
         called from (if it is called from
         one).
        -The non-static methods return
         themselves for the purposes of
         method chaining
     */
    // ADD
    public ArborVector add(ArborVector other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public static ArborVector add(ArborVector v1, ArborVector v2) {
        return new ArborVector(v1.x + v2.x, v1.y + v2.y);
    }

    // SUB
    public ArborVector sub(ArborVector other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    public static ArborVector sub(ArborVector v1, ArborVector v2) {
        return new ArborVector(v1.x - v2.x, v1.y - v2.y);
    }

    // MULT
    public ArborVector mult(float m) {
        this.x *= m;
        this.y *= m;
        return this;
    }

    public static ArborVector mult(ArborVector v, float m) {
        return new ArborVector(v.x * m, v.y * m);
    }

    // DIV
    public ArborVector div(float d) {
        this.x /= d;
        this.y /= d;
        return this;
    }

    public static ArborVector div(ArborVector v, float d) {
        return new ArborVector(v.x * d, v.y * d);
    }
}
