package ServerPackage;

import java.io.*;
import java.util.List;

public class FileOperation {

   public static void readFile(String s) throws IOException {
    BufferedReader b = new BufferedReader(new FileReader(s));
        while (true) {
        String line = b.readLine();
        if (line == null) break;
        String[] t = line.split(",");
        String name = t[0];
        String j1 = t[2];
        String j2 = t[3];
        String j3 = t[4];
        String company = t[6];
        int budget = Integer.parseInt(t[7]);
        int rev = Integer.parseInt(t[8]);
        int time = Integer.parseInt(t[5]);
        int ReleaseYear = Integer.parseInt(t[1]);
       ServerMovie m = new ServerMovie(name, ReleaseYear, j1, j2, j3, company, time, budget, rev);
     Server.serverMovieList.add(m);
    }
        b.close();}
    public static void appendFile(String name, int year, String g1, String g2, String g3, int time, String company, int budget, int rev) throws IOException{
        BufferedWriter bw = null;


        String text = name + "," + Integer.toString(year) + "," + g1 + "," + g2 + "," + g3 + "," + Integer.toString(time) + "," + company + "," + Integer.toString(budget) + "," + Integer.toString(rev);

        bw = new BufferedWriter(new FileWriter("movies.txt", true));
        bw.append(text);
        bw.append(System.lineSeparator());
        bw.flush();

        bw.close();
    }


    public static void writeFile(List<ServerMovie> serverMovieList) throws IOException {
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter("movies.txt"));
        for(int i=0;i<serverMovieList.size();i++) {
            String name=serverMovieList.get(i).getName();
            int year=serverMovieList.get(i).getReleaseYear();
            String g1=serverMovieList.get(i).getGenre1();
            String g2=serverMovieList.get(i).getGenre2();
            String g3=serverMovieList.get(i).getGenre3();
            int time=serverMovieList.get(i).getRunningTime();
            String company=serverMovieList.get(i).getProductionCompany();
            int budget=serverMovieList.get(i).getBudget();
            int rev=serverMovieList.get(i).getRevenue();

            String text = name + "," + Integer.toString(year) + "," + g1 + "," + g2 + "," + g3 + "," + Integer.toString(time) + "," + company + "," + Integer.toString(budget) + "," + Integer.toString(rev);


            bw.write(text);
            bw.write(System.lineSeparator());
           bw.flush();
        }
        bw.close();
    }
}
