package com.example.moviedatabase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class ClientController {

@FXML
    TextField productionCompany;
 public static String str;
    @FXML
    private void onLoadClick(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

      str=productionCompany.getText();

     Client.createClient(productionCompany.getText());
        System.out.println(productionCompany.getText());




    Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

    FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("productionCompanySearchingMenu.fxml"));

    Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
    Image icon=new Image("movie_icon2.png");
    stage.getIcons().add(icon);
    stage.setTitle("Movie Database ");
      ProductionCompanySearchingMenuController company=fxmlLoader.getController();
        company.labeling(ClientController.str);

    stage.setScene(scene);
    stage.show();

    }



    public void onExitClick(ActionEvent actionEvent) {

        System.exit(1);
    }
}