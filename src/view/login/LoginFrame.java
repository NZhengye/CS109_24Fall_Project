package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;

//可以参考GameFrame的文件理解本文件的内容
//todo: Add a window for user information verification(advanced part)
//todo: Add a button to jump to the registration window(advanced part)
//todo: When click the Confirm button, jump to the LevelFrame and load the User Archive
public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private LevelFrame levelFrame;

    public LoginFrame(int width, int height) {
        this.setTitle("Login Frame");
        this.setLayout(null);
        this.setSize(width, height);
        JLabel userLabel = FrameUtil.createJLabel(this, new Point(100, 100), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(100, 210), 70, 40, "password:");
        username = FrameUtil.createJTextField(this, new Point(200, 100), 250, 40);
        password = FrameUtil.createJTextField(this, new Point(200, 210), 250, 40);

        submitBtn = FrameUtil.createButton(this, "Confirm", new Point(150, 320), 100, 40);
        resetBtn = FrameUtil.createButton(this, "Reset", new Point(350, 320), 100, 40);

        submitBtn.addActionListener(e -> {
            System.out.println("Username = " + username.getText());
            System.out.println("Password = " + password.getText());
//            LevelFrame levelFrame = new LevelFrame(600,450);
//            setVisible(false);
//            levelFrame.setVisible(true);
//            System.out.println("check");
//            if (this.levelFrame == null) {
//                System.out.println("levelFrame != null");
//                this.levelFrame.setVisible(true);
//                this.setVisible(false);
//            }
            //todo: check login info

        });
        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }
}
