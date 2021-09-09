/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * This class implements the full game play of the whole game based on the dices rolled by each players.
 * @author norbulama
 */
public class GamePlay {
    // ArrayList for 
    ArrayList<String> dice = new ArrayList<>(Arrays.asList("DiArrow", "DiBeer", "DiDynamite", "DiGatling", "DiOne", "DiTwo"));    // ArrayList for dice faces.
    ArrayList<String> edice = new ArrayList<>();   // ArrayList for expansion dice
    ArrayList<String> urroll = new ArrayList<>();   // ArrayList for dice rolled by each players.
    ArrayList<Integer> allhp;   // ArrayList for health pointsd of all the players.
    ArrayList<String> roles;   // ArrayList for roles of all the playesrs.
    ArrayList<String> characters;   // ArrayList for characters of all the aplayers.
    ArrayList<Integer> arrow = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0)); // no of arrows each player have at the beginning of the game.
    
//    ArrayList<String> fdice = new ArrayList<>();
    Random rand = new Random();
    int HP0,HP1,HP2,HP3,HP4,HP5,HP6,HP7=0;    // heatth points for all the players
    int MHP0,MHP1,MHP2,MHP3,MHP4,MHP5,MHP6,MHP7=0;    // max health points for all the players
//    int a0,a1,a2,a3,a4,a5,a6,a7 =0 ;    //  initial no of arrows for each players
    int totalArrow = 9;
    
    Button srfbtn;
    Button outlbtn;
    Button renbtn;
    Button depbtn;
    
    
    /**
     * 
     * @param hp    An arrayList of health points of all the players
     * @param roles An arrayList of roles assigned to players.
     * @param characters    An arrayList of characters assigned to players
     * @param ed This is an arrayList of expansions dice which will be used if expansion is included.
     */
    public GamePlay(ArrayList<Integer> hp,ArrayList<String> roles, ArrayList<String> characters, ArrayList<String> ed){
        this.roles = roles;
        this.characters = characters;
        this.allhp = hp;
        this.edice = ed;
        // Assigning extra 2 health points for the sheriff.
        int a = roles.indexOf("Sheriff");
        int h = allhp.get(a);
        h = h+2;
        allhp.set(a, h);
        // Assigning the value to Health point and max health point possible for all the players.
        HP0 = MHP0 = hp.get(0);
        HP1 = MHP1 = hp.get(1);
        HP2 = MHP2 =hp.get(2);
        HP3 = MHP3 =hp.get(3);
        // if there are more than 4 players, assigning the health ppoint and max health value to them too.
        switch (hp.size()) {
            case 5:
                HP4 = MHP4 = hp.get(4);
                break;
            case 6:
                HP4 = MHP4 = hp.get(4);
                HP5 = MHP5 = hp.get(5);
                break;
            case 7:
                HP4 = MHP4 = hp.get(4);
                HP5 = MHP5 = hp.get(5);
                HP6 = MHP6 = hp.get(6);
                break;
            case 8:
                HP4 = MHP4 = hp.get(4);
                HP5 = MHP5 = hp.get(5);
                HP6 = MHP6 = hp.get(6);
                HP7 = MHP7 = hp.get(7);
                break;
            default:
                break;
        }
        System.out.println("This is the informastion passed");
// printing imoformation passed from playersFXMLController class.
        System.out.println(edice);
        System.out.println(this.roles);
        System.out.println(this.characters);
        System.out.println(allhp);

    }

    public GamePlay() {
        
    }
    
    
