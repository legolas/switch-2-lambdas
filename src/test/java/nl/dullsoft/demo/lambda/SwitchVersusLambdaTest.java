package nl.dullsoft.demo.lambda;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * The unit test shows the results are equals despite the difference in implementation.
 */
public class SwitchVersusLambdaTest {

    private SwitchVersusLambda testObject = new SwitchVersusLambda();

    @Test
    public void testFindAtbs() {
        List<String> usingLambdas = testObject.findUsingLambdas(Bicycle.ATB);
        List<String> usingSwitch = testObject.findUsingSwitch(Bicycle.ATB);
        assertEquals(usingLambdas, usingSwitch);
    }

    @Test
    public void testFindCityBikes() {
        List<String> usingLambdas = testObject.findUsingLambdas(Bicycle.CITY);
        List<String> usingSwitch = testObject.findUsingSwitch(Bicycle.CITY);
        assertEquals(usingLambdas, usingSwitch);
    }

    @Test
    public void testFindRacers() {
        List<String> usingLambdas = testObject.findUsingLambdas(Bicycle.RACE);
        List<String> usingSwitch = testObject.findUsingSwitch(Bicycle.RACE);
        assertEquals(usingLambdas, usingSwitch);
    }

    @Test
    public void testFindHPVs() {
        List<String> usingLambdas = testObject.findUsingLambdas(Bicycle.HPV);
        List<String> usingSwitch = testObject.findUsingSwitch(Bicycle.HPV);
        assertEquals(usingLambdas, usingSwitch);
    }
}