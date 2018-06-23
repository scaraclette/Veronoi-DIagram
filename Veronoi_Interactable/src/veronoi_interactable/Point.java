/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veronoi_interactable;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * 
 * @author Michael
 * 
 * for storing coordinate data of points and their connections
 */
public class Point {
    
    public ArrayList<Point> otherPoints;
    private PointComparator pComparator;
    private boolean canLink;
    private double x;
    private double y;
    
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.canLink = true;
        pComparator = new PointComparator(this); 
    }
    

    public void setCanLink(boolean canLink) {
        this.canLink = canLink;
    }

    public boolean getCanLink() {
        return canLink;
    }
    
    public double getX()
    {
        return this.x;
    }
    
    public double getY()
    {
        return this.y;
    }
    
    public void setLinks(Collection<Point> c)
    {
        otherPoints = new ArrayList(c);
        otherPoints.sort(pComparator);
        System.out.println(otherPoints);
    }
    
    // add a point and record the distance
    public void linkTo(Point p)
    {
       otherPoints.add(p);
    }
    
    
    public double getDistance(Point p)
    {
        return sqrt(pow((p.getX() - this.x),2) + pow((p.getY() - this.y),2));
    }
    
    public String toString()
    {
        return x + " " + y;
    }
   
}
