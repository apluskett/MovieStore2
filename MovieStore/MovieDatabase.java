import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieDatabase
{
    private final List<Movie> movieDatabaseList;
    public MovieDatabase() {
        this.movieDatabaseList = new ArrayList<>();
        // Initialize with some user credentials
        movieDatabaseList.add(new Movie("Top Gun", "Tom Cruise", 1986, "Action"));
        movieDatabaseList.add(new Movie("Top Gun: Maverick", "Tom Cruise", 2022, "Action"));
        movieDatabaseList.add(new Movie("Alien", "Sigourney Weaver", 1979, "Action"));
        movieDatabaseList.add(new Movie("Aliens", "Sigourney Weaver", 1986, "Action"));
        movieDatabaseList.add(new Movie("Godzilla Minus one", "Minami Hamabe", 2023, "Kaiju"));
    }

    public void addMovie(Movie movie) {
        movieDatabaseList.add(movie);
    }

    public void removeMovie(Movie movie){
        movieDatabaseList.remove(movie);
    }

    public void sortMoviesByTitleAsc() {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::title));
    }

    public void sortMoviesByTitleDesc() {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::title).reversed());
    }

    public void sortMoviesByYearAsc()
    {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::year));
    }

    public void sortMoviesByYearDesc(){
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::year).reversed());
    }

    public void sortMoviesByLeadingAsc()
    {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::leading));
    }

    public void sortMoviesByLeadingDesc()
    {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::leading).reversed());
    }

    public void sortMoviesByGenreAsc()
    {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::genre));
    }

    public void sortMoviesByGenreDesc()
    {
        Collections.sort(movieDatabaseList, Comparator.comparing(Movie::genre).reversed());
    }

    public void displayMovies() {
        for (Movie movie : movieDatabaseList) {
            System.out.println(movie.toString());
        }
    }

    public String searchMovieByTitle(String title) {
        for (Movie movie : movieDatabaseList) {
            if (movie.title().equalsIgnoreCase(title)) {
                return STR."Movie found: \{movie.toString()}";
            }
        }
        return "Movie not found.";
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : movieDatabaseList) {
            if (movie.title().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        System.out.println("Movie not found.");
        return null; // Movie not found
    }

}
