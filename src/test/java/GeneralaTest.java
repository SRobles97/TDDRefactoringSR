
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.generala.Generala;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcelo
 */
public class GeneralaTest {
    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Generala.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Generala.chance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Generala.generala(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Generala.generala(6,6,6,6,6));
        assertEquals(0, Generala.generala(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertTrue(Generala.ones(1,2,3,4,5) == 1);
        assertEquals(2, Generala.ones(1,2,1,4,5));
        assertEquals(0, Generala.ones(6,2,2,4,5));
        assertEquals(4, Generala.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Generala.twos(1,2,3,2,6));
        assertEquals(10, Generala.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Generala.threes(1,2,3,2,3));
        assertEquals(12, Generala.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, new Generala(4,4,4,5,5).fours());
        assertEquals(8, new Generala(4,4,5,5,5).fours());
        assertEquals(4, new Generala(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Generala(4,4,4,5,5).fives());
        assertEquals(15, new Generala(4,4,5,5,5).fives());
        assertEquals(20, new Generala(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Generala(4,4,4,5,5).sixes());
        assertEquals(6, new Generala(4,4,6,5,5).sixes());
        assertEquals(18, new Generala(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, Generala.score_pair(3,4,3,5,6));
        assertEquals(10, Generala.score_pair(5,3,3,3,5));
        assertEquals(12, Generala.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Generala.two_pair(3,3,5,4,5));
        assertEquals(16, Generala.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Generala.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Generala.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Generala.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Generala.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Generala.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Generala.four_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Generala.smallStraight(1,2,3,4,5));
        assertEquals(15, Generala.smallStraight(2,3,4,5,1));
        assertEquals(0, Generala.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Generala.largeStraight(6,2,3,4,5));
        assertEquals(20, Generala.largeStraight(2,3,4,5,6));
        assertEquals(0, Generala.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Generala.fullHouse(6,2,2,2,6));
        assertEquals(0, Generala.fullHouse(2,3,4,5,6));
    }
}
