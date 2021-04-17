package business.interceptingfilter;

public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(){
        filterManager.filterRequest();
    }
}
