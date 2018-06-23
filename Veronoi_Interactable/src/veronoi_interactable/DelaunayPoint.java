package vernoi_interactable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class DelaunayPoint extends Point.Double {

    public ArrayList<DelaunayPoint> otherPoints;
    private DelaunayComparator pComparator;
    private boolean canLink;

    public DelaunayPoint(double x, double y) {
        super(x, y);
        canLink = true;
        pComparator = new DelaunayComparator(this);
    }

    public boolean isCanLink() {
        return canLink;
    }

    public void setCanLink(boolean canLink) {
        this.canLink = canLink;
    }

    public void setLinks(Collection<DelaunayPoint> c) {
        otherPoints = new ArrayList<>(c){{
            sort(pComparator);
        }};
        //todo: check what prints out
        System.out.println(otherPoints);
    }

    public void linkTo(DelaunayPoint other) {
        otherPoints.add(other);
    }

    //Distance method still needs to be implemented since it is not available in Point class
    public double getDistance(DelaunayPoint p)
    {
        return sqrt(pow((p.getX() - this.x),2) + pow((p.getY() - this.y),2));
    } //formula that I will never remember

    @Override
    public String toString() {
        return x + " " + y;
    }

}
