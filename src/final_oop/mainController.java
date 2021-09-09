/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

/**
 * This is the main Controller class that controls and acts as mediator between first and second screen.
 * @author 
 */
public class mainController  implements Initializable, EventHandler<ActionEvent>{
    // These are the fx id from the fxml file that will be used in ths class.
    @FXML ComboBox cb;
    @FXML Label gameArrowLabel;
    @FXML Label sheriffNameLabel;
    @FXML Label pl1Label;
    @FXML Label Pl1HP;
    @FXML Button start;
    @FXML ComboBox cbOS;
    @FXML ComboBox cbUA;


    HashMap<String,String> pls = new HashMap<>();   // Hashmap to store playes role and character.
    ArrayList<String> roles = new ArrayList<>();    // Array List to store players roles.
    ArrayList<String> characters = new ArrayList<>();   // Arraylist to store the players  characters.
    // Below are the ArrayList of roles and characters that we will be using baased on th enumber of players that will be playing and wheather if or not the expansions are used..
    ArrayList<String> characters0= new ArrayList<>(Arrays.asList("BartCassidy 8", "BlackJack 8", "CalamityJanet 8", "ElGringo 7", "JesseJones 9", "Jourdonnais 7", "PaulRegret 9", "PedroRamirez 8", "RoseDoolan 9", "SuzyLafayette 8", "VultureSam 9"));
    ArrayList<String> characters1= new ArrayList<>(Arrays.asList("BartCassidy 8", "BlackJack 8", "CalamityJanet 8", "ElGringo 7", "JesseJones 9", "Jourdonnais 7", "PaulRegret 9", "PedroRamirez 8", "RoseDoolan 9", "SuzyLafayette 8", "VultureSam 9", "JoseDelgado 7", "TequilaJoe 7", "ApacheKid 9", "BillNoface 9"));
    ArrayList<String> characters2= new ArrayList<>(Arrays.asList("BartCassidy 8", "BlackJack 8", "CalamityJanet 8", "ElGringo 7", "JesseJones 9", "Jourdonnais 7", "PaulRegret 9", "PedroRamirez 8", "RoseDoolan 9", "SuzyLafayette 8", "VultureSam 9", "BelleStar 8", "GregDigger 7"));
    ArrayList<String> characters3= new ArrayList<>(Arrays.asList("BartCassidy 8", "BlackJack 8", "CalamityJanet 8", "ElGringo 7", "JesseJones 9", "Jourdonnais 7", "PaulRegret 9", "PedroRamirez 8", "RoseDoolan 9", "SuzyLafayette 8", "VultureSam 9", "JoseDelgado 7", "TequilaJoe 7", "ApacheKid 9", "BillNoface 9", "BelleStar 8", "GregDigger 7"));
    ArrayList<String> roles1 = new ArrayList<>(Arrays.asList("Sheriff", "Deputy", "Renegade", "Outlaw"));
    ArrayList<String> roles2 = new ArrayList<>(Arrays.asList("Sheriff", "Deputy", "Renegade", "Outlaw", "Outlaw"));
    ArrayList<String> roles3 = new ArrayList<>(Arrays.asList("Sheriff", "Deputy", "Renegade", "Outlaw", "Outlaw", "Outlaw"));
    ArrayList<String> roles4 = new ArrayList<>(Arrays.asList("Sheriff", "Deputy", "Renegade", "Outlaw", "Outlaw", "Outlaw", "Deputy"));
    ArrayList<String> roles5 = new ArrayList<>(Arrays.asList("Sheriff", "Deputy", "Renegade", "Outlaw", "Outlaw", "Outlaw", "Deputy", "Renegade"));    
    ArrayList<String> frole = new ArrayList<>();
    ArrayList<Integer> HP = new ArrayList<>(); // ArrayList to store the Heahth point of the players.

    ArrayList<String> fcharacters = new ArrayList<>(); // ArrayLiat to store characters after chooing the no of players.
    // This is the dice face if Old Saloon expansion is used.
    ArrayList<String> edice = new ArrayList<>(Arrays.asList("BrokenArrow", "Bullet", "DoubleBeer", "DoubleOne", "DoubleTwo", "DoubleGatling"));
    
