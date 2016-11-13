/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.model.scene;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class SceneManager {

    private static SceneManager instance = new SceneManager();

    public static SceneManager getInstance() {
        return instance;
    }

    private SceneManager() {
    }

    private Map<String, Scene> scenes = new HashMap<>();
    private Scene currentScene = null;

    public boolean addScene(String name, Scene scene) {
        if (scenes.putIfAbsent(name, scene) == null) {
            if (currentScene == null) {
                currentScene = scene;
                scene.onEnter();
            }
            return true;
        }

        return false;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public boolean changeScene(String sceneName) {
        Scene newScene = scenes.get(sceneName);
        if (newScene == null) {
            System.out.println("Cannot change scene: Scene " + sceneName + " does not exist.");
            return false;
        }
        if (newScene == currentScene) {
            System.out.println("Reseting scene. Are you sure you should do this via changeScene()?");
        }

        currentScene.onExit();
        currentScene = newScene;
        currentScene.onEnter();
        return true;
    }

    public void update() {
        currentScene.update();
    }

    public void render(Graphics2D canvas) {
        currentScene.render(canvas);
    }
}
