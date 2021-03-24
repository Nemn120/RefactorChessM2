package gui.loginGUI;

import gui.ChessMain;
import gui.ChessPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMaster {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ingresarButton;
    private JButton ingresarComoUniversitarioButton;

    static JFrame frameMaster;

    public LoginMaster() {
        ingresarComoUniversitarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                JFrame frame2=new JFrame();

                LoginUniversity loginUniversity=new LoginUniversity();
                loginUniversity.frameLoginUniversity=frame2;

                frame2.setContentPane(loginUniversity.getPanel1());
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);

                frameMaster.dispose();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("YetAnotherChessGame 1.0");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ChessPanel());
                frame.pack();
                frame.setVisible(true);

                frameMaster.dispose();

            }
        });
    }

    public static void main(String[] args) {
        frameMaster = new JFrame("LoginMaster");
        frameMaster.setContentPane(new LoginMaster().panel1);
        frameMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMaster.pack();
        frameMaster.setVisible(true);
    }
}
