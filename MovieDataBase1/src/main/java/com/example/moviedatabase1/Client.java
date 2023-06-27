package com.example.moviedatabase1;
import ServerPackage.ServerMovie;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    public static List<ClientMovie> movieList = new ArrayList<>();
    public static SocketWrapper server=null;

    public static void createClient(String name) throws IOException, ClassNotFoundException {


        String cName = name;


        new Thread(()->{
         try {
                server.write(cName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    while(true){
            try {
                List<ServerMovie> data = (List<ServerMovie>) server.read();
                movieList=new ArrayList<>();
                for (ServerMovie m : data) {
                    movieList.add(new ClientMovie(m));
                }
                if(ClientClass.controller!=null) ClientClass.controller.onRefreshClick(null);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }}


        }).start();


    }
}
