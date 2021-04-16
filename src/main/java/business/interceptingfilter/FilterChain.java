package business.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(){
        for (Filter filter : filters) {
            filter.execute();
        }
        target.execute();
    }

    public void setTarget(Target target){
        this.target = target;
    }

}
