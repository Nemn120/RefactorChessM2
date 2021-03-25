package util.colorFlyWeight;

import java.util.HashMap;
import java.util.Map;

public class ColorFactoryFlyWeight {
    private static Map<Integer, Colors> flyweights = new HashMap<>();
    public static Colors getColor(int key) {
        if(flyweights.containsKey(key)){
            return flyweights.get(key);
        }
        Colors color;
        switch (key)
        {
            case 0:
                color = new BlackFlyWeight();
                break;
            case 1:
                color = new WhiteFlyWeight();
                break;
            default:
                color = new NullFlyWeight();
        }
        flyweights.put(key, color);
        return color;
    }
}
