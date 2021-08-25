/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket;
import java.util.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 *
 * @author sadik
 */
public class Cricket extends Application {
    List<CricketPlayer> playersRoaster = new ArrayList<CricketPlayer>();
    
    Scene scene1,scene2;
    
    @Override
    public void start(Stage primaryStage) {
    primary(primaryStage);
        
    }
    public void primary (Stage primaryStage){
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5);
        pane.setVgap(5);
        
        Button btn1 = new Button();
        btn1.setText("Add Player");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    Stage second = new Stage();
                    Label player_name=new Label("Player Name :");  
                    Label jersey_number = new Label("Jersey Number"); 
                    Label player_salary = new Label("Player Salary");
                    TextField tf1=new TextField();  
                    TextField tf2=new TextField(); 
                    TextField tf3=new TextField();
                    
                    Button b = new Button("Submit"); 
                    b.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            CricketPlayer player = new CricketPlayer(tf1.getText(),
                            Integer.parseInt(jersey_number.getText()), Double.parseDouble(player_salary.getText()));
                            playersRoaster.add(player);
                            second.getOnCloseRequest().handle(new WindowEvent(second, WindowEvent.WINDOW_CLOSE_REQUEST));
                            
                        }
                    });
                    
                    GridPane root = new GridPane();
                    root.setAlignment(Pos.CENTER);
                    
                    root.addRow(0, player_name, tf1);  
                    root.addRow(1, jersey_number, tf2);
                    root.addRow(3, player_salary, tf3);  

                    root.addRow(4, b);  
                    scene2 =new Scene(root,300,250);  
                    
                    second.setScene(scene2);  
                    second.setTitle("Add Player");  
                    second.show();  
            }
        });
        Button btn2 = new Button();
        btn2.setText("Remove Player");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        Button btn3 = new Button();
        btn3.setText("Show Roaster");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        TableView table = new TableView();
        table.setEditable(true);
        
        TableColumn column1 = new TableColumn("Player"); 
        
        TableColumn column2 = new TableColumn("Jersey"); 
        
        TableColumn column3 = new TableColumn("Salary"); 
        table.getColumns().addAll(column1,column2,column3);
        
        ObservableList<CricketPlayer> list = FXCollections.observableArrayList(playersRoaster);
        
        column1.setCellValueFactory(new PropertyValueFactory<CricketPlayer,String>("playerName"));
        column2.setCellValueFactory(new PropertyValueFactory<CricketPlayer,String>("jerseyNumber"));
        column3.setCellValueFactory(new PropertyValueFactory<CricketPlayer,String>("salary"));
        table.setItems(list);
        
        pane.add(btn1,0,0);
        pane.add(btn2,0,1);
        pane.add(btn3,0,2);
        pane.add(table,1,1);
        
        scene1 = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Cricket Roaster");
        primaryStage.setScene(scene1);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        
        primaryStage.show();
    }
    public void roasterShow(){
        
        
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
