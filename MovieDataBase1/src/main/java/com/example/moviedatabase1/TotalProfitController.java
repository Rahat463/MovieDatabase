package com.example.moviedatabase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TotalProfitController {
@FXML
    TextField profitField;
    public void onTotalProfitClick(ActionEvent actionEvent) {
        long profit=ProductionCompany.totalProfit(ClientController.str);
        String s=String.valueOf(profit);
        profitField.setText(s);


    }

    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("productionCompanySearchingMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();
    }


}
