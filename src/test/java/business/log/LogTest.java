package business.log;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class LogTest {

    Logger logger;
    List<Log> logs;
    @Before
    public void before(){

        logs=new ArrayList<>();

        logger = Logger.getLogger(LogTest.class.getName());
        logger.info("-------------------------------------------");
    }

    @Test
    public void testLogs(){

        logs.add(new GameLog());
        logs.add(new ConsoleLog());
        logs.add(new FileLog());

        for (Log l:logs) {
            l.addToLog("start");
        }
        for (Log l:logs) {

            System.out.println(l.getLastLog());
        }

    }

}