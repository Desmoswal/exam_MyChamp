/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Desmoswal
 */
public class EditMatchDetailsController implements Initializable
{

    @FXML
    private Label lblHomeTeam;
    @FXML
    private Label lblGuestTeam;
    @FXML
    private TextField txtHomeGoals;
    @FXML
    private TextField txtGuestGoals;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void pressedBtnSave(ActionEvent event)
    {
    }
    
}
