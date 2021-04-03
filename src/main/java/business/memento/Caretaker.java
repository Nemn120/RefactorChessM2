package business.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }

    public List<Memento> getMementos() {
        return mementos;
    }

    public void setMementos(List<Memento> mementos) {
        this.mementos = mementos;
    }
}
