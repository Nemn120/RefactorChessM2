package business.log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class LogTest {
    List<Log> logs;
    @Before
    public void before(){
        logs=new ArrayList<>();
    }
    @Test
    public void testLogs(){
        logs.add(new GameLog());
        logs.add(new ConsoleLog());
        logs.add(new FileLog());
        for (Log l:logs) {
            l.addToLog("chess");
        }
        for (Log l:logs) {
           if (l instanceof GameLog){
               assertTrue(((GameLog) l).message=="chess","message incorrecto");
           }else if (l instanceof ConsoleLog){
               assertTrue(((ConsoleLog) l).message=="chess","message incorrecto");
           }else if (l instanceof FileLog){
               assertTrue(((FileLog) l).message=="chess","message incorrecto");
           }
        }
    }

}