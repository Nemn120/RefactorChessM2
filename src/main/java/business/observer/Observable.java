package business.observer;

public interface Observable {
    void attach(Observer o);
    void detach(Observer o);
    void _notify();
}
