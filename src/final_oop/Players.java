/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_oop;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author norbulama
 */
public class Players extends AnchorPane {
    
    HashMap<String,String> pls = new HashMap<>();
    ArrayList<String> frole = new ArrayList<>();
    ArrayList<String> fcharacter = new ArrayList<>();
    
    String role;
    String character;
    
    Players(){
        
    }
    
    
    Players(ArrayList<String> frole, ArrayList<String> fcharacters) {
        this.frole = frole;
        this.fcharacter = fcharacter;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public void setCharacter(String character) {
       this.character = character;
    }
    String getRole(){
        return role;
    }
    
    String getCharacter() {
        return character;

    }

    
 
    
}
