/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view.ui;

import arbor.control.ArborInput;
import arbor.model.RenderableObject;
import arbor.util.ArborVector;
import java.util.function.Function;

/**
 *
 * @author a.c.ramsay-baggs
 */
public abstract class UIObject extends RenderableObject {
    //TODO: OnClick? OnHover? etc.

    protected ArborVector size = new ArborVector();

    boolean isHover = false;

    private Function onClick = null;

    protected void onClick() {
        if (onClick != null) {
            onClick.apply(null);
        }
    }

    public UIObject(ArborVector position, ArborVector size) {
        this.position = position;
        this.size = size;
    }

    public void setOnClick(Function func) {
        onClick = func;
    }

    private Function onHover = null;

    protected void onHover() {
        if (onHover != null) {
            onHover.apply(null);
        }
        System.out.println("HOVER");
    }

    public void setOnHover(Function func) {
        onHover = func;
    }

    private Function onNotHover = null;

    protected void onNotHover() {
        if (onNotHover != null) {
            onNotHover.apply(null);
        }
    }

    public void setOnNotHover(Function func) {
        onNotHover = func;
    }

    @Override
    public void update() {
        boolean flag = false;
        //Get mouse position
        ArborVector v = ArborInput.getMousePosition();
        v = ArborVector.sub(v, position);
        if (v.x >= 0 && v.y >= 0 && v.x < size.x && v.y < size.y) {
            isHover = true;
            flag = true;
            onHover();
            if (ArborInput.getMouseButtonDown(1)) {
                onClick();
            }
        }
        if (!flag && isHover) {
            isHover = false;
            onNotHover();
        }
    }
}
