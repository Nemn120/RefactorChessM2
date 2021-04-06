package business.log;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

public class FileLog extends JComponent implements Log{

    Path path=Paths.get("log.txt");

    @Override
    public void addToLog(String s) {




        String log=new Date() + " - " + s+"\n";

        try {
            Files.write(path, log.getBytes(),StandardOpenOption.APPEND );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void clearLog() {
        String t="";
        try {
            Files.write(path,t.getBytes(),StandardOpenOption.TRUNCATE_EXISTING );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getLastLog() {
        return "\nRetornando al pasado!";
    }


}
