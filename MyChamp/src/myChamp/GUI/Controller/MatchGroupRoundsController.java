/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myChamp.BE.Group;
import myChamp.BE.Match;
import myChamp.BE.Team;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Desmoswal
 */
public class MatchGroupRoundsController implements Initializable
{

    @FXML
    private TableView<Match> tblRound1;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound1;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound1;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound1;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound1;
    @FXML
    private TableView<Match> tblRound2;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound2;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound2;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound2;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound2;
    @FXML
    private TableView<Match> tblRound4;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound4;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound4;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound4;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound4;
    @FXML
    private TableView<Match> tblRound6;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound6;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound6;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound6;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound6;
    @FXML
    private TableView<Match> tblRound5;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound5;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound5;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound5;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound5;
    @FXML
    private TableView<Match> tblRound3;
    @FXML
    private TableColumn<Match, String> colHomeTeamRound3;
    @FXML
    private TableColumn<Match, Integer> colHomeGoalsRound3;
    @FXML
    private TableColumn<Match, String> colGuestTeamRound3;
    @FXML
    private TableColumn<Match, Integer> colGuestGoalsRound3;
    
    MyChampModel model = new MyChampModel();
    private List<Match> r1matches = new ArrayList<>();
    private List<Match> r2matches = new ArrayList<>();
    private List<Match> r3matches = new ArrayList<>();
    private List<Match> r4matches = new ArrayList<>();
    private List<Match> r5matches = new ArrayList<>();
    private List<Match> r6matches = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       setTableProperties();
    }    
    
    public void setRounds(Group groupGiven, List<Match> matchlist) {
        for (Match match : matchlist) {
            if(match.getGroup().getUuid().equals(groupGiven.getUuid())) {
                switch(match.getRound()) {
                    case 1:
                        r1matches.add(match);
                        break;
                    case 2:
                        r2matches.add(match);
                        break;
                    case 3:
                        r3matches.add(match);
                        break;
                    case 4:
                        r4matches.add(match);
                        break;
                    case 5:
                        r5matches.add(match);
                        break;
                    case 6:
                        r6matches.add(match);
                        break;
                }
            }
        }
        setTableItems();
    }
    
    @FXML
    private void pressedOnTable(MouseEvent event) throws IOException {
        TableView<Match> pressedTable = (TableView)event.getSource();
        
        if(event.getClickCount()==2 && event.isPrimaryButtonDown() && pressedTable.getSelectionModel().getSelectedItem() != null) {
            Stage primStage = (Stage)tblRound1.getScene().getWindow(); //getting the primary stage from any object of the fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/editMatchDetails.fxml"));
            Parent root = loader.load(); //load the fxml from the URL

            EditMatchDetailsController controller = loader.getController(); //get he controller of the loaded fxml
            controller.setSelectedMatch(pressedTable.getSelectionModel().getSelectedItem());
            controller.setController(this);

            // this is a popup, we will create a new window for it
            Stage stageView = new Stage();
            stageView.setScene(new Scene(root));
            stageView.getIcons().add(new Image("/Images/icon.png"));
            stageView.initModality(Modality.WINDOW_MODAL);
            stageView.initOwner(primStage);
            //-------------------------

            stageView.show();
        }
    }
    
    public void setTableItems() {
        tblRound1.setItems(FXCollections.observableArrayList(r1matches));
        tblRound2.setItems(FXCollections.observableArrayList(r2matches));
        tblRound3.setItems(FXCollections.observableArrayList(r3matches));
        tblRound4.setItems(FXCollections.observableArrayList(r4matches));
        tblRound5.setItems(FXCollections.observableArrayList(r5matches));
        tblRound6.setItems(FXCollections.observableArrayList(r6matches));
        tblRound1.refresh();
        tblRound2.refresh();
        tblRound3.refresh();
        tblRound4.refresh();
        tblRound5.refresh();
        tblRound6.refresh();
        
    }
    
    public void setTableProperties() {
       colHomeTeamRound1.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound1.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound1.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound1.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       colHomeTeamRound2.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound2.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound2.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound2.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       colHomeTeamRound3.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound3.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound3.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound3.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       colHomeTeamRound4.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound4.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound4.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound4.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       colHomeTeamRound5.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound5.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound5.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound5.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       colHomeTeamRound6.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
       colHomeGoalsRound6.setCellValueFactory(new PropertyValueFactory("homeTeamGoals"));
       colGuestTeamRound6.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
       colGuestGoalsRound6.setCellValueFactory(new PropertyValueFactory("guestTeamGoals"));
       /*YEEES IT'S DONE!!*/
    }
    
    public void saveToFile() {
        /*
        THE ULTIMATE WAY TO SAVE TEAMS AND THEIR POINTS
        */
        for(Match roundmatch : r1matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        for(Match roundmatch : r2matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        for(Match roundmatch : r3matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        for(Match roundmatch : r4matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        for(Match roundmatch : r5matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        for(Match roundmatch : r6matches) {
            for(Team team : model.getTeams()) {
                if(roundmatch.getHomeTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getHomeTeam().getScore());
                }
                if(roundmatch.getGuestTeam().getUUID().equals(team.getUUID())) {
                    team.setScore(roundmatch.getGuestTeam().getScore());
                }
            }
        }
        
        /*
        THE ULTIMATE WAY TO SAVE MATCHES AND THEIR STATUS
        */
        for(Match roundmatch : r1matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match.setHomeTeamGoals(roundmatch.getHomeTeamGoals());
                    match.setGuestTeamGoals(roundmatch.getGuestTeamGoals());
                }
            }
        }
        for(Match roundmatch : r2matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match = roundmatch;
                }
            }
        }
        for(Match roundmatch : r3matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match = roundmatch;
                }
            }
        }
        for(Match roundmatch : r4matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match = roundmatch;
                }
            }
        }
        for(Match roundmatch : r5matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match = roundmatch;
                }
            }
        }
        for(Match roundmatch : r6matches) {
            for(Match match : model.getMatches()) {
                if(match.getUuid().equals(roundmatch.getUuid())) {
                    match = roundmatch;
                }
            }
        }
        
        model.saveMatches(model.getMatches());
        model.saveTeams(model.getTeams());
    }
}
