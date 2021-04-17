package business.interceptingfilter;

import business.log.ConsoleLog;
import business.log.FileLog;
import business.log.GameLog;
import business.log.Log;

import javax.swing.*;
import java.awt.*;

public class LogFilter implements Filter{

    Component component;
    Log gamelog;

    @Override
    public void execute() {
        int i = 0;
        do{
            i= Integer.parseInt( JOptionPane.showInputDialog(null, "                       Logs" +
                    "\n1.GameLog              2.ConsoleLog" +
                    "\n                     3.FileLog"));

            if (i == 1) {
                gamelog = new GameLog();
                component =(GameLog) gamelog;
            } else if (i == 2) {
                gamelog =  new ConsoleLog();
                component =(ConsoleLog) gamelog;
            } else if (i == 3) {
                gamelog = new FileLog();
                component =(FileLog) gamelog;
            } else {
                JOptionPane.showMessageDialog(null, "Logger no valido!");
            }
        }while(i!= 1 && i!=2 && i!=3);
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Log getGamelog() {
        return gamelog;
    }

    public void setGamelog(Log gamelog) {
        this.gamelog = gamelog;
    }
}
