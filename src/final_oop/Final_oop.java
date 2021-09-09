/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author norbulama
 */
public class Final_oop extends Application{
    
    public static ArrayList<String> expdice;    // to store expansion dice
    private static ArrayList<String> characters;    // to store characters assigned in the game
    private static ArrayList<String> roles;     // to store roles assigned to the characters
    private static ArrayList<Integer> HP;   // to store Health points assigned to the players.
//    int a;  // index for the winner 
//
//    void seta(int a){
//        this.a=a;
//        System.out.print(a);
//    }
//    int geta(){
//        return a;
//        
//    }
    public static void setcharacter(ArrayList<String> characters) {       
        Final_oop.characters = characters;
    }
    
    public static ArrayList<String> getcharacters() {
        return characters;
    }
    public static void setroles(ArrayList<String> roles) {       
        Final_oop.roles = roles;
    }
    
    public static ArrayList<String> gteroles() {
        return roles;
    }
    public static void setHP(ArrayList<Integer> HP) {       
        Final_oop.HP = HP;
    }
    
    public static ArrayList<Integer> getHP() {
        return HP;
    }
    public static void setDice(ArrayList<String> dice) {       
        Final_oop.expdice = dice;
    }
    
    public static ArrayList<String> getDice() {
        return expdice;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    /**
     * 
     * @param primaryStage The main stage where we show and change our User Interface depending on the user inputs.
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));  // losading the FXML file
        primaryStage.getIcons().add(new Image("/logo/bang-icon.jpg")); // Setting logop icon on the stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm()); // adding css to the user interface (just the background color inour case)
        primaryStage.setScene(scene);
        primaryStage.setTitle("BANG! The Dice Game");
        primaryStage.show();
        
       
    }
   
}
