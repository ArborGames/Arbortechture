/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbor.model;

import arbor.util.ArborVector;
import arbor.view.Renderable;
import arbor.view.RenderableImpl;
import java.awt.Graphics2D;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public abstract class RenderableObject extends ArborObject implements Renderable {

    private RenderableImpl renderable = new RenderableImpl();

    public RenderableObject() {
    }

    public RenderableObject(float x, float y, float rotation) {
        super(x, y, rotation);
    }

    public RenderableObject(ArborVector position, float rotation) {
        super(position, rotation);
    }
    
    @Override
    public void render(Graphics2D canvas) {
        renderable.render(canvas, (int) position.x, (int) position.y, rotation);
    }

    @Override
    public final void setImage(String imageFileName, int width, int height) {
        renderable.setImage(imageFileName, width, height);
    }
    
}
