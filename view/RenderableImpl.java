/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view;

import arbor.util.ArborVector;
import java.awt.Graphics2D;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class RenderableImpl implements Renderable {

    private Image sprite = null;
    private int width;
    private int height;

    @Override
    public void setImage(String imageFileName, int width, int height) {
        sprite = ImageStore.getInstance().getImage(imageFileName);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics2D canvas) {
        //This shouldn't really be used. As a default, this will simply draw the image at position (0,0) with no rotation
        canvas.drawImage(sprite, 0, 0, ArborView.getInstance().view);
    }

    public void render(Graphics2D canvas, int x, int y, float rotation) {
        if (sprite == null) {
            return;
        }
        float scale = Camera.main.getScale();
        ArborVector camPos = Camera.main.getPosition();
        AffineTransform transform = new AffineTransform();
        transform.translate((x + camPos.x) * scale, (y + camPos.y) * scale);
        transform.rotate(rotation, (width / 2) * scale, (width / 2) * scale);
        canvas.drawImage(sprite.getScaledInstance((int)(width * scale), (int)(height * scale), SCALE_SMOOTH), transform, ArborView.getInstance().view);
    }
}
