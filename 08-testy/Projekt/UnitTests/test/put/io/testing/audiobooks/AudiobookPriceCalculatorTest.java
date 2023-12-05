package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    AudiobookPriceCalculator audiobookPriceCalculator;
    Customer gold, silver, sub, standard;
    Audiobook audiobook;
    @BeforeEach
    void setup(){
        audiobookPriceCalculator = new AudiobookPriceCalculator();
        gold = new Customer("a", Customer.LoyaltyLevel.GOLD,false);
        silver = new Customer("b", Customer.LoyaltyLevel.SILVER,false);
        sub = new Customer("c", Customer.LoyaltyLevel.STANDARD,true);
        standard = new Customer("d", Customer.LoyaltyLevel.STANDARD,false);
        audiobook = new Audiobook("qwe",100);
    }
    @Test
    void calculateGold() {
        assertEquals(audiobookPriceCalculator.calculate(gold,audiobook), 80);
    }

    @Test
    void calculateStandard(){
        assertEquals(audiobookPriceCalculator.calculate(standard,audiobook), 100);
    }

    @Test
    void calculateSilver(){
        assertEquals(audiobookPriceCalculator.calculate(silver,audiobook), 90);
    }

    @Test
    void calculateSub(){
        assertEquals(audiobookPriceCalculator.calculate(sub,audiobook), 0);
    }
}