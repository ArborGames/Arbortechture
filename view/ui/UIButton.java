/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view.ui;

import arbor.util.ArborVector;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

/**
 *
 * @author a.c.ramsay-baggs
 */
public class UIButton extends UIObject{

    Color col = Color.BLACK;
    
    public UIButton(ArborVector position, ArborVector size) {
        super(position, size);
        setOnHover((i) -> {col = Color.RED; return null;});
        setOnNotHover((i) -> {col = Color.BLACK; return null;});
    }
    
    @Override
    public void render(Graphics2D canvas) {
        Stroke old = canvas.getStroke();
        canvas.setStroke(new BasicStroke(10));
        canvas.setColor(Color.GRAY);
        canvas.draw(new Rectangle((int)position.x, (int)position.y, (int)size.x, (int)size.y));
        canvas.setStroke(old);
        canvas.setColor(col);
        canvas.fill(new Rectangle((int)position.x, (int)position.y, (int)size.x, (int)size.y));
    }
}
