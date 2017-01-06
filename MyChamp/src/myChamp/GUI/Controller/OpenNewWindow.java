/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.print.DocFlavor;

/**
 *
 * @author Kristof
 */
public abstract class OpenNewWindow {
    
    public static void openPopup(Parent fromWhere, URL fxmlPath) throws IOException {
        Stage primStage = (Stage)fromWhere.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(fxmlPath);
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        // this is a popup, we will create a new window for it
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));

        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);

        //-------------------------

        stageView.show();
    }
    
    public static void openWindowInParent(Parent fromWhere, URL fxmlPath) throws IOException {
        Stage primStage = (Stage) fromWhere.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(fxmlPath);
        Parent root = loader.load();
        
        loader.getController();
        
        //this is not a popup, it opens in the parent window
        primStage.setScene(new Scene(root));
        
        primStage.show();
    }
}
