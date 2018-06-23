package vernoi_interactable;

import java.util.Comparator;

public class DelaunayComparator implements Comparator<DelaunayPoint>{

    DelaunayPoint auxPoint;

    public DelaunayComparator(DelaunayPoint auxPoint) {
        this.auxPoint = auxPoint;
    }

    @Override
    public int compare(DelaunayPoint p1, DelaunayPoint p2) {
        return p1.getDistance(auxPoint) < p2.getDistance(auxPoint) ? -1 : 1;
    }
}
