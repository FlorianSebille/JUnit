import calculator.Calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    private static Instant startAt;

    @BeforeAll
    public static void initStartingTime(){
        startAt = Instant.now();

        System.out.println("Début des tests [" + startAt + "]");
    }

    @AfterAll
    public static void showTestsDuration(){
        Instant endeAt = Instant.now();
        System.out.println("Fin des tests [" + endeAt + "]");
        System.out.println("Durée des tests : " + Duration.between(startAt, endeAt).toMillis() + " ms");
    }

    @BeforeEach
    public void initCalculator(){
        this.calculator = new Calculator();
    }

    @AfterEach
    public void undefCalculator(){
        this.calculator = null;
    }

    @Test
    public void testAddTwoPositivesNumbers(){
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int sommeAPB = this.calculator.add(a, b);
        int sommeBPA = this.calculator.add(b, a);

        // Assert
        //assertEquals(5, sommeAPB);
        //assertEquals(5, sommeBPA);
        assertThat(sommeAPB).isEqualTo(5);
        assertThat(sommeBPA).isEqualTo(5);
    }

    @Test
    public void testMultiplyTwoPositivesNumbers(){
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int productAPB = this.calculator.multiply(a, b);
        int productBPA = this.calculator.multiply(b, a);

        // Assert
        assertThat(productAPB).isEqualTo(6);
        assertThat(productBPA).isEqualTo(6);
    }

    @ParameterizedTest(name="{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 3, 777, 1001})
    public void testMultiplyByZero(int arg){

        // Act
        int result = this.calculator.multiply(arg, 0);

        // Assert
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name="{0} + {1} doit être égal à {2}")
    @CsvSource({"1,2,3", "2,3,5", "57,43,100"})
    public void testAddTwoPisitiveNumbers(int arg1, int arg2, int result){

        // Act
        int resultCalcul = this.calculator.add(arg1, arg2);

        // Assert
        assertThat(resultCalcul).isEqualTo(result);
    }

    @Test
    @Timeout(1)
    public void testLongCalculation(){

        this.calculator.longCalculation();
    }

    @Test
    public void allDigits(){
        //GIVEN
        int number = 95897;

        //WHEN
        Set<Integer> actualDigits = this.calculator.digitsSet(number);

        //THEN
        //Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
        //assertEquals(expectedDigits, actualDigits);

        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);


    }
}
