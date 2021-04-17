package gui.loginGUI;

import business.DTO.Universitario;
import business.DTO.UniversitarioDTO;
import business.DTO.UniversitarioService;
import business.login.Login;
import business.login.LoginUniversityCardAdapter;
import business.login.LoginUsernamePassword;
import gui.ChessPanel;
import util.university.Credential;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUniversity {
    private JButton ingresarButton;
    private JPasswordField passwordField1;
    private JPanel panel1;
    private JTextField textField1;

    public JFrame frameLoginUniversity;

    public LoginUniversity() {

        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel1.setBorder(padding);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login l=new LoginUniversityCardAdapter();
                String code=textField1.getText();

                UniversitarioService s=new UniversitarioService();
                UniversitarioDTO universitarioDTO=s.createDTO(new Universitario(code));

                if (universitarioDTO!=null) {

                    JFrame frame = new JFrame("YetAnotherChessGame 1.0");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(new ChessPanel());
                    frame.pack();
                    frame.setVisible(true);

                    frameLoginUniversity.dispose();
                    JOptionPane.showMessageDialog(null,"Bienvenido "+ universitarioDTO.getFullName());
                }else{
                    JOptionPane.showMessageDialog(null,"Codigo de estudiante Invalida!");
                }

            }
        });

    }

    public JPanel getPanel1() {
        return panel1;
    }
}

/*
    Login l=new LoginUniversityCardAdapter();
                String code=textField1.getText();
                if (l.loginIn(code,null) && !"admin".equals(code)) {

                    JFrame frame = new JFrame("YetAnotherChessGame 1.0");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(new ChessPanel());
                    frame.pack();
                    frame.setVisible(true);

                    frameLoginUniversity.dispose();
                    JOptionPane.showMessageDialog(null,"Bienvenido "+ Credential.CODE.get(code));
                }else{
                    JOptionPane.showMessageDialog(null,"Codigo de estudiante Invalida!");
                }
 */