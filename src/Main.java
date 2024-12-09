import view.level.LevelFrame;
import view.login.LoginFrame;
import view.signup.SignupFrame;
import view.start.StartFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame startframe = new StartFrame(600,450);
            startframe.setVisible(true);
            LoginFrame loginFrame = new LoginFrame(600,450);
            loginFrame.setVisible(false);
            SignupFrame signupframe = new SignupFrame(600,450);
            signupframe.setVisible(false);
//            LevelFrame levelFrame = new LevelFrame(600,450);
//            levelFrame.setVisible(false);
//            loginFrame.setLevelFrame(levelFrame);
        });
    }
}
