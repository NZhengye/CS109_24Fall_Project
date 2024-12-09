package view.start;

import view.FrameUtil;
import view.level.LevelFrame;
import view.login.LoginFrame;
import view.signup.SignupFrame;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    /*
    todo: design a frame for the start of the game
    todo: 'log in', 'sign up', 'guest mode', 'help', 'exit' buttons
    many things todo
    */
    private JButton LoginBtn;
    private JButton SignupBtn;
    private JButton GuestModeBtn;
    private JButton HelpBtn;
    private JButton ExitBtn;

    public StartFrame(int width, int height) {
        this.setTitle("Start Frame");
        this.setLayout(null);
        this.setSize(width, height);

        LoginBtn = FrameUtil.createButton(this, "Login", new Point(250, 50), 100, 40);
        SignupBtn = FrameUtil.createButton(this, "Sign up", new Point(250, 128), 100, 40);
        GuestModeBtn = FrameUtil.createButton(this,"GuestMode",new Point(250,205),100,40);
        HelpBtn = FrameUtil.createButton(this,"Help",new Point(250,282),100,40);
        ExitBtn = FrameUtil.createButton(this,"Exit",new Point(250,360),100,40);

        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame(600,450);
                setVisible(false);
                loginFrame.setVisible(true);

            }
        });

        SignupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupFrame signupFrame = new SignupFrame(600,450);
                setVisible(false);
                signupFrame.setVisible(true);

            }
        });

        GuestModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LevelFrame levelFrame = new LevelFrame(600,450);
                setVisible(false);
                levelFrame.setVisible(true);

            }
        });
    }
}
