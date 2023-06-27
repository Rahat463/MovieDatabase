package ServerPackage;

import com.example.moviedatabase1.Client;
import com.example.moviedatabase1.ClientMovie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerMovie implements Serializable  {
    private String name;
     private String Genre1;
     private String Genre2;
     private String Genre3;
     private String ProductionCompany;
    private int ReleaseYear,RunningTime,Budget,Revenue;

    public ServerMovie(String name, int ReleaseYear, String Genre1, String Genre2, String Genre3, String ProductionCompany, int RunningTime, int Budget, int Revenue) {
        this.name = name;
        this.Genre1 = Genre1;
        this.Genre2 = Genre2;
        this.Genre3 = Genre3;
        this.ProductionCompany=ProductionCompany;
        this.ReleaseYear=ReleaseYear;
        this.RunningTime=RunningTime;
        this.Budget=Budget;
        this.Revenue=Revenue;
        
        
    }
    public ServerMovie(ClientMovie m) {
        name = m.getName();
        ReleaseYear = m.getReleaseYear();
        Genre1 = m.getGenre1();
        Genre2 = m.getGenre2();
        Genre3 = m.getGenre3();
        ProductionCompany = m.getProductionCompany();
        RunningTime = m.getRunningTime();
        Budget = m.getBudget();
        Revenue = m.getRevenue();
    }

     public ServerMovie(String name) {
        this.name=name;
     }



    public String getName() {
        return name;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public int getBudget() {
        return Budget;
    }

    public int getRevenue() {
        return Revenue;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    public void print() {
        System.out.println(" Movie name: "+name+" Release Year: "+ReleaseYear+" Genre1: "+Genre1+" Genre2: "+Genre2+" Genre3: "+Genre3+" Running Time: "+RunningTime+" Productrion Company: "+ProductionCompany+" Budget: "+Budget+" Revenue: "+Revenue);

    }
    public static ServerMovie searchByName(String name) {
        for (int i = 0; i <  Server.serverMovieList.size(); i++) {
            ServerMovie m = Server.serverMovieList.get(i);
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }
    public static List<ServerMovie> searchByYear(int year) {
        List<ServerMovie> r10 = new ArrayList<>();
        for (int i = 0; i <Server.serverMovieList.size(); i++) {
            ServerMovie m = Server.serverMovieList.get(i);
            if (m.getReleaseYear() == year) r10.add(m);
        }
        if (r10.size() == 0) return null;
        else return r10;

    }
    public static List<ServerMovie> searchByGenre(String g) {
        List<ServerMovie> r1 = new ArrayList<>();
        for (int i = 0; i < Server.serverMovieList.size(); i++) {
            ServerMovie m = Server.serverMovieList.get(i);

            if (m.getGenre1().equalsIgnoreCase(g)) r1.add(m);
            else if (m.getGenre2().equalsIgnoreCase(g)) r1.add(m);
            else if (m.getGenre3().equalsIgnoreCase(g)) r1.add(m);
        }

        if (r1.size() == 0) return null;
        else return r1;

    }
    public static List<ServerMovie> searchByProductionCompany(String p) {
        List<ServerMovie> r2 = new ArrayList<>();
        for (int i = 0; i < Server.serverMovieList.size(); i++) {
            ServerMovie m = Server.serverMovieList.get(i);

            if (m.getProductionCompany().equalsIgnoreCase(p)) r2.add(m);


        }

        if (r2.size() == 0) return null;
        else return r2;

    }
    public static List<ServerMovie> searchByRunningTime(int i, int k) {
        List<ServerMovie> r3 = new ArrayList<>();
        for (int j = 0; j < Server.serverMovieList.size(); j++) {
            ServerMovie m =Server.serverMovieList.get(j);
            if (m.getRunningTime() >= i && m.getRunningTime() <= k) r3.add(m);

        }
        if (r3.size() == 0) return null;
        else return r3;


    }
    public static void addMovie(ServerMovie m) throws IOException {

        Server.serverMovieList.add(m);


        FileOperation.appendFile(m.getName(), m.getReleaseYear(), m.getGenre1(), m.getGenre2(), m.getGenre3(), m.getRunningTime(), m.getProductionCompany(), m.getBudget(), m.getRevenue());
       /* System.out.println("Your movie is successfully added.");
        for(ServerMovie l: Server.serverMovieList){
            l.print();
        }*/


    }



}




