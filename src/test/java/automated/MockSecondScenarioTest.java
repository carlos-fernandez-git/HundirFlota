package automated;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the second use case scenario. 
 *  */
@RunWith(Parameterized.class)
public class MockSecondScenarioTest {
	private Player player;
			
	public void initialize() {
		player = new Player();
    	player.setNombre("Player 1");
	}
	
	@Parameterized.Parameters(name = "{index}: Test with X1Orig={0}, Y1Orig={1}, X1Dest={2}, Y1Dest={3}, "
			+ "X2Orig={4}, Y2Orig={5}, X2Dest={6}, Y2Dest={7} result: {8}")
    public static ArrayList<Object> data() {
    	
    	/* Scenario 2. */
   
    	// Test Case 1.
    	ArrayList<Object> S2TC1 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, true }, 
    	}));
    	
    	// Test Case 2.
    	ArrayList<Object> S2TC2 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, "a", 0, 0, 0, false }, 
    	}));
    	
    	// Test Case 3.
    	ArrayList<Object> S2TC3 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, -1, 0, 0, 0, false }, 
			{ 0, 0, 4, 0, 10, 0, 0, 0, false }, 
			{ 0, 0, 4, 0, -2, 0, 0, 0, false }, 
			{ 0, 0, 4, 0, 11, 0, 0, 0, false }, 
    	}));
    	
    	
    	// Test Case 4.
    	ArrayList<Object> S2TC4 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 0, 0, 0, 0, false }, 
			{ 0, 0, 4, 0, 0, 7, 0, 4, false }, 
    	}));
    	
    	ArrayList<Object> tcs = new ArrayList<Object>(S2TC1);
    	tcs.addAll(S2TC2);
    	tcs.addAll(S2TC3);
    	tcs.addAll(S2TC4);
    	
        return tcs;
    }

    private Object inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1;
    private Object inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2;
    boolean expected;

    public MockSecondScenarioTest(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2, boolean expected) {
        this.inputOriginRow1 = inputOriginRow1;
        this.inputOriginCol1 = inputOriginCol1;
        this.inputDestinationRow1 = inputDestinationRow1;
        this.inputDestinationCol1 = inputDestinationCol1;
        
        this.inputOriginRow2 = inputOriginRow2;
        this.inputOriginCol2 = inputOriginCol2;
        this.inputDestinationRow2 = inputDestinationRow2;
        this.inputDestinationCol2 = inputDestinationCol2;
        
        this.expected = expected;
    }
    
    /* Executes each data set of each test case. */
    private boolean insertAirCraft(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2) {
    	
    	boolean isCorrect = false;
		
		try {
    		if(player.getTablero().insertBoatfirstpos((int) inputOriginRow1, (int) inputOriginCol1, 5)) {
    			if(player.getTablero().insertBoatLastPosition((int) inputOriginRow1, (int) inputOriginCol1, 
    					(int) inputDestinationRow1, (int) inputDestinationCol1, 5)) {
            		if(player.getTablero().insertBoatfirstpos((int) inputOriginRow2, (int) inputOriginCol2, 5)) {
            			if(player.getTablero().insertBoatLastPosition((int) inputOriginRow2, (int) inputOriginCol2, 
            					(int) inputDestinationRow2, (int) inputDestinationCol2, 5)) {
            				isCorrect = true;
            			}
            		}
    			}
    		}
		}
		catch(ClassCastException ex) {
			 //ex.printStackTrace(); // uncomment line for debug purposes
		}
    		
		return isCorrect;
	}

    /* This test will run 8 times, it executes every data set row. */
    @Test
    public void test() {
    	initialize(); // needed for creating new player and board
    	
    	assertEquals(expected, insertAirCraft(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2));
    }
}