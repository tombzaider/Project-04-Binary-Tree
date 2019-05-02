package cs203.project04;
import java.util.Comparator;
import cs203.battlearena.objectmon.Objectmon;

public class ObjectmonStaminaComparator<T extends Objectmon> implements Comparator<T> {

    public int compare(T o1, T o2) {
        if (o1.getStamina()>o2.getStamina()) {return 1;}
        else if (o1.getStamina()==o2.getStamina()) {return 0;}
        else {return -1;}
    }
}