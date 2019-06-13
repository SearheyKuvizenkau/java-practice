import java.util.ArrayList;
import java.util.function.Predicate;

public class Queuelmpl<T> implements Queue<T> {

    ArrayList<T> list;

    private final int CAPASITY = 5;
    private int begin = 0;

    public Queuelmpl() {

        list = new ArrayList<>(CAPASITY);

    }

    public Queuelmpl(int size) {

        list = new ArrayList<>(size);

    }

    @Override
    public T peek() {
        if (begin == list.size()) {
            return null;
        }
        return list.get(begin);

    }

    @Override
    public T pop() {
        if (begin == list.size()) {
            return null;
        }
        T elem = list.get(begin);
        begin++;
        return elem;
    }

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    void addAll(Queuelmpl<T> other) {
        for (int i = other.begin; i < other.list.size(); i++) {
            list.add(other.list.get(i));
        }
    }

    int indexOff(Predicate<T> predicate) {

        for (int i = begin; i < list.size(); i++) {

            if (predicate.test(list.get(begin)))
                return i;
        }

        return -1;
    }
}
