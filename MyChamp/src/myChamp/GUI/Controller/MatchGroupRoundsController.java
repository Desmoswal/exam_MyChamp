/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import myChamp.BE.Team;

/**
 * FXML Controller class
 *
 * @author Desmoswal
 */
public class MatchGroupRoundsController implements Initializable
{

    @FXML
    private TableView<Team> tblRound1;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound1;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound1;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound1;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound1;
    @FXML
    private TableView<Team> tblRound2;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound2;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound2;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound2;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound2;
    @FXML
    private TableView<Team> tblRound4;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound4;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound4;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound4;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound4;
    @FXML
    private TableView<Team> tblRound6;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound6;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound6;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound6;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound6;
    @FXML
    private TableView<Team> tblRound5;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound5;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound5;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound5;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound5;
    @FXML
    private TableView<Team> tblRound3;
    @FXML
    private TableColumn<Team, String> colHomeTeamRound3;
    @FXML
    private TableColumn<Team, Integer> colHomeGoalsRound3;
    @FXML
    private TableColumn<Team, String> colGuestTeamRound3;
    @FXML
    private TableColumn<Team, Integer> colGuestGoalsRound3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
