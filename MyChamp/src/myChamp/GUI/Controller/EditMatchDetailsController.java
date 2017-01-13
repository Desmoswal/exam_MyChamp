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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import myChamp.BE.Match;

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
    @FXML
    private ToggleGroup toggleWinner;
    @FXML
    private Label lblHomeTeam1;
    @FXML
    private RadioButton rbHomeTeam;
    @FXML
    private RadioButton rbGuestTeam;
    @FXML
    private RadioButton rbDraw;
    
    private Match selected = null;
    private MatchGroupRoundsController modalController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }
    
    @FXML
    private void pressedBtnSave(ActionEvent event)
    {
        saveSelectedMatch();
        
        modalController.setTableProperties();
        modalController.setTableItems();
        modalController.saveToFile();
        Stage stage = (Stage) lblHomeTeam.getScene().getWindow();
        stage.close();
    }
    
    public void setSelectedMatch(Match selected) {
        this.selected = selected;
        
        lblHomeTeam.setText(selected.getHomeTeamName());
        lblGuestTeam.setText(selected.getGuestTeamName());
        
        txtHomeGoals.setText(""+selected.getHomeTeamGoals());
        txtGuestGoals.setText(""+selected.getGuestTeamGoals());
    }
    
    private void saveSelectedMatch() {
        if(toggleWinner.getSelectedToggle() != null) {
            if(toggleWinner.getSelectedToggle().equals(rbHomeTeam)) {
                selected.getHomeTeam().setScore(selected.getHomeTeam().getScore()+3);
            } else if(toggleWinner.getSelectedToggle().equals(rbGuestTeam)) {
                selected.getGuestTeam().setScore(selected.getGuestTeam().getScore()+3);
            } else if(toggleWinner.getSelectedToggle().equals(rbDraw)) {
                selected.getGuestTeam().setScore(selected.getGuestTeam().getScore()+1);
                selected.getHomeTeam().setScore(selected.getHomeTeam().getScore()+1);
            }
        }
        selected.setHomeTeamGoals(Integer.parseInt(txtHomeGoals.getText()));
        selected.getHomeTeam().setGoals(selected.getHomeTeam().getGoals()+Integer.parseInt(txtHomeGoals.getText()));
        
        selected.setGuestTeamGoals(Integer.parseInt(txtGuestGoals.getText()));
        selected.getGuestTeam().setGoals(selected.getGuestTeam().getGoals()+Integer.parseInt(txtGuestGoals.getText()));
    }
    
    public void setController(MatchGroupRoundsController con) {
        modalController = con;
    }
}
