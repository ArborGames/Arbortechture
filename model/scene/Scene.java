/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbor.model.scene;

import java.awt.Graphics2D;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public abstract class Scene {
    
    public abstract boolean onExit();
    public abstract boolean onEnter();
    public abstract void update();
    public abstract void render(Graphics2D canvas);
}
