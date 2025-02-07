package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.*;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Collection<String> result = new Addition(new Value(1), new Value(6)).getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Collection<String> result = new Division(new Value(12), new Variable("div")).getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Collection<String> result = new Multiplication(new Division(new Value(9), new Variable("x")), new Variable("y")).getVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Collection<String> result = new Power(new Division(new Value(27), new Variable("a")), new Variable("b")).getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Collection<String> result = new Power(new Variable("z"), new Division(new Value(1), new Value(2))).getVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Collection<String> result = new Subtraction(new Absolute(new Variable("value")), new Value(8)).getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final Collection<String> result = new Sqrt(new Variable("value")).getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Collection<String> result = new Multiplication(new Subtraction(new Value(5), new Variable("i")), new Value(8)).getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
