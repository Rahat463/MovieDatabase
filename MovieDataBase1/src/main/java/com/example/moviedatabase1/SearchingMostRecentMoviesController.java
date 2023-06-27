package com.example.moviedatabase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchingMostRecentMoviesController {

    @FXML
    TableView<ClientMovie> table;
    @FXML
    TableColumn<ClientMovie,String> nameCol;
    @FXML
    TableColumn<ClientMovie,Integer> yearCol;
    @FXML
    TableColumn<ClientMovie,String> g1Col;
    @FXML
    TableColumn <ClientMovie,String>g2Col;
    @FXML
    TableColumn<ClientMovie,String> g3Col;
    @FXML
    TableColumn<ClientMovie,Integer> timeCol;
    @FXML
    TableColumn<ClientMovie,String> companyCol;
    @FXML
    TableColumn<ClientMovie,Integer> budgetCol;
    @FXML
    TableColumn<ClientMovie,Integer> revenueCol;
    @FXML
    void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("ReleaseYear"));
        g1Col.setCellValueFactory(new PropertyValueFactory<>("Genre1"));
        g2Col.setCellValueFactory(new PropertyValueFactory<>("Genre2"));
        g3Col.setCellValueFactory(new PropertyValueFactory<>("Genre3"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("RunningTime"));
        companyCol.setCellValueFactory(new PropertyValueFactory<>("ProductionCompany"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));

    }


    public void onSearchClick(ActionEvent actionEvent) throws IOException {

        List<ClientMovie> r =new ArrayList<>();

      r=ProductionCompany.mostRecentMovies(ClientController.str);
        for(ClientMovie m:r ){
            table.getItems().add(m);}
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
