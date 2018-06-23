/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veronoi_interactable;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author Michael
 */
public class Delaunay {
    
    // raw collection of points
    ArrayList<Point> pointArray = new ArrayList();
    Pane pane;
    
    public Delaunay(Pane p )
    {
        this.pane = p;
    }
    
    
    // add a point to point data
    public void add(Point p )
    {
       pointArray.add(p);
    }
    
    
    // draw a full graph with all points connected
    public void DrawLinks()
    {
        for(Point p : pointArray)
        {
            if(p.getCanLink())
            {
                
             p.setLinks(pointArray);
            pane.getChildren().add(new Line(p.getX(), p.getY(), p.otherPoints.get(1).getX(), p.otherPoints.get(1).getY()));
            
            pane.getChildren().add(new Line(p.getX(), p.getY(), p.otherPoints.get(2).getX(), p.otherPoints.get(2).getY()));   
                
            }
            
            
            p.setCanLink(false);
        }
    }
    
    
    
    
    
    
    
}
