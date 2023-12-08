public class Manager extends Guest {

    public Manager(){}

    public Manager(MovieDatabase movieDatabase){super(movieDatabase);}

    public void addMovie(String title, String leading, int year, String genre)
    {
        Movie movie = new Movie(title, leading, year, genre);
        movieDatabase.addMovie(movie);
        System.out.println(STR."\{movie.toString()}Was added succesfully!");
    }

    public void deleteMovie(String title)
    {
        Movie movie = movieDatabase.findMovieByTitle(title);
        if (movie != null) {
            movieDatabase.removeMovie(movie);
            System.out.println("Movie deleted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

}
