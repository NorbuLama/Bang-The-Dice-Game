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
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is the controller class for the FXML file and GUI screen for all the players. that implements Initializable
 * @author norbulama
 */
public class PlayersFXMLController implements Initializable{
    /* Below are all the FXML fx for BUttons, Images, Checkbos, Labels, BprderPane etc from FXML that we will be using in this class and implement them 
    as neede based on the input.
    */
    @FXML Button brd;
    @FXML ImageView d1;
    @FXML ImageView d2;
    @FXML ImageView d3;
    @FXML ImageView d4;
    @FXML ImageView d5;
    @FXML Button nxtPl;
    @FXML Label rollsleft;
    @FXML CheckBox ck1;
    @FXML CheckBox ck2;
    @FXML CheckBox ck3;
    @FXML CheckBox ck4;
    @FXML CheckBox ck5;
    @FXML BorderPane mainPane;
    @FXML Button bigButton;
    @FXML Button p1;
    @FXML Button p2;
    @FXML Button p3;
    @FXML Button p4;
    @FXML Button p5;
    @FXML Button p6;
    @FXML Button p7;
    @FXML Button p8;
    @FXML Label r1;
    @FXML Label hp1;
    @FXML ImageView p1r1;
    @FXML ImageView p1c1;
    @FXML Label gamesrf;
    @FXML Label totalArrow;
    @FXML Button myrolls;
    @FXML ImageView dp1;
    @FXML ImageView dp2;
    @FXML ImageView dp3;
    @FXML ImageView dp4;
    @FXML ImageView dp5;


    ArrayList<String> edice = Final_oop.getDice();  //  the ArrayList to store exopansion dice
    ArrayList<String> characters = Final_oop.getcharacters();   //  the ArrayList to stored with all the character we made in main Controller class.
    ArrayList<String> roles = Final_oop.gteroles();  //  the ArrayList to stored with all the roles we made in main Controller class.
    ArrayList<Integer> HP = Final_oop.getHP();   //  the ArrayList to stored with all the Health Points of players we made in main Controller class.
    int noofReroll = 3; // toral no of roll a user player can roll
    ArrayList<String> userrolls = new ArrayList<>();    //  //  the ArrayList to store dice faces rolled by players.
    ArrayList<String> faces = new ArrayList<>(Arrays.asList("DiArrow", "DiBeer", "DiDynamite", "DiGatling", "DiOne", "DiTwo")); // regular dice faces
    Random rand = new Random(); // randon class to genrate random numbers 


    /**
     * Method to roll dice and assign the images to the dice faces ion the player User Interface.
     * @param event The event is the clicking he Roll Dice button action taken by user in the UI.
     */
    @FXML public void RollDice(ActionEvent event){
        
        ArrayList<String> dices = new ArrayList<>();
        // Randomly assigning dices face as rolled by the user.
        if(edice == null){
            for(int i = 0 ; i < 5; i++){
                dices.add(faces.get(rand.nextInt(6)));
            }
        }else{
            for(int i = 0 ; i < 2; i++){
                dices.add(edice.get(rand.nextInt(6)));
            }
            for(int j = 0 ; j < 3; j++){
                dices.add(faces.get(rand.nextInt(6)));
            }
            
        }
        
        if(noofReroll ==3){
            // setting image to the dices rtolled by the player.
            d1.setImage(new Image("/DiceFaces/"+dices.get(0)+".PNG/"));
            d2.setImage(new Image("/DiceFaces/"+dices.get(1)+".PNG/"));
            d3.setImage(new Image("/DiceFaces/"+dices.get(2)+".PNG/"));
            d4.setImage(new Image("/DiceFaces/"+dices.get(3)+".PNG/"));
            d5.setImage(new Image("/DiceFaces/"+dices.get(4)+".PNG/"));
            userrolls.add(dices.get(0));
            userrolls.add(dices.get(1));
            userrolls.add(dices.get(2));
            userrolls.add(dices.get(3));
            userrolls.add(dices.get(4));
            
// Changing the dices i.e. rerolling the dices the user chooses tocreroll by clicking the check box below the dice.
        }else{
             if(ck1.isSelected()){
                userrolls.remove(0);
                int a = rand.nextInt(5);
                d1.setImage(new Image("/DiceFaces/"+dices.get(a)+".PNG/"));
                userrolls.add(dices.get(a));
             }
             if(ck2.isSelected()){
                userrolls.remove(1);
                int a = rand.nextInt(5);
                d2.setImage(new Image("/DiceFaces/"+dices.get(a)+".PNG/"));
                userrolls.add(dices.get(a));
             }
             if(ck3.isSelected()){
                userrolls.remove(2);
                int a = rand.nextInt(5);
                d3.setImage(new Image("/DiceFaces/"+dices.get(a)+".PNG/"));
                userrolls.add(dices.get(a));

             }
             if(ck4.isSelected()){
                userrolls.remove(3);
                int a = rand.nextInt(5);
                d4.setImage(new Image("/DiceFaces/"+dices.get(a)+".PNG/"));
                userrolls.add(dices.get(a));

             }
             if(ck5.isSelected()){
                userrolls.remove(4);
                int a = rand.nextInt(5);
                d5.setImage(new Image("/DiceFaces/"+dices.get(a)+".PNG/"));
                userrolls.add(dices.get(a));
             }
             System.out.println("This is my rolls"+userrolls);
        }
        noofReroll--; // reducing the no times user can roll.
        
        System.out.println(noofReroll);
        // Disabling the reroll buttton after rolling the dice 3 times.
        if(noofReroll < 1)
            brd.setDisable(true);
//        if(nxtPl.isPressed())
        System.out.println(noofReroll);
     
    }
    /**
     * This method is especially for user player that takes dices rolled by the user player and send it to another method of different class to analyze it.
     * @param event This is the event taken by user player i.e. clicking "CLICK ME if you are happy with your roll" button in the UI.
     */
    @FXML public void analyzeuserrolls(ActionEvent event){
        try{
            game.player1(userrolls, p1);    // sending the dice rolled by user to method of another class to analyze it.
        } catch (NullPointerException e){
            
        }
    }

