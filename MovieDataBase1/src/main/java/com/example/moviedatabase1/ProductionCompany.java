package com.example.moviedatabase1;

import java.util.*;

public class ProductionCompany {

    public static Comparator<ClientMovie> comp = new Comparator<>() {
        // override the compare() method
        public int compare(ClientMovie m1, ClientMovie m2) {
            int dif1 = m1.getRevenue() - m1.getBudget();
            int dif2 = m2.getRevenue() - m2.getBudget();
            if (dif1 == dif2) {
                return 0;
            } else if (dif1 < dif2) {
                return 1;
            } else {
                return -1;
            }
        }
    };
    public static  Comparator<ClientMovie> latestComp = new Comparator<>(){
        public int compare(ClientMovie m1, ClientMovie m2) {
            if (m1.getReleaseYear() == m2.getReleaseYear()) {
                return 0;
            } else if (m1.getReleaseYear() < m2.getReleaseYear()) {
                return 1;
            } else {
                return -1;
            }
        }


    };
    public static  Comparator<ClientMovie> maxRevenue = new Comparator<>(){
        public int compare(ClientMovie m1, ClientMovie m2) {
            if (m1.getRevenue() == m2.getRevenue()) {
                return 0;
            } else if (m1.getRevenue() < m2.getRevenue()) {
                return 1;
            } else {
                return -1;
            }
        }
    };
    public static List<ClientMovie> mostRecentMovies(String s7){
        List<ClientMovie> r = ClientMovie.searchByProductionCompany(s7);
        List<ClientMovie>recentMovie=new ArrayList<ClientMovie>();
        if (r != null) {
            Collections.sort(r, latestComp);
            ClientMovie w = r.get(0);

            for (int i = 0; i < r.size(); i++) {
                ClientMovie m = r.get(i);
                if (m.getReleaseYear() == w.getReleaseYear()) recentMovie.add(m);


            }
            return recentMovie;
        }
       else {
        return null;}

    }

    public static  List<ClientMovie>   moviesWithMaximumRevenue(String s10){
    List<ClientMovie> r = ClientMovie.searchByProductionCompany(s10);
        List<ClientMovie> maxRevenueMovie=new ArrayList<ClientMovie>();
                    if (r != null) {
        Collections.sort(r, maxRevenue);
        ClientMovie w = r.get(0);
        for (int i = 0; i < r.size(); i++) {
            ClientMovie m = r.get(i);
            if (m.getRevenue() == w.getRevenue()) maxRevenueMovie.add(m) ;
        }
        return maxRevenueMovie;
    } else {return  null;}

}
public static long totalProfit(String s12){
    List<ClientMovie> r = ClientMovie.searchByProductionCompany(s12);
    long sum = 0;
    if (r != null) {
        for (int n = 0; n < r.size(); n++) {
            ClientMovie m = r.get(n);
            sum += m.getRevenue() - m.getBudget();

        }
       return sum ;
    } else return 0;


}
public static HashMap<String,Integer> countOfMovies(){
    HashMap<String, Integer> map = new HashMap<>();
    Client k=new Client();

    for (ClientMovie m : k.movieList) {
        if (map.containsKey(m.getProductionCompany())) {

            // Mapping
            Integer a = map.get(m.getProductionCompany());
            a++;
            map.put(m.getProductionCompany(), a);
        } else {
            map.put(m.getProductionCompany(), 1);

        }
    }

   return map;
}
}

