import java.util.ArrayList;
import java.util.Collections;

class Movie1 implements Comparable<Movie1> {
    private String name;
    private double rating;
    private int year;

    // Constructor
    public Movie1(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public int compareTo(Movie1 m){
        return this.year - m.year;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}
public class ComparableExample {
    public static void main(String[] args) {
        ArrayList<Movie1> l = new ArrayList<>();
        l.add(new Movie1("Star Wars", 8.7, 1977));
        l.add(new Movie1("Empire Strikes Back", 8.8, 1980));
        l.add(new Movie1("Return of the Jedi", 8.4, 1983));

        Collections.sort(l);
        for (Movie1 M : l)
            System.out.println(M.getName() + " " + M.getRating() + " " + M.getYear());

    }
}
