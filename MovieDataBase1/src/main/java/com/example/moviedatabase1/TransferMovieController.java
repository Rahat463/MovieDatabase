package com.example.moviedatabase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public class TransferMovieController implements Serializable {
 @FXML
    public  Label companyLabel;
    @FXML
    public TextField newMovieName;
    @FXML
    public TextField newProduction;
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
        ClientClass.controller=this;
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("ReleaseYear"));
        g1Col.setCellValueFactory(new PropertyValueFactory<>("Genre1"));
        g2Col.setCellValueFactory(new PropertyValueFactory<>("Genre2"));
        g3Col.setCellValueFactory(new PropertyValueFactory<>("Genre3"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("RunningTime"));
        companyCol.setCellValueFactory(new PropertyValueFactory<>("ProductionCompany"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        {
            for (ClientMovie m : Client.movieList) {
                table.getItems().add(m);
            }
        }

    }

  public void labeling(String str){
        companyLabel.setText(str);
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

    public void onTransferClick(ActionEvent actionEvent) throws IOException, ClassNotFoundException, InterruptedException {

     String s1=newMovieName.getText();
       String s2=newProduction.getText();

        String s=s1+","+s2;
        System.out.println("in transfer movie.."+s);

        Client.server.write(s);

        JOptionPane.showMessageDialog(null,"Congratulations! Movie successfully transferred from "+ClientController.str+" to "+s2);

        Thread.sleep(1000);
         table.getItems().clear();
        for (ClientMovie m : Client.movieList) {
            table.getItems().add(m);
        }


    }

    public void onRefreshClick(ActionEvent actionEvent) {
        table.getItems().clear();
        for (ClientMovie m : Client.movieList) {
            table.getItems().add(m);
        }
    }
}
