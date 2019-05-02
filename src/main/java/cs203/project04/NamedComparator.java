package cs203.project04;
import java.util.Comparator;
import cs203.battlearena.Named;

public class NamedComparator<T extends Named> implements Comparator<T> {

    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}