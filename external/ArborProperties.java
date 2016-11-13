/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.external;

import arbor.model.scene.Scene;
import arbor.model.scene.SceneManager;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ArborProperties {

    private static ArborProperties instance = new ArborProperties();

    public static ArborProperties getInstance() {
        return instance;
    }

    private ArborProperties() {
    }

    Document document = null;

    public void init() {
        DocumentBuilder builder;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            document = builder.parse(new File("gamedata.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createScenes() {
        Element root = document.getDocumentElement();
        NodeList sceneElements = root.getElementsByTagName("Scene");
        Class scene = null;
        for (int i = 0; i < sceneElements.getLength(); i++) {
            NodeList info = sceneElements.item(i).getChildNodes();
            String sceneName = "";
            String className = "";
            
            Element element = (Element)info;
            className = element.getElementsByTagName("ClassPath").item(0).getTextContent();
            sceneName = element.getElementsByTagName("SceneName").item(0).getTextContent();
            
            //Create scenes based on classpath and scene name
            try {
                scene = Class.forName(className);
            } catch (Exception e) {
                System.out.println(className);
                e.printStackTrace();
            }
            try {
                SceneManager.getInstance().addScene(sceneName, (Scene) scene.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
