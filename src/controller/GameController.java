package controller;

import model.Direction;
import model.MapMatrix;
import view.game.Box;
import view.game.GamePanel;
import view.game.GridComponent;
import view.game.Hero;

/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 * You can design several methods about the game logic in this class.
 */
public class GameController {
    private final GamePanel view;
    private final MapMatrix model;

    public GameController(GamePanel view, MapMatrix model) {
        this.view = view;
        this.model = model;
        view.setController(this);
    }

    public void restartGame() {
        System.out.println("Do restart game here");
        this.model.resetMapMatrix();
        this.view.restartGame();
    }

    public boolean doMove(int row, int col, Direction direction) {
        GridComponent currentGrid = view.getGridComponent(row, col);
        //target row can column.
        int tRow = row + direction.getRow();
        int tCol = col + direction.getCol();
        GridComponent targetGrid = view.getGridComponent(tRow, tCol);
        int[][] map = model.getMatrix();
        if (map[tRow][tCol] == 0 || map[tRow][tCol] == 2) {
            //update hero in MapMatrix
            model.getMatrix()[row][col] -= 20;
            model.getMatrix()[tRow][tCol] += 20;
            //Update hero in GamePanel
            Hero h = currentGrid.removeHeroFromGrid();
            targetGrid.setHeroInGrid(h);
            //Update the row and column attribute in hero
            h.setRow(tRow);
            h.setCol(tCol);
            return true;
        } else if (map[tRow][tCol] / 10 == 1) {
            int boxTRow = tRow + direction.getRow();
            int boxTCol = tCol + direction.getCol();
            GridComponent boxTargetGrid = view.getGridComponent(boxTRow, boxTCol);
            if (map[boxTRow][boxTCol] == 0 || map[boxTRow][boxTCol] == 2) {
                //update hero in MapMatrix
                model.getMatrix()[row][col] -= 20;
                model.getMatrix()[tRow][tCol] += 20;
                //update box in MapMatrix
                model.getMatrix()[tRow][tCol] -= 10;
                model.getMatrix()[boxTRow][boxTCol] += 10;
                //Update hero in GamePanel
                Hero h = currentGrid.removeHeroFromGrid();
                targetGrid.setHeroInGrid(h);
                //Update the box in GamePanel
                Box b = targetGrid.removeBoxFromGrid();
                boxTargetGrid.setBoxInGrid(b);
                //Update the row and column attribute in hero
                h.setRow(tRow);
                h.setCol(tCol);
                return true;
            }
        }
        return false;
    }

    public boolean checkVictory(MapMatrix model) {
        int[][] map = model.getMatrix();
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {
                if (map[i][j] == 2 || map[i][j] == 10) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkFail(MapMatrix model) {
        //todo: Iterate the code related to checkFail
        int[][] map = model.getMatrix();
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {
                if (map[i][j] == 12){break;}
                if (map[i][j] / 10 == 1) {
                    if ((map[i + 1][j] == 1 && map[i][j - 1] == 1) ||
                            (map[i + 1][j] == 1 && map[i][j + 1] == 1) ||
                            (map[i - 1][j] == 1 && map[i][j - 1] == 1) ||
                            (map[i - 1][j] == 1 && map[i][j + 1] == 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //todo: add other methods such as loadGame, saveGame...
    //todo: 还有回溯功能，可以实现一个栈，每次移动的时候将当前的状态压入栈中，当用户点击回溯的时候，将栈顶的状态弹出，然后重新绘制

}