    /**
     * This method enables  the no of buttons on the UI based on the no of players and disable the rest. It also reveals all the assigned character's name and revels who is sheriff.
     * @param event The event is clicking the "!!!! BEFORE BEGINNIG THE GAME, CLICK THIS BUTTON !!!!" button in UI.
     */
    @FXML public void Startthegame(ActionEvent event){
        int a = roles.indexOf("Sheriff");
        gamesrf.setText(characters.get(a));
        totalArrow.setText("9");
        p1r1.setImage(new Image("/Roles/"+roles.get(0)+".jpeg"));
        p1c1.setImage(new Image("/Characters/"+characters.get(0)+".jpg"));
        r1.setText(roles.get(0));
        hp1.setText(Integer.toString(HP.get(0)));
        p5.setDisable(true);
        p6.setDisable(true);
        p7.setDisable(true);
        p8.setDisable(true);

        
        p1.setText(characters.get(0));
        p2.setText(characters.get(1));
        p3.setText(characters.get(2));
        p4.setText(characters.get(3));


        switch(characters.size()){
            case 5: p5.setDisable(false); p5.setText(characters.get(4)); break;
            case 6: p5.setDisable(false); p5.setText(characters.get(4)); p6.setDisable(false); p6.setText(characters.get(5)); break;
            case 7: p5.setDisable(false); p5.setText(characters.get(4)); p6.setDisable(false); p6.setText(characters.get(5)); p7.setDisable(false); p7.setText(characters.get(6)); break;
            case 8: p5.setDisable(false); p5.setText(characters.get(4)); p6.setDisable(false); p6.setText(characters.get(5)); p7.setDisable(false); p7.setText(characters.get(6)); p8.setDisable(false); p8.setText(characters.get(7)); break;

        }
        
        bigButton.setDisable(true);
        
    }
    /**
     * This method handles loads the FXML for the User player when its his/her turn.
     * @param event The  Event is when  player click on it character name button.
     * @throws IOException  To handle the IOException incase exists.
     */
    @FXML public void PLayer1(ActionEvent event) throws IOException{
         try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("you.fxml"));
            loader.setController(this);
            // only changingthe center part of the Border pane in the grapgical User interface.
            mainPane.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*object of class GamePlay with parameters:
    HP : Health points of players.
    roles: roles of players playing
    character: characters assigned to players
    edice : expansion dice which may be filled or empty base onm the exp[ansion selected.
    */
    GamePlay game = new GamePlay(HP,roles,characters,edice);

    /**
     * This method handles and loads the FXML for the other player when its his/her turn.
     * @param event The event is when they click on the respective characters name.
     * @throws IOException 
     */
    @FXML public void PLayer2(ActionEvent event) throws IOException {
        noofReroll =3;
        
           
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("otherPlayer.fxml"));
            loader.setController(this);

            mainPane.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       // Calling the methodin GamePLay calss base on the players with parameters ImageView of dice 1 to dice 5 and puttinf the code inside NUllPointerException Handler. 
       try{
            if(event.getSource() == p2){
                game.player2(dp1,dp2,dp3,dp4,dp5,p2);
            } 

            if(event.getSource() == p3){
                game.player3(dp1,dp2,dp3,dp4,dp5,p3);
            } 

            if(event.getSource() == p4){
                game.player4(dp1,dp2,dp3,dp4,dp5,p4);
            } 

            if(event.getSource() == p5){
                game.player5(dp1,dp2,dp3,dp4,dp5,p5);
            } 

            if(event.getSource() == p6){
                game.player6(dp1,dp2,dp3,dp4,dp5,p6);
            } 

            if(event.getSource() == p7){
                game.player7(dp1,dp2,dp3,dp4,dp5,p7);
            } 

            if(event.getSource() == p8){
                game.player8(dp1,dp2,dp3,dp4,dp5,p8);
            } 
           
       }catch (NullPointerException e){
           
       }    
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    /**
     * This method gets information from GamePlay class and loads FXML of winner base on that information.
     * @param a The integer used as a basis for loading different FXML.
     */
//    @FXML public void endgame(ActionEvent event) {
//        Final_oop winner = new Final_oop();
////        int a = winner.geta();
//        if (a == 1){ // for if the outlaw winner
//           try {
//           
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("outlawWinner.fxml"));
//            loader.setController(this);
//
//            mainPane.setCenter(loader.load());
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//                } 
//        }
//        if (a == 2){ // for if sheriff is the winner.
//           try {
//               
//            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("seriffWinner.fxml"));
//            loader.setController(this);
//
//            mainPane.setCenter(loader.load());
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            } 
//        }
//        if (a == 3){ // for if renegade is gthe winner.
//           try { 
//                  
//            
//            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("renegaddeWinner.fxml"));
//            loader.setController(this);
//
//            mainPane.setCenter(loader.load());
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//        } 
//        }
        
//    }

    
}
