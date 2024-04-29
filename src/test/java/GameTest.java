import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void createGame(){
        assertNotNull(game);
    }

    @Test
    void throwExceptionWhenInputIsNull(){
        assertThrows(IllegalAccessException.class,()->{
            game.guess(null);
        });
    }
}

