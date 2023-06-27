package com.example.moviedatabase1;

import ServerPackage.Server;
import ServerPackage.ServerMovie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.Serializable;

public class AddMovieController implements Serializable {

    @FXML
    TextField movieName;
    @FXML
    TextField year;
    @FXML
    TextField g1;
    @FXML
    TextField g2;
    @FXML
    TextField g3;
    @FXML
    TextField time;
    @FXML
    TextField budget;
    @FXML
    TextField revenue;



    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("productionCompanySearchingMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon = new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");
        stage.setScene(scene);
        stage.show();
    }


    public void onVerifyClick(ActionEvent actionEvent) {
        String s = movieName.getText();
        int count = 0;
        for (int i = 0; i < Client.movieList.size(); i++) {
            ClientMovie m = Client.movieList.get(i);
            if (s.equalsIgnoreCase(m.getName())) count++;
        }
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "Oh! This Movie already exists...Add New Movie.");
            //System.out.println("oh! This movie already exists.Please addd new movie");
        }
        else if(count==0){
            JOptionPane.showMessageDialog(null, "This Movie is Eligible for adding! Please provide other information.");

        }
    }

    public void onSubmitClick(ActionEvent actionEvent) throws IOException, ClassNotFoundException {


        ClientMovie m = new ClientMovie(movieName.getText(), Integer.parseInt(year.getText()), g1.getText(), g2.getText(), g3.getText(), ClientController.str, Integer.parseInt(time.getText()), Integer.parseInt(budget.getText()), Integer.parseInt(revenue.getText()));
       Client.movieList.add(m);

        Client.server.write(m);

        JOptionPane.showMessageDialog(null,"Congratulations! Movie successfully added.");

    }


}