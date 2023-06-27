package com.example.moviedatabase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductionCompanySearchingMenuController {


@FXML
    Label company;

    public void onMostRecentMoviesClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("searchingMostRecentMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);

        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();

    }
    public void onBackToMainMenuClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("clientController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);

        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();
    }

    public void onMoviesWithMaximumRevenueClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("searchingMoviesWithMaximumRevenue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);

        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();

    }


    public void onProfitClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("totalProfit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");

        stage.setScene(scene);
        stage.show();


    }

    public void onAddMovieClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("addMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();


    }

    public void onTransferMovieClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("transferMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");
        TransferMovieController company=fxmlLoader.getController();
        company.labeling(ClientController.str);
        stage.setScene(scene);
        stage.show();

    }

    public void labeling(String str) {
        company.setText(str);
    }
}
