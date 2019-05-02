package cs203.project04;
import java.util.Comparator;
import cs203.battlearena.objectmon.Objectmon;

public class ObjectmonHPComparator<T extends Objectmon> implements Comparator<T> {

    public int compare(T o1, T o2) {
        if (o1.getHP()>o2.getHP()) {return 1;}
        else if (o1.getHP()==o2.getHP()) {return 0;}
        else {return -1;}
    }
}