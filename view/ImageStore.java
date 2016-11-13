/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ImageStore {

    private static ImageStore instance = new ImageStore();

    public static ImageStore getInstance() {
        return instance;
    }
    
    private ImageStore() {}

    private Map<String, Image> images = new HashMap<>();

    public Image getImage(String imageName) {
        Image image = images.get(imageName);
        if(image == null)
        {
            try {
                image = ImageIO.read(new File("images/" + imageName));
                images.put(imageName, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return image;
    }

    public boolean addImage(String imageName, Image image) {
        if(images.putIfAbsent(imageName, image) == null)
        {
            //Image succesfully put into map
            return true;
        }
        //Image already exists in map
        System.out.println("You should have checked if image " + imageName + " was already created. It was.");
        return false;
    }
}
