package Model;

import java.util.Iterator;
import java.util.List;

public class ScholarContainerIterator implements Iterator<Scholar> {

    private List<Scholar> container;
    private int index;

    public ScholarContainerIterator(List<Scholar> container) {
        this.container = container;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < container.size();
    }

    @Override
    public Scholar next() {
        return container.get(index++);
    }
}
