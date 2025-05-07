import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie {
    private String name;
    private double rating;
    private int year;

    // Constructor to initialize movie details
    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    // Getter methods
    public String getN() {
        return name;
    }
    public double getR() {
        return rating;
    }
    public int getY() {
        return year;
    }
}

class Rating implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
        return Double.compare(m2.getR(),m1.getR());
    }
}

class NameCompare implements Comparator<Movie>{
    public int compare(Movie m1 , Movie m2){
        return m1.getN().compareTo(m2.getN());
    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Movie> m = new ArrayList<>();
        m.add(new Movie("Force Awakens", 8.3, 2015));
        m.add(new Movie("Star Wars", 8.7, 1977));
        m.add(new Movie("Empire Strikes Back", 8.8, 1980));

        m.sort(new Rating());
        System.out.println("Sorting based on Ratings");
        for (Movie M : m)
            System.out.println(M.getN() + " " + M.getR() + " " + M.getY());

        Collections.sort(m, new NameCompare());
        System.out.println("Sorting based on Name");
        for (Movie M : m)
            System.out.println(M.getN() + " " + M.getR() + " " + M.getY());

    }
}
