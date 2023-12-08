public class Guest {
    protected MovieDatabase movieDatabase = new MovieDatabase();

    public Guest()
    {
    }
    public Guest(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    public void displayMovies()
    {
        System.out.println("Displaying movies.");
        movieDatabase.displayMovies();

    }

    public void sortMoviesByTitleAsc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByTitleAsc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByTitleDesc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByTitleDesc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByYearAsc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByYearAsc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByYearDesc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByYearDesc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByLeadingAsc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByLeadingAsc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByLeadingDesc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByLeadingDesc();
        movieDatabase.displayMovies();
    }


    public void sortMoviesByGenreAsc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByGenreAsc();
        movieDatabase.displayMovies();
    }

    public void sortMoviesByGenreDesc() {
        System.out.println("Sorting movies titles in ascending order.");
        movieDatabase.sortMoviesByGenreDesc();
        movieDatabase.displayMovies();
    }

    public String searchMovieByTitle(String title) {
        return movieDatabase.searchMovieByTitle(title);
    }
}
