/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veronoi_interactable;

import java.awt.Color;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Michael
 */
public class Veronoi_Interactable extends Application {
    
    Delaunay d;
    Pane InteractionPane;
    
    @Override
    public void start(Stage primaryStage) {
        
        // create horizontal box object
        HBox buttonArea = new HBox();
        
        // create pane object
        InteractionPane = new Pane();
        
        // my delaunay algorithm
        d = new Delaunay(InteractionPane);
        
        // set border style of pane
        InteractionPane.setStyle("-fx-border-color: black;");
        
        // set prefered size of pane
        InteractionPane.setPrefSize(650, 450);
        
        //creating a button object with click event
        Button refreshButton = new Button("New");
        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                refresh();
            }
        });
        
        // create mouse event
        EventHandler<MouseEvent> mouseClicked = new EventHandler<MouseEvent>() { 
   @Override 
   public void handle(MouseEvent e) { 

       // add a dot to the interaction pane
       InteractionPane.getChildren().add(new Circle(e.getX(),e.getY(),4));
       System.out.println("mouse clicked!");
       d.add(new DelaunayPoint(e.getX(),e.getY()));
        
   } 
    };
        // register mouse event to Interaction Pane
        InteractionPane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseClicked);
        
        // creating a button object with click event
        Button simulateButton = new Button("Go");
        simulateButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Veronoi simulation started!");
                d.DrawLinks();
                //d.drawTriangles();
                //d.drawDelaunay();
            }
        });
        
        // create vertical box object
        VBox root = new VBox();
        
        // set two buttons to the button area
        buttonArea.getChildren().addAll(simulateButton,refreshButton);
        
        // position button area alignment
        buttonArea.setAlignment(Pos.BOTTOM_CENTER);
        
        // add the Interaction pane and the button pane to the vertical box root
        root.getChildren().addAll(InteractionPane,buttonArea);
        
        // set scene object
        Scene scene = new Scene(root, 700, 500);
        
        // set title of the primary stage
        primaryStage.setTitle("Veronoi Simulator");
        
        // set scene to the scene object
        primaryStage.setScene(scene);
        
        // show the stage
        primaryStage.show();
        
        
       
        
        
    }
    
     private void refresh()
     {
         d.pointArray.clear();
         InteractionPane.getChildren().clear();
         System.out.println("Simulation refreshed!");
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
