import com.fortinet.beans.Movie;
import com.fortinet.controller.MovieController;
import com.fortinet.service.MoviesService;
import com.fortinet.validator.MoviesValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MoviesValidator.class})
public class MovieValidationTest {

    @Autowired
    MoviesValidator moviesValidator;

    @MockBean
    MoviesService moviesService;

    @Test
    public void testMovieController() {
        MovieController movieController = new MovieController();
        String result = movieController.getStatus();
        assertEquals(result, "Movie API Running");
    }

    @Test
    public void testGetAllMovie() {
        Movie movie1 = new Movie();
        movie1.setCategory("action");
        movie1.setRating(3.5f);
        movie1.setName("movie name");
        movie1.setTitle("movie Title");
        Movie movie2 = new Movie();
        movie2.setCategory("action2");
        movie2.setRating(4.5f);
        movie2.setName("movie name 2");
        movie2.setTitle("movie Title 2");
        when(moviesService.getAllMovies()).thenReturn(Stream.of(movie1,movie2).collect(Collectors.toList()));
        assertEquals(2,moviesService.getAllMovies().size());
    }
    @Test
    public void testAddMovie() {
        Movie movie1 = new Movie();
        movie1.setCategory("category");
        movie1.setRating(3.5f);
        movie1.setName("movie name");
        movie1.setTitle("movie Title");
        when(moviesService.addMovie(movie1)).thenReturn(movie1);
        assertEquals(movie1,moviesValidator.addMovie(movie1));
    }

    @Test(expected = RuntimeException.class)
    public void testAddMovieWithExpectedException() {
        Movie movie1 = new Movie();
        movie1.setRating(3.5f);
        movie1.setName("movie name");
        movie1.setTitle("movie Title");
        when(moviesService.addMovie(movie1)).thenReturn(movie1);
        assertEquals(movie1,moviesValidator.addMovie(movie1));
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateMovieWithExpectedException() {
        Movie movie1 = new Movie();
        movie1.setRating(6.90f);
        movie1.setName("movie name");
        movie1.setTitle("movie Title");
        when(moviesService.updateMovie(movie1)).thenReturn(movie1);
        assertEquals(movie1,moviesValidator.updateMovie(movie1));
    }

    @Test
    public void testGetAllMovieById() {
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setCategory("action");
        movie1.setRating(3.5f);
        movie1.setName("movie name");
        movie1.setTitle("movie Title");
        when(moviesService.getMovieById(1)).thenReturn(movie1);
        assertEquals(movie1.getId(),moviesService.getMovieById(1).getId());
    }


    @Test
    public void testMovieDelete() {

        int movieId = 3;
        moviesValidator.deleteById(movieId);
        verify(moviesService,times(1)).deleteMovieById(movieId);

    }


}
