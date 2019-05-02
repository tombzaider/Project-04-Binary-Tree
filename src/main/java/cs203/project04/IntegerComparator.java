package cs203.project04;
import java.lang.Integer;
import java.util.Comparator;

public class IntegerComparator<T extends Integer> implements Comparator<T>{
    public int compare(T o1, T o2){
        if (o1.intValue()<o2.intValue()) {return -1;

        }

        else if (o1.intValue()==o2.intValue()) {return 0;


        }
        else {
            return 1;
        }
    }
}