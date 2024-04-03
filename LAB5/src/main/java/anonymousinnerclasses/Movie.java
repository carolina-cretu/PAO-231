package anonymousinnerclasses;

/**
 * @author Carolina Cretu
 */
public class Movie {

    private String name;

    private Genre genre;

    private Integer rank;

    private static String [] watched100Movies = new String[100];

    public Movie(String name, Genre genre, Integer rank) {
        this.name = name;
        this.genre = genre;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public static void addToWatched (String watchedMovie) {
      for (int i = 0; i < watched100Movies.length; i++) {
          if (watched100Movies[i] == null) {
              watched100Movies[i] = watchedMovie;
              break;
          }
      }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", rank=" + rank +
                '}';
    }
}
