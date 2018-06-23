/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veronoi_interactable;

import java.util.Comparator;

/**
 *
 * @author Michael
 */
public class PointComparator implements Comparator<Point> {

    Point auxPoint;
    
    public PointComparator(Point p)
    {
        auxPoint = p;
    }

    @Override
    public int compare(Point p1, Point p2) {
        if(p1.getDistance(auxPoint) < p2.getDistance(auxPoint))
        {
            return -1;
        }
        else return 1;
    }
    
}
