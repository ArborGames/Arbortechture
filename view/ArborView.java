/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view;

import arbor.control.ArborInput;
import arbor.model.scene.SceneManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ArborView extends JFrame {

    private static ArborView instance = new ArborView();

    public static ArborView getInstance() {
        return instance;
    }

    class ViewPanel extends JPanel {

        @Override
        public void paintComponent(Graphics toDraw) {
            super.paintComponent(toDraw);

            Graphics2D spriteBatch = (Graphics2D) toDraw;

            //Clear background
            spriteBatch.setColor(Color.BLACK);
            spriteBatch.fillRect(0, 0, getSize().width, getSize().height);
            SceneManager.getInstance().render(spriteBatch);
        }
    }

    ViewPanel view;

    private ArborView() {
        //TODO: Use args/properties file for window initialization
        super("Game Title");

        setSize(1600, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        view = new ViewPanel();
        add(view);
        setResizable(false);    //TODO: Improve and allow for manual resizing?
        setVisible(true);
        
        ArborInput.register(this);
    }

    public void update() {
        repaint();
    }
}
