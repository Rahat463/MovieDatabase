package com.example.moviedatabase1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientClass extends Application implements Serializable {

 //static List<ClientMovie> movieList = new ArrayList<ClientMovie>();
 static TransferMovieController controller=null;
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientClass.class.getResource("clientController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        Image icon=new Image("movie_icon2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Movie Database ");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {



        String serverAddress = "127.0.0.1";
        int serverPort = 3333;
        Client.server = new SocketWrapper(serverAddress, serverPort);



        //List<Movie> movieList = new ArrayList<Movie>();
//        FileOperation.readFile("movies.txt");

        launch();

    }
}