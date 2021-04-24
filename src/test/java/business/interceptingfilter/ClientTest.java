package business.interceptingfilter;

import org.junit.Test;

public class ClientTest {

    @Test
    public void evaluateFilter(){
        FilterManager filterManager = new FilterManager(new Target());
        LogFilter logFilter = new LogFilter();
        MultiplayerFilter multiplayerFilter = new MultiplayerFilter();
        filterManager.setFilter(multiplayerFilter);
        filterManager.setFilter(logFilter);
        Client clientChess = new Client();
        clientChess.setFilterManager(filterManager);
        clientChess.sendRequest();


    }
}