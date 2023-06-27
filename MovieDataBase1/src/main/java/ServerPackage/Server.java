package ServerPackage;

import com.example.moviedatabase1.Client;
import com.example.moviedatabase1.ClientMovie;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server implements Serializable {
    public static List<ServerMovie> serverMovieList = new ArrayList<ServerMovie>();

    public static HashMap<String, SocketWrapper> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        FileOperation.readFile("movies.txt");
        ServerSocket server = new ServerSocket(3333);
        System.out.println("Server started!");
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client just connected!");
            SocketWrapper client = new SocketWrapper(clientSocket);

            new Thread(() -> {
                String clientName = new String();
                Object data = null;
            while(true) {
                try {
                    data = client.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (data instanceof String) {
                    String s = (String) data;
                    System.out.println(s);


                    String[] parts = s.split(",");
                    System.out.println(s);
                    if (parts.length == 1) {
                        clientName = (String) data;
                        clientMap.put(clientName.toUpperCase(), client);
                        System.out.println(clientName);
                        List<ServerMovie> clientMovieList = new ArrayList<>();
                        try {

                            clientMovieList = ServerMovie.searchByProductionCompany(clientName);

                            clientMap.get(clientName.toUpperCase()).write(clientMovieList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (parts.length == 2) {

                        int i;
                        String movieName = parts[0];
                        String newProductionCompany = parts[1];
                        for (i = 0; i < serverMovieList.size(); i++) {
                            if (movieName.equalsIgnoreCase(serverMovieList.get(i).getName())) {
                                serverMovieList.get(i).setProductionCompany(newProductionCompany);
                                break;
                            }
                        }
                        try {

                            FileOperation.writeFile(serverMovieList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                        List<ServerMovie> clientMovieList1 = new ArrayList<>();
                        for (i = 0; i < serverMovieList.size(); i++) {
                            if (clientName.equalsIgnoreCase(serverMovieList.get(i).getProductionCompany())) {
                                clientMovieList1.add(serverMovieList.get(i));

                            }


                        }
                        List<ServerMovie> clientMovieList2 = new ArrayList<>();
                        for (i = 0; i < serverMovieList.size(); i++) {
                            if (newProductionCompany.equalsIgnoreCase(serverMovieList.get(i).getProductionCompany())) {
                                clientMovieList2.add(serverMovieList.get(i));

                            }


                        }


                        try {
                            clientMap.get(clientName.toUpperCase()).write(clientMovieList1);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            clientMap.get(newProductionCompany.toUpperCase()).write(clientMovieList2);


                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else if (data instanceof ClientMovie) {
                    try {

                            ClientMovie m1 = (ClientMovie) data;
                            ServerMovie m2 = new ServerMovie(m1);
                            ServerMovie.addMovie(m2);


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
            }).start();

        }
    }

}
