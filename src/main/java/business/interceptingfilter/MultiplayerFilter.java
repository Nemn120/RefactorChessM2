package business.interceptingfilter;

import javax.swing.*;

public class MultiplayerFilter implements Filter {

    private String modoSelect;
    public static final String SOLO_MODE="Solo";
    public static final String MULTIPLAYER_MODE="Multijugador";

    @Override
    public void execute() {

        Object[] options1 = {SOLO_MODE, MULTIPLAYER_MODE};
        Integer input = JOptionPane.showOptionDialog(null, "Seleccione modo de juego", "Modo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, null);
        System.out.println(input);

        if (input == JOptionPane.OK_OPTION) {
            this.modoSelect = SOLO_MODE;
        }
        if (input == JOptionPane.INFORMATION_MESSAGE) {
            this.modoSelect = MULTIPLAYER_MODE;
        }
    }

    public String getModoSelect() {
        return modoSelect;
    }

    public void setModoSelect(String modoSelect) {
        this.modoSelect = modoSelect;
    }
}
