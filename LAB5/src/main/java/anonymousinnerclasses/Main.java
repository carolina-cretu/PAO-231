package anonymousinnerclasses;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Movie m1 = new Movie("Mamma Mia", Genre.MUSICAL, 5);
        Movie m2 = new Movie("Texas Chainsaw Massacre", Genre.HORROR, 1);
        Movie m3 = new Movie("Dune", Genre.SCIFI, 2);

        Movie[] movies = {m1, m2, m3};

        System.out.println(Arrays.toString(movies)); // array nesortat

        // implementare de comparator folosind o clasa anonima
        Comparator<Movie> movieRankComparator = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getRank().compareTo(o2.getRank());
            }
        };

        Arrays.sort(movies, movieRankComparator); // dam ca parametru variabila care tine referinta catre comparatorul anonim creat pentru sortare
        System.out.println(Arrays.toString(movies)); // array sortat

        //similar, putem sorta array ul folosind o expresie lambda in loc de clasa anonima
        //  Arrays.sort(movies, (o1, o2) -> o1.getGenre().compareTo(o2.getGenre()));
        //  System.out.println(Arrays.toString(movies));


        // implementare de clasa abstracta folosind o clasa abstracta
        Cinema cinema = new Cinema() {
            @Override
            public void watch() {
                System.out.println("Watching a movie on film !");
            }
        };
    }
}