    /**
     * This method choose the appropriate roles, characters, and dice faces depending on the options player chooses in the Start UI screen. 
     * @param event This is the input event like game start button in this case.
     * @throws IOException This handles the exceptions which may get thrown during the execution.
     */
    @FXML
    public void processPlayers(ActionEvent event) throws IOException{
       
        if(event.getSource() == start){
            String cbvalue = (String) cb.getValue();
            String exp1 = (String)cbOS.getValue();
            String exp2 = (String)cbUA.getValue();
            // Extracts the option choosen by user for number of players.
            int noofplayer = (int)Integer.parseInt(cbvalue);
                characters = characters0;
             //Below fpllowing codes choose the suitable chcracters list and get expansion dices if choosedn to include it bases on the choices the player made in Start UI..
            if(exp1.equalsIgnoreCase("YES") && exp2.equalsIgnoreCase("NO")){
                characters = characters1;
                Final_oop.setDice(edice);
            }else if(exp1.equalsIgnoreCase("NO") && exp2.equalsIgnoreCase("YES")){
                characters = characters2;
            }else if(exp2.equalsIgnoreCase("YES") && exp1.equalsIgnoreCase("YES")){
                characters = characters3;
                Final_oop.setDice(edice);
            }else{
                characters = characters0;
            }
            // Based on the no of player playing below code choose the suitable roles arraylist
            switch (noofplayer){
                case 4: roles = roles1; break;
                case 5: roles = roles2; break;
                case 6: roles = roles3; break;
                case 7: roles = roles4; break;
                case 8: roles = roles5; break;
            }
            //Shuffling the roles and characters.
            Collections.shuffle(roles);
            Collections.shuffle(characters);
            //
            for(int i = 0; i < noofplayer; i++){
                Players pl = new Players();
                pl.setRole(roles.get(i));
                pl.setCharacter(characters.get(i));
                pls.put(pl.getCharacter(),pl.getRole());
            }

    
            pls.entrySet().forEach((entry) -> {
                String key = entry.getKey();
                String value = entry.getValue();
                frole.add(value);
                String[] parts = key.split(" ");
                System.out.println(parts[1]);
                fcharacters.add(parts[0]);
                HP.add(Integer.parseInt(parts[1]));
                
            });
            
            
            System.out.println(frole);
            System.out.println(fcharacters);
            System.out.println(HP);

            // Assigning and storing these values in the main class so that we can use it later in  other classes.
            Final_oop.setcharacter(fcharacters);
            Final_oop.setroles(frole);
            Final_oop.setHP(HP);
            //Settig different Scene to our Stage.
            
            Parent playerView = FXMLLoader.load(getClass().getResource("Untitled.fxml"));
            Scene plScene = new Scene(playerView);
            plScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(plScene);
            window.show();
            
        }

    }
   
    /**
     * This is the implemented method from Initializable. Here we set choices available to the users to choose from.
     * @param location unused
     * @param resources unused
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Disabling the start button so that user have make all the choices before.
        start.setDisable(true);
        // Setting options for number of players to choose from and setting them.
        cb.getItems().add("4");
        cb.getItems().add("5");
        cb.getItems().add("6");
        cb.getItems().add("7");
        cb.getItems().add("8");
        cb.setOnAction(this);
        // Setting the options to include the sxpansions to the game or not.
        cbOS.getItems().add("YES");
        cbOS.getItems().add("NO");
        cbUA.getItems().add("YES");
        cbUA.getItems().add("NO");
        cbOS.getSelectionModel().select("NO");
        cbUA.getSelectionModel().select("NO");
        cbOS.setOnAction(this);
        cbUA.setOnAction(this);

  
    }
    /**
     *  Method to ensure all the informations are entered correctly and enable the star button.
     * @param event 
     */
    @FXML
    private void handle(InputMethodEvent event) {
        if(event.getSource()==cb){
            // It enables our start button after the choices are made
            start.setDisable(false);
        }
    }
    /**
     * Method to ensure all the informations are entered correctly and enable the star button
     * @param event 
     */
    @Override
    public void handle(ActionEvent event) {
           if(event.getSource()==cb){
            //It enables our start button after the choices are made
            start.setDisable(false);
        }
    }
  
}
