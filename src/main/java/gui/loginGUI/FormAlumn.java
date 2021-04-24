package gui.loginGUI;


import business.DTO.Universitario;
import business.DTO.UniversitarioService;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAlumn implements ActionListener {

    private JFrame formAlumnFrame;
    private JPanel formPanel;
    private JTextField nameInput;
    private JTextField surnameAndLastNameInput;
    private JTextField dniInput;
    private JTextField schoolInput;
    private JTextField codeAlumnInput;

    private JLabel nameLabel;
    private JLabel surnameAndLastNameLabel;
    private JLabel dniLabel;
    private JLabel schoolLabel;
    private JLabel codeAlumnLabel;
    private JButton saveButton;
    private JPanel panel1;

    public JFrame frameAlum;

    public JPanel getPanel1() {
        return panel1;
    }

    public FormAlumn() {
        this.formAlumnFrame = new JFrame();
        this.setFormPanel(this.formPanel);
        this.setNameInput(this.nameInput);
        this.setSurnameAndLastNameInput(this.surnameAndLastNameInput);
        this.setDniInput(this.dniInput);
        this.setSchoolInput(this.schoolInput);
        this.setCodeAlumnInput(this.codeAlumnInput);
        this.setNameLabel(this.nameLabel);
        this.setSurnameAndLastNameLabel(this.surnameAndLastNameLabel);
        this.setDniLabel(this.dniLabel);
        this.setSchoolLabel(this.schoolLabel);
        this.setCodeAlumnLabel(this.codeAlumnLabel);

        this.setSaveButton(this.saveButton);;
        this.getSaveButton().addActionListener(this);
    }

    /*public static void main(String[] args) {
        FormAlumn formAlumn = new FormAlumn();
        formAlumn.showFormAlumn();
    }*/

    public void showFormAlumn() {
        this.getFormPanel().setPreferredSize(new Dimension(260, 220));
        this.getFormAlumnFrame().add(this.getFormPanel());
        this.getFormAlumnFrame().add(this.getFormPanel(), BorderLayout.CENTER);
        this.getFormAlumnFrame().pack();
        this.getFormAlumnFrame().setLocationRelativeTo(null);
        this.getFormAlumnFrame().setVisible(true);
        this.getFormAlumnFrame().setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void save() {
         UniversitarioService s=new UniversitarioService();

        s.guardarUsuario(new Universitario(this.getNameInput().getText(),
                this.getSurnameAndLastNameInput().getText(),
                this.getDniInput().getText(),
                this.getSchoolInput().getText(),
                this.getCodeAlumnInput().getText()));
        JOptionPane.showMessageDialog(null,"Registrado: "+this.getCodeAlumnInput().getText());
        frameAlum.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.getSaveButton()) {
            if(StringUtils.isBlank(this.getNameInput().getText()) || StringUtils.isBlank(this.getSurnameAndLastNameInput().getText()) ||
                    StringUtils.isBlank(this.getDniInput().getText()) || StringUtils.isBlank(this.getDniInput().getText()) ||
                    StringUtils.isBlank(this.getSchoolInput().getText()) || StringUtils.isBlank(this.getCodeAlumnInput().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
            } else {
                this.save();
            }
        }
    }

    public JFrame getFormAlumnFrame() {
        return formAlumnFrame;
    }

    public void setFormAlumnFrame(JFrame formAlumnFrame) {
        this.formAlumnFrame = formAlumnFrame;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(JPanel formPanel) {
        this.formPanel = formPanel;
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameInput) {
        this.nameInput = nameInput;
    }

    public JTextField getSurnameAndLastNameInput() {
        return surnameAndLastNameInput;
    }

    public void setSurnameAndLastNameInput(JTextField surnameAndLastNameInput) {
        this.surnameAndLastNameInput = surnameAndLastNameInput;
    }

    public JTextField getDniInput() {
        return dniInput;
    }

    public void setDniInput(JTextField dniInput) {
        this.dniInput = dniInput;
    }

    public JTextField getSchoolInput() {
        return schoolInput;
    }

    public void setSchoolInput(JTextField schoolInput) {
        this.schoolInput = schoolInput;
    }

    public JTextField getCodeAlumnInput() {
        return codeAlumnInput;
    }

    public void setCodeAlumnInput(JTextField codeAlumnInput) {
        this.codeAlumnInput = codeAlumnInput;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getSurnameAndLastNameLabel() {
        return surnameAndLastNameLabel;
    }

    public void setSurnameAndLastNameLabel(JLabel surnameAndLastNameLabel) {
        this.surnameAndLastNameLabel = surnameAndLastNameLabel;
    }

    public JLabel getDniLabel() {
        return dniLabel;
    }

    public void setDniLabel(JLabel dniLabel) {
        this.dniLabel = dniLabel;
    }

    public JLabel getSchoolLabel() {
        return schoolLabel;
    }

    public void setSchoolLabel(JLabel schoolLabel) {
        this.schoolLabel = schoolLabel;
    }

    public JLabel getCodeAlumnLabel() {
        return codeAlumnLabel;
    }

    public void setCodeAlumnLabel(JLabel codeAlumnLabel) {
        this.codeAlumnLabel = codeAlumnLabel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

}
