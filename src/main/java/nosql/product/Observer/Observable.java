package nosql.product.Observer;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String usedFunction);

}
