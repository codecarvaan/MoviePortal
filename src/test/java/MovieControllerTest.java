import com.fortinet.beans.Movie;
import com.fortinet.controller.MovieController;
import com.fortinet.validator.MoviesValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieControllerTest {
    @Test
    public void testMovieController() {
        MovieController movieController = new MovieController();
        String result = movieController.getStatus();
        assertEquals(result, "Movie API Running");
    }

    @Test
    public void testMovieAdd() {
        MovieController movieController = new MovieController();
        Movie movie = new Movie();
        Movie afterAdd = null;
        String ex = "";
        try {
            afterAdd = movieController.addMovie(movie);
        } catch (Exception e) {
            ex = "Exception Accoured";
        }
        assertEquals(ex, "Exception Accoured");
    }

    @Test
    public void testMovieUpdate() {
        MoviesValidator movieController = new MoviesValidator();
        Movie movie = new Movie();
        movie.setCategory("action");
        movie.setRating(3.5f);
        movie.setName("movie name");
        movie.setTitle("movie Title");
        movie.setId(2);
        Movie afterAdd = movieController.validUpdateMovie(movie);
        assertEquals(movie.getId(),afterAdd.getId());
    }
}
