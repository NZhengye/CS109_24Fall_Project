package view.level;

import controller.FrameController;
import model.MapMatrix;
import view.FrameUtil;
import view.game.GameFrame;

import javax.swing.*;
import java.awt.*;

////可以参考GameFrame的文件理解本文件的内容
public class LevelFrame extends JFrame {
    private static FrameController frameController = new FrameController();

    public LevelFrame(int width, int height) {
        this.setTitle("Level");
        this.setLayout(null);
        this.setSize(width, height);
        JButton level1Btn = FrameUtil.createButton(this, "Level1", new Point((int) (0.2 * width) - 65, height/4), 130, 60);
        JButton level2Btn = FrameUtil.createButton(this, "Level2", new Point((int) (0.5 * width) - 65, height/4), 130, 60);
        JButton level3Btn = FrameUtil.createButton(this, "Level3", new Point((int) (0.8 * width) - 65, height/4), 130, 60);
        JButton level4Btn = FrameUtil.createButton(this, "Level4", new Point((int) (0.2 * width) - 65, 3 * height/4 - 100), 130, 60);
        JButton level5Btn = FrameUtil.createButton(this, "Level5", new Point((int) (0.5 * width) - 65, 3 * height/4 - 100) , 130, 60);
        JButton level6Btn = FrameUtil.createButton(this, "Level6", new Point((int) (0.8 * width) - 65, 3 * height/4 - 100), 130, 60);

        level1Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1},
                    {1, 20, 0, 0, 0, 1},
                    {1, 0, 0, 10, 2, 1},
                    {1, 0, 2, 10, 0, 1},
                    {1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level2Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1, 0},
                    {1, 20, 0, 0, 0, 1, 1},
                    {1, 0, 10, 10, 0, 0, 1},
                    {1, 0, 1, 2, 0, 2, 1},
                    {1, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level3Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {0, 0, 1, 1, 1, 1, 0},
                    {1, 1, 1, 0, 0, 1, 0},
                    {1, 20, 0, 2, 10, 1, 1},
                    {1, 0, 0, 0, 10, 0, 1},
                    {1, 0, 1, 2, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level4Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {0, 1 ,1 ,1 ,1 ,1 ,0},
                    {1, 1, 20, 0, 0, 1, 1},
                    {1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 10, 12, 10, 0, 1},
                    {1, 0, 0, 2, 0, 0, 1},
                    {1, 1, 0, 2, 0, 1, 1},
                    {0, 1, 1, 1, 1, 1, 0},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level5Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 0, 0, 1, 1, 1},
                    {1, 0, 0, 0, 2, 2, 0, 1},
                    {1, 0, 10, 10, 10, 20, 0, 1},
                    {1, 0, 0, 1, 0, 2, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level6Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 2, 0, 1, 0, 2, 1},
                    {1, 0, 10, 10, 10, 0, 1},
                    {1, 2, 0, 1, 2, 0, 1},
                    {1, 0, 10, 20, 10, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });


        frameController.setLevelFrame(this);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static FrameController getFrameController() {
        return frameController;
    }

}
