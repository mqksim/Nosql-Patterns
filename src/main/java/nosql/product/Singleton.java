package nosql.product;

import nosql.product.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Singleton implements Observer {
    private static Singleton instance;
    private List<String> usedFunctions = new ArrayList<String>();

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void addUsedFunction(String usedFunction) {
        usedFunctions.add(usedFunction);
    }

    public String getUsedFunctions() {
        return usedFunctions.toString();
    }

    public Integer getCountUsedFunctionByName(String used) {
        int count=0;
        for(String s:usedFunctions){
            if(s.equals(used)){
                count++;
            }
        }
        return count;
    }

    @Override
    public void update(String usedFunction) {
        Singleton.getInstance().addUsedFunction(usedFunction);
    }

}
