package gui.loginGUI;

import gui.ChessPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUniversity {
    private JButton ingresarButton;
    private JPasswordField passwordField1;
    private JPanel panel1;

    public JFrame frameLoginUniversity;

    public LoginUniversity() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("YetAnotherChessGame 1.0");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ChessPanel());
                frame.pack();
                frame.setVisible(true);

                frameLoginUniversity.dispose();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
