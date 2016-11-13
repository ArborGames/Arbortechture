/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbor.main;

import arbor.control.ArborInput;
import arbor.external.ArborProperties;
import arbor.model.scene.SceneManager;
import arbor.view.ArborView;

/**
 *
 * @author Alexander Ramsay-Baggs
 */
public class ArborMain {

    private static String versionId = "0.0.01";

    public static void main(String args[]) {
        ArborProperties.getInstance().init();
        ArborProperties.getInstance().createScenes();

        //Enter main game loop
        long lastTime = System.currentTimeMillis();
        boolean run = true;
        //Target FPS
        float updateRatePerSecond = 60f;
        float updateInterval = 1000f / updateRatePerSecond;

        while (run) {
            float dt = (float) (System.currentTimeMillis() - lastTime);
            if (dt > updateInterval) {
                SceneManager.getInstance().update();
                ArborView.getInstance().update();
                ArborInput.update();
                lastTime = System.currentTimeMillis();
            }
        }
    }

    public static String getVersion() {
        return versionId;
    }
}
