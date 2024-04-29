import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void throwExceptionWhenInputInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12S");
        assertIllegalArgument("121");
    }

    private void generateQuestion(String questionNumber) {
        game.question=questionNumber;
    }

    @Test
    void returnSolvedResultIfMatchedNumber(){
        generateQuestion("123");

        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }


    @Test
    void returnSolvedResultIfUnMatchedNumber(){
        generateQuestion("123");

        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    @Test
    public void returnUnSolvedIfSomeMatchedNumber(){
        generateQuestion("123");
        assertMatchedNumber(game.guess("129"),false,2,0);
    }

    @Test
    public void returnUnSolvedResultIfSomeMatchedNumber(){
        generateQuestion("123");
        assertMatchedNumber(game.guess("120"),false,2,0);
        assertMatchedNumber(game.guess("061"),false,0,1);
        assertMatchedNumber(game.guess("136"),false,1,1);
    }

}

