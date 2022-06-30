package Core;

import java.util.ArrayList;
import java.util.List;

public class MutexList<T> extends ArrayList<T> {
    private int index = 0;

    public MutexList(List<T> list) {
        super(list);
    }
    public MutexList(){
        super();
    }

    @Override @Deprecated
    public T get(int index) {
        throw new IllegalStateException("[ERROR] Do not call this method!");
    }

    public synchronized T get() {
        return super.get(index);
    }

    public synchronized int incrementIndex() {
        if (index > super.size()) {
            index = 0;
        }else {
            index++;
        }
        return index;
    }
}
