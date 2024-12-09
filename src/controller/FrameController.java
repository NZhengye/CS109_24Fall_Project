package controller;

import model.MapMatrix;
import util.FileUtil;
import view.game.GameFrame;
import view.level.LevelFrame;

import java.util.List;

public class FrameController {
    private LevelFrame levelFrame;
    FileUtil fileUtil = new FileUtil();

    public LevelFrame getLevelFrame() {
        return levelFrame;
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }

    public void returnLevelFrame(GameFrame frame) {
        frame.dispose();
        levelFrame.setVisible(true);
    }

    public void loadGame(String path, GameFrame frame) {
        System.out.println(path);
        List<String> lines = fileUtil.readFileToList(path);

        int[][] map = new int[lines.size()][];
        //无法解析的文件（如把一个0变成abcd）需要额外判断
        for (int i = 0; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(" ");
            map[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                map[i][j] = Integer.parseInt(elements[j]);
            }
        }
        frame.dispose();
        MapMatrix mapMatrix = new MapMatrix(map);
        GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
        gameFrame.setVisible(true);
    }

    public void saveGame(String path, GameFrame frame) {}
}
