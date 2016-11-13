/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view;

import java.awt.Graphics2D;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public interface Renderable {

    public void render(Graphics2D canvas);

    public void setImage(String imageFileName, int width, int height);
}
