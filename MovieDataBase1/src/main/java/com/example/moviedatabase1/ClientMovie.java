package com.example.moviedatabase1;

import ServerPackage.ServerMovie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientMovie implements Serializable  {//Name,ReleaseYear,Genre1,Genre2,Genre3,RunningTime,ProductionCompany,Budget,Revenue
    private String name;
     private String Genre1;
     private String Genre2;
     private String Genre3;
     private String ProductionCompany;
    private int ReleaseYear,RunningTime,Budget,Revenue;

    public ClientMovie(String name, int ReleaseYear, String Genre1, String Genre2, String Genre3, String ProductionCompany, int RunningTime, int Budget, int Revenue) {
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

     public ClientMovie(String name) {
        this.name=name;
     }

     public ClientMovie(ServerMovie m) {
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



    public void print() {
        System.out.println(" Movie name: "+name+" Release Year: "+ReleaseYear+" Genre1: "+Genre1+" Genre2: "+Genre2+" Genre3: "+Genre3+" Running Time: "+RunningTime+" Productrion Company: "+ProductionCompany+" Budget: "+Budget+" Revenue: "+Revenue);

    }
    public static ClientMovie searchByName(String name) {

        for (int i = 0; i <  Client.movieList.size(); i++) {
            ClientMovie m =Client.movieList.get(i);
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }
    public static List<ClientMovie> searchByYear(int year) {
        List<ClientMovie> r10 = new ArrayList<>();

        for (int i = 0; i <Client.movieList.size(); i++) {
            ClientMovie m = Client.movieList.get(i);
            if (m.getReleaseYear() == year) r10.add(m);
        }
        if (r10.size() == 0) return null;
        else return r10;

    }
    public static List<ClientMovie> searchByGenre(String g) {

        List<ClientMovie> r1 = new ArrayList<>();
        for (int i = 0; i < Client.movieList.size(); i++) {
            ClientMovie m = Client.movieList.get(i);

            if (m.getGenre1().equalsIgnoreCase(g)) r1.add(m);
            else if (m.getGenre2().equalsIgnoreCase(g)) r1.add(m);
            else if (m.getGenre3().equalsIgnoreCase(g)) r1.add(m);
        }

        if (r1.size() == 0) return null;
        else return r1;

    }
    public static List<ClientMovie> searchByProductionCompany(String p) {
        List<ClientMovie> r2 = new ArrayList<>();

        for (int i = 0; i < Client.movieList.size(); i++) {
            ClientMovie m = Client.movieList.get(i);

            if (m.getProductionCompany().equalsIgnoreCase(p)) r2.add(m);


        }

        if (r2.size() == 0) return null;
        else return r2;

    }
    public static List<ClientMovie> searchByRunningTime(int i, int k) {
        List<ClientMovie> r3 = new ArrayList<>();

        for (int j = 0; j < Client.movieList.size(); j++) {
            ClientMovie m =Client.movieList.get(j);
            if (m.getRunningTime() >= i && m.getRunningTime() <= k) r3.add(m);

        }
        if (r3.size() == 0) return null;
        else return r3;


    }



}