/**
 * This method takes input for user player and takes actions based on that.
 * @param userrolls This is the dice rolled by the user player
 * @param p1  This is the fx id for user player button.
 */
    public void player1(ArrayList<String> userrolls, Button p1) {
        System.out.println("******USER PLAYER*****");
//        if(allhp.get(0)<=0){
//            p1.setDisable(true);
//        }
        this.urroll = userrolls;
        System.out.println("YOU rolled : " + urroll);
        String role = roles.get(0);
        String character = characters.get(0);
        if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p1;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p1;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p1;
        }else{
            depbtn = p1;
        }
        Collections.sort(urroll);
        analyzerolls(role,character,0,p1);
        
    }
    /**
     * This method takes input for computer player 2 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p2  This is the BUtton fx id for the player 2 button
     */
    public void player2(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p2) {
        System.out.println("******Player 2 *****");
//        if(allhp.get(1)<=0){
//            p2.setDisable(true);
//        }
        String role = roles.get(1);
        String character = characters.get(1);  
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p2;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p2;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p2;
        }else{
            depbtn = p2;
        }
                    
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            } 
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        System.out.println("Player 2 rolled : "+urroll);
        Collections.sort(urroll);
        analyzerolls(role,character,1,p2);
        urroll.clear();
        
    }
 
    /**
     * This method takes input for computer player 3 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p3  This is the BUtton fx id for the player 3 button
     */
    public void player3(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p3) {
        System.out.println("******PLAYER 3 *****");
//        if(allhp.get(2)<=0){
//            p3.setDisable(true);
//        }
        String role = roles.get(2);
        String character = characters.get(2); 
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p3;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p3;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p3;
        }else{
            depbtn = p3;
        }
                    
         if(edice==null){
             for(int i=0; i<5; i++){
                 urroll.add(dice.get(rand.nextInt(6)));
             }
         }else{
             for(int i = 0; i<2;i++){
                 urroll.add(edice.get(rand.nextInt(6)));
             }
             for(int i =0; i<3; i++){
                 urroll.add(dice.get(rand.nextInt(6)));
             }
         }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));

        Collections.sort(urroll);
        System.out.println("Player 3 rolled : " + urroll);
        analyzerolls(role,character, 2,p3);

        urroll.clear();
    }

    
    /**
     * This method takes input for computer player 4 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p4  This is the BUtton fx id for the player 4 button
     */
    public void player4(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p4) {
        System.out.println("******PLAYER 4 *****");
//        if(allhp.get(3)<=0){
//            p4.setDisable(true);
//        }

        String role = roles.get(3);
        String character = characters.get(3);       
                    
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p4;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p4;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p4;
        }else{
            depbtn = p4;
        }
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            }     
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        
        Collections.sort(urroll);
        System.out.println("Player 4 rolled: "+ urroll);
        analyzerolls(role,character,3,p4);
        urroll.clear();
    }

    /**
     * This method takes input for computer player 5 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p5  This is the BUtton fx id for the player 5 button
     */
    public void player5(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p5) {
        System.out.println("******PLAYER 5 *****");
//        if(allhp.get(4)<=0){
//            p5.setDisable(true);
//        }
        String role = roles.get(4);
        String character = characters.get(4);
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p5;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p5;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p5;
        }else{
            depbtn = p5;
        }
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            }     
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        
        Collections.sort(urroll);
        System.out.println("Player 5 rolled : " +urroll);

        analyzerolls(role,character,4,p5);
        urroll.clear();
    }

    /**
     * This method takes input for computer player 6 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p6  This is the BUtton fx id for the player 6 button
     */

    public void player6(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p6) {
        System.out.println("******PLAYER 6 *****");
//        if(allhp.get(5)<=0){
//            p6.setDisable(true);
//        }
        String role = roles.get(5);
        String character = characters.get(5);
                
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p6;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p6;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p6;
        }else{
            depbtn = p6;
        }
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            }     
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        
        Collections.sort(urroll);
        System.out.println("Player 6 rolled : " +urroll);

        analyzerolls(role,character,5,p6);
        urroll.clear();
    }

    /**
     * This method takes input for computer player 7 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p7  This is the BUtton fx id for the player 7 button
     */
    public void player7(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p7) {
        System.out.println("******PLAYER 7 *****");
//        if(allhp.get(6)<=0){
//            p7.setDisable(true);
//        }
        String role = roles.get(6);
        String character = characters.get(6);
               
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p7;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p7;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p7;
        }else{
            depbtn = p7;
        }
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            }     
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        
        Collections.sort(urroll);
        System.out.println("Player 7 rolled : " +urroll);

        analyzerolls(role,character,6,p7);
        urroll.clear();
    }

    /**
     * This method takes input for computer player 8 and takes actions base on that.
     * @param dp1 This is the first dice face Image view for this player
     * @param dp2 This is the first dice face Image view for this player
     * @param dp3 This is the first dice face Image view for this player
     * @param dp4 This is the first dice face Image view for this player
     * @param dp5 This is the first dice face Image view for this player
     * @param p8  This is the BUtton fx id for the player 8 button
     */
    public void player8(ImageView dp1, ImageView dp2, ImageView dp3,ImageView dp4,ImageView dp5, Button p8) {
        System.out.println("******PLAYER 8 *****");

//        if(allhp.get(7)<=0){
//            p8.setDisable(true);
//        }
        String role = roles.get(7);
        String character = characters.get(7);
         if(role.equalsIgnoreCase("Sheriff")){
            srfbtn = p8;
        }else if (role.equalsIgnoreCase("Outlaw")){
            outlbtn = p8;
        }else if(role.equalsIgnoreCase("Renegade")){
            renbtn = p8;
        }else{
            depbtn = p8;
        }
                   
        if(edice==null){
            for(int i=0; i<5; i++){
               urroll.add(dice.get(rand.nextInt(6)));
            }     
        }else{
            for(int i = 0; i<2;i++){
                    urroll.add(edice.get(rand.nextInt(6)));
            }
            for(int i =0; i<3; i++){
                urroll.add(dice.get(rand.nextInt(6)));
            }  
            
        }
        dp1.setImage(new Image("/DiceFaces/"+urroll.get(0)+".PNG"));
        dp2.setImage(new Image("/DiceFaces/"+urroll.get(1)+".PNG"));
        dp3.setImage(new Image("/DiceFaces/"+urroll.get(2)+".PNG"));
        dp4.setImage(new Image("/DiceFaces/"+urroll.get(3)+".PNG"));
        dp5.setImage(new Image("/DiceFaces/"+urroll.get(4)+".PNG"));
        
        Collections.sort(urroll);
        System.out.println("Player 8 rolled : " +urroll);
        analyzerolls(role,character,7,p8);
        urroll.clear();
    }

    public void analyzerolls(String c, String r, int index, Button p) {
        int HP = 0;
        int MHP = 0;
        switch(index){
            case 0: HP = HP0; MHP = MHP0; break;
            case 1: HP = HP1; MHP = MHP1; break;
            case 2: HP = HP2; MHP = MHP2; break;
            case 3: HP = HP3; MHP = MHP3; break;
            case 4: HP = HP4; MHP = MHP4; break;
            case 5: HP = HP5; MHP = MHP5; break;
            case 6: HP = HP6; MHP = MHP6; break;
            case 7: HP = HP7; MHP = MHP7; break;

                
        }
        int d =0; //no of dynamite dice
        int g =0; // no of gatling dice
        for(int i = 0; i < 5 ;i++){
            // Checks if the dices face is Dynamite and takes actions base on that.            
            if(urroll.get(i).equalsIgnoreCase("DiDynamite")){
                d++;
            }
            // Checks if the dices face is Beer and takes actions base on that.
            else if(urroll.get(i).equalsIgnoreCase("DiBeer")){
                if(allhp.get(index)<MHP){
                    int h = allhp.get(index);
                    allhp.set(index, h+1);
                }else{
                    if(r.equalsIgnoreCase("Deputy")){
                        int a = roles.indexOf("Sheriff"); // Increate the Health points of Sheriff
                        switch (a) {
                            case 0:
                                if(allhp.get(0)<MHP0){
                                    int h = allhp.get(0);
                                    allhp.set(0, h+1);
                                    break;} 
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 1:
                                if(allhp.get(1)<MHP1){
                                    int h = allhp.get(1);
                                    allhp.set(1, h+1);
                                    break;} 
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 2:
                                if(allhp.get(2)<MHP2){
                                    int h = allhp.get(2);
                                    allhp.set(2, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 3:
                                if(allhp.get(3)<MHP3){
                                    int h = allhp.get(3);
                                    allhp.set(3, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 4:
                                if(allhp.get(4)<MHP4){
                                    int h = allhp.get(4);
                                    allhp.set(4, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 5:
                                if(allhp.get(5)<MHP5){
                                    int h = allhp.get(5);
                                    allhp.set(5, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 6:
                                if(allhp.get(6)<MHP6){
                                    int h = allhp.get(6);
                                    allhp.set(6, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            case 7:
                                if(allhp.get(7)<MHP7){
                                    int h = allhp.get(7);
                                    allhp.set(7, h+1);
                                    break;}
                                else{
                                    System.out.println("Do not wish to share Beer");}
                                break;
                            
                            default:
                                break;
                        }
                    }    
                    else{
                        System.out.println("Do not wish to give health to anyone!!!");
                    }
                }
            }
            // Checks if the dices face is DiOne and takes actions base on that.
            else if(urroll.get(i).equalsIgnoreCase("DiOne")){
                int ran = rand.nextInt(2);
                System.out.println(" random no : "+ ran);
                if(ran ==1){
                    int a = index+1;
                    if(a>=allhp.size()){
                        switch(allhp.size()){
                            case 4:{
                                if (a==4)
                                    a=0;
                                else a=index+1;
                            } break;
                            case 5:{
                                if(a == 5)
                                    a=0;
                                else a=index+1;
                            } break;
                            case 6:{
                                if(a == 6)
                                    a=0;
                                else a=index+1;
                            }
                            case 7:{
                                if(a == 7)
                                    a=0;
                                else a=index+1;
                            }case 8:{
                                if(a == 8)
                                    a=0;
                                else a=index+1;
                            }
                            default:
                                break;
                        }
                    }
                    
                    // reduce Health point of player after themselves.
                    int hp = allhp.get(a);
                    hp--;
                    allhp.set(a, hp);
                    
//                    sethp(a, 1);
                    
                }
                else {
                    int a = index-1;
                    switch(allhp.size()){
                        case 4:{
                            if (a==-1)
                                a=3;
//                            else a=index+1;
                        } break;
                        case 5:{
                            if(a == -1)
                                a=4;
//                            else a=index-1;
                        } break;
                        case 6:{
                            if(a == -1)
                                a=5;
//                            else a=index-1;
                        }break;
                        case 7:{
                            if(a == -1)
                                a=6;
//                            else a=index-1;
                        }break;
                        case 8:{
                            if(a == -1)
                                a=7;
//                            else a=index-1;
                        }break;
                        default:
                            a = index-1;
                            break;
                               
                    }
                     //reduce health point of player  before themselves by 1.
                    int hp = allhp.get(a);
                    hp--;
                    allhp.set(a, hp);

                } 
            }
            // Checks if the dices face is DiTwo and takes actions base on that.
            else if(urroll.get(i).equalsIgnoreCase("DiTwo")){
                int ran = rand.nextInt(2);
                                System.out.println(" random no : "+ ran);

                // reduce Health point of player two step before themselves by 1.
                if(ran == 1){
                    int a = index+2;
                    if(a>=roles.size()){
                        int s = roles.size();
                        switch (s) {
                            case 4:
                                if(a==4){ a=0; } else if (a==5){ a = 1;}
                                break;
                            case 5:
                                if(a==5){
                                    a=0;
                                }else if (a==6){
                                    a = 1;
                                }   break;
                            case 6:
                                if(a==6){
                                    a=0;
                                }else if(a==7){
                                    a=1;
                                }   break;
                            case 7:
                                if(a==7){
                                    a=0;
                                }else if (a==8){
                                    a=1;
                                }   break;
                            case 8:
                                if(a==8){
                                    a=0;
                                }else if(a==9){
                                    a=1;
                                }   break;
                            default:
                                break;
                        }
                        
                    }
                    int hp = allhp.get(a);
                    hp--;
                    allhp.set(a, hp);
                }

                else{
                    int a = index-2;
                    switch(allhp.size()){
                        case 4:{
                        switch (a) {
                            case -1:
                                a=3;
                                break;
                            case -2:
                                a=2;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        } break;
                        case 5:{
                        switch (a) {
                            case -1:
                                a=4;
                                break;
                            case -2:
                                a=3;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        } break;
                        case 6:{
                        switch (a) {
                            case -1:
                                a=5;
                                break;
                            case -2:
                                a=4;
                                break;
                            default:
//                                a=index+2;
                                break;
                        }
                        }break;
                        case 7:{
                        switch (a) {
                            case -1:
                                a=6;
                                break;
                            case -2:
                                a=5;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        }break;
                        case 8:{
                        switch (a) {
                            case -1:
                                a=7;
                                break;
                            case -2:
                                a=6;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        }break;
                        default:
                            break;       
                    }
                    int hp = allhp.get(a);
                    hp--;
                    allhp.set(a, hp);
                }                
            }
            // Checks if the dices face is Gatling and takes actions base on that.
            else if(urroll.get(i).equalsIgnoreCase("DiGatling"))
                g++;
            // Checks if the dices face is Arrow and takes actions base on that.
            else if (urroll.get(i).equalsIgnoreCase("DiArrow")){
                arrow.set(index, arrow.get(index)+1); 
                totalArrow--;
//                switch(index){
//                    
//                    case 0: a0++; totalArrow--;  break;
//                    case 1: a1++; totalArrow--;  break;
//                    case 2: a2++; totalArrow--;  break;
//                    case 3: a3++; totalArrow--;  break;
//                    case 4: a4++; totalArrow--;  break;
//                    case 5: a5++; totalArrow--;  break;
//                    case 6: a6++; totalArrow--;  break;
//                    case 7: a7++; totalArrow--;  break;
//                    default:
//                            break;
//                }
            }
            // Checks if the dices face is BrokenArrow and takes actions base on that.
            else if(urroll.get(i).equalsIgnoreCase("BrokenArrow")){
                
                // reduce the number of arrows one holds if they get this dice
                
                if(arrow.get(index)>0){
                    arrow.set(index,arrow.get(index)-1); 
                    totalArrow++;
                }
                
//                switch(index){
//                    case 0: if (a0>0){ a0--; totalArrow++; break;} break;
//                    case 1: if (a1>0){ a1--; totalArrow++; break;} break;
//                    case 2: if (a2>0){ a2--; totalArrow++; break;} break;
//                    case 3: if (a3>0){ a3--; totalArrow++; break;} break;
//                    case 4: if (a4>0){ a4--; totalArrow++; break;} break;
//                    case 5: if (a5>0){ a5--; totalArrow++; break;} break;
//                    case 6: if (a6>0){ a6--; totalArrow++; break;} break;
//                    case 7: if (a7>0){ a7--; totalArrow++; break;} break;
//                    
//                    default:
//                        System.out.println("The Broken Arrow could not be implemented right now !!! ");
//                        break;
//                    
//                }
                

            }
            
            // Checks if the dices face is Bullet and take sactions base on that.
            else if (urroll.get(i).equalsIgnoreCase("Bullet")){
                allhp.set(index, allhp.get(index)-1);
            }
            // Checks if the dices face is Double one and take sactions base on that.
            else if (urroll.get(i).equalsIgnoreCase("DoubleOne")){
                
                int ran = rand.nextInt(2);
                                System.out.println(" random no : "+ ran);

                if(ran ==1){
                    int a = index+1;
                    switch(allhp.size()){
                        case 4:{
                            if (a==4)
                                a=0;
                            else a=index+1;
                        } break;
                        case 5:{
                            if(a == 5)
                                a=0;
                            else a=index+1;
                        } break;
                        case 6:{
                            if(a == 6)
                                a=0;
                            else a=index+1;
                        }break;
                        case 7:{
                            if(a == 7)
                                a=0;
                            else a=index+1;
                        }break;
                        case 8:{
                            if(a == 8)
                                a=0;
                            else a=index+1;
                        }break;
                        default:
                            break;
                               
                    }
                    // reduce Health point of player after themselves.
                    int hp = allhp.get(a);
                    hp =hp-2;
                    allhp.set(a, hp);
                }
                else {
                    int a = index-1;
                    switch(allhp.size()){
                        case 4:{
                            if (a==-1)
                                a=3;
                            else a=index+1;
                        } break;
                        case 5:{
                            if(a == -1)
                                a=4;
                            else a=index-1;
                        } break;
                        case 6:{
                            if(a == -1)
                                a=5;
                            else a=index-1;
                        }break;
                        case 7:{
                            if(a == -1)
                                a=6;
                            else a=index-1;
                        }break;
                        case 8:{
                            if(a == -1)
                                a=7;
                            else a=index-1;
                        }break;
                        default:
                            break;
                               
                    }
                    // reduce health point of player  before themselves by 1.
                    int hp = allhp.get(a);
                    hp = hp-2;
                    allhp.set(a, hp);
                } 

            }
            else if(urroll.get(i).equalsIgnoreCase("DoubleTwo")){
           
                int ran = rand.nextInt(2);
                                System.out.println(" random no : "+ ran);

                // reduce Health point of player two step after themselves by 1.
                if(ran == 1){
                    int a = index+2;
                    switch(allhp.size()){
                        case 4:{
                        switch (a) {
                            case 4:
                                a=0;
                                break;
                            case 5:
                                a=1;
                                break;
                            default:
                                a=index+2;
                                break;
                        }
                        } break;
                        case 5:{
                        switch (a) {
                            case 5:
                                a=0;
                                break;
                            case 6:
                                a=1;
                                break;
                            default:
                                a=index+2;
                                break;
                        }
                        } break;
                        case 6:{
                            switch (a) {
                                case 6:
                                    a=0;
                                    break;
                                case 7:
                                    a=1;
                                    break;
                                default:
                                    a=index+2;
                                    break;
                            }
                        }break;
                        case 7:{
                            switch (a) {
                                case 7:
                                    a=0;
                                    break;
                                case 8:
                                    a=1;
                                    break;
                                default:
                                    a=index+2;
                                    break;
                            }
                        }break;
                        case 8:{
                        switch (a) {
                            case 8:
                                a=0;
                                break;
                            case 9:
                                a=1;
                                break;
                            default:
                                a=index+2;
                                break;
                        }
                        }break;
                        default:
                            break;       
                    }
                    int hp = allhp.get(a);
                    hp= hp-4;
                    allhp.set(a, hp);
                }
                else{
                    int a = index-2;
                    switch(allhp.size()){
                        case 4:{
                        switch (a) {
                            case -1:
                                a=3;
                                break;
                            case -2:
                                a=2;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        } break;
                        case 5:{
                        switch (a) {
                            case -1:
                                a=4;
                                break;
                            case -2:
                                a=3;
                                break;
                            default:
//                                a=index-2;
                                break;
                        }
                        } break;
                        case 6:{
                        switch (a) {
                            case -1:
                                a=5;
                                break;
                            case -2:
                                a=4;
                                break;
                            default:
                                break;
                        }
                        }break;
                        case 7:{
                        switch (a) {
                            case -1:
                                a=6;
                                break;
                            case -2:
                                a=5;
                                break;
                            default:
                                break;
                        }
                        }break;
                        case 8:{
                        switch (a) {
                            case -1:
                                a=7;
                                break;
                            case -2:
                                a=6;
                                break;
                            default:
                                break;
                        }
                        }break;
                        default:
                            break;       
                    }
                    
                    allhp.set(a, allhp.get(a)-4);
//                    int hp = allhp.get(a);
//                    hp= hp-4;
//                    allhp.set(a, hp);
                }
                
            }
            else if(urroll.get(i).equalsIgnoreCase("DoubleBeer")){
                int n = 0;
                if(allhp.get(index)<MHP){
                    allhp.set(index, allhp.get(index)+1);
                    n++;
                    if(allhp.get(index)<MHP){
                        allhp.set(index, allhp.get(index)+1);
                        n++;
                    }
                }if(n < 2){
                    if(r.equalsIgnoreCase("Deputy")){
                        int a = roles.indexOf("Sheriff"); // Increate the Health points of Sheriff
                        switch (a) {
                            case 0:
                                if(allhp.get(0)<MHP0){
                                    allhp.set(0, allhp.get(0)+1);
                                if(allhp.get(0)<MHP0 && n == 1)
                                    allhp.set(0, allhp.get(0)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 1:
                                if(allhp.get(1)<MHP1){
                                    allhp.set(1, allhp.get(1)+1);
                                if(allhp.get(1)<MHP1 && n == 1)
                                    allhp.set(1, allhp.get(1)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 2:
                                if(allhp.get(2)<MHP2){
                                    allhp.set(2, allhp.get(2)+1);
                                if(allhp.get(2)<MHP2 && n == 1)
                                    allhp.set(2, allhp.get(2)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 3:
                                if(allhp.get(3)<MHP3){
                                    allhp.set(3, allhp.get(3)+1);
                                if(allhp.get(3)<MHP3 && n == 1)
                                    allhp.set(3, allhp.get(3)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 4:
                                if(allhp.get(4)<MHP4){
                                    allhp.set(4, allhp.get(4)+1);
                                if(allhp.get(4)<MHP0 && n == 1)
                                    allhp.set(4, allhp.get(4)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 5:
                                if(allhp.get(5)<MHP5){
                                    allhp.set(5, allhp.get(5)+1);
                                if(allhp.get(5)<MHP5 && n == 1)
                                    allhp.set(5, allhp.get(5)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 6:
                                if(allhp.get(6)<MHP6){
                                    allhp.set(6, allhp.get(6)+1);
                                if(allhp.get(6)<MHP6 && n == 1)
                                    allhp.set(6, allhp.get(6)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;
                            case 7:
                                if(allhp.get(7)<MHP7){
                                    allhp.set(7, allhp.get(7)+1);
                                if(allhp.get(7)<MHP7 && n == 1)
                                    allhp.set(7, allhp.get(7)+1);
                                }
                                else
                                    System.out.println("Do not wish to share Beer");
                                break;

                            default:
                                break;
                        }
                    } 
                }
                    
                else{
                    System.out.println("Do not wish to give health to anyone!!!");
                }
            }

            else if(urroll.get(i).equalsIgnoreCase("DoubleGatling")){
                g=g+2;
            }

            
        }
        // reduce the hp of that index player if they get more than or equal to 3 dynamite.
        if(d >=3){
            allhp.set(index, allhp.get(index)-1);

        }
        // reduce the of every player except themselves if they get more than or ewual to 3 gatling dice vslue.
        if(g >=3){
            for(int i =0; i < allhp.size(); i++){
                if(i == index){
                    continue;}
                else{
                    allhp.set(i, allhp.get(i)-1);
                }
            }
            

        }
        // if the total arrow in the game if distributed to all the players then reduce the hp with no of arrows they got.
        if(totalArrow<=0){
            try{
                allhp.set(0, allhp.get(0)-arrow.get(0));
                allhp.set(1, allhp.get(1)-arrow.get(1));
                allhp.set(2, allhp.get(2)-arrow.get(2));
                allhp.set(3, allhp.get(3)-arrow.get(3));
                allhp.set(4, allhp.get(4)-arrow.get(4));
                allhp.set(5, allhp.get(5)-arrow.get(5));
                allhp.set(6, allhp.get(6)-arrow.get(6));
                allhp.set(7, allhp.get(7)-arrow.get(7)); 
            } catch (IndexOutOfBoundsException e){
                
            }
            for(int i = 0; i < arrow.size(); i++){
                arrow.set(i, 0);
            }
            
//            a0=0; a1 = 0; a2 = 0; a3 = 0 ;a4 = 0; a5 = 0; a6 = 0 ; a7=0;
            totalArrow =9;
        }

       System.out.println("total Arrows : " + totalArrow);
        System.out.println( "The arrows accumulated by players: " + arrow);
    // resetting the no of dynamite and gatling after each turn.
        d=0;
        g=0;
        
        if(allhp.get(index)<=0){
            p.setDisable(true);
            System.out.println(roles.get(index) + " just died!!!");
        }
        
        
        // clearing the dice rolled after each turn.
        urroll.clear();
        System.out.println("The Remainig Health point of all players is : " + allhp);
        checkwinner(); // checking to see if someone won the agme after each turn.
    }
    
/**
 * This method checks and analyze the Health points of all player after each turn and tells if the they died or not and if somebody won the game of not.
 */
    public void checkwinner() {
    
        ArrayList<Integer> lhp = allhp;
        int size = allhp.size();
        int a = roles.indexOf("Sheriff");
        int b = roles.indexOf("Deputy");
        int c = roles.indexOf("Renegade");
        int d = roles.indexOf("Outlaw");
        if(srfbtn.isDisabled() && depbtn.isDisabled() && outlbtn.isDisabled()){
//            Final_oop winner = new Final_oop();
            System.out.println("Renegade won the game.");
//            winner.seta(3);
        }
        else if(renbtn.isDisabled() && outlbtn.isDisabled()){
//            Final_oop winner = new Final_oop();
            System.out.println("Sheriff won the game.");
//            winner.seta(2);
        }        
        else if(srfbtn.isDisabled()){
//            Final_oop winner = new Final_oop();
            System.out.println("Outlaw won the game.");
//            winner.seta(1);
        }
         

    }


}
