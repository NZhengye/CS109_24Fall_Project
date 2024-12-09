package view.signup;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;

public class SignupFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private LevelFrame levelFrame;

    public SignupFrame(int width, int height) {
        this.setTitle("Signup Frame");
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
            if (this.levelFrame != null) {
                this.levelFrame.setVisible(true);
                this.setVisible(false);
            }

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
