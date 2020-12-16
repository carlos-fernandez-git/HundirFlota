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
public class MockScenario2Test {
	private Player player;
	
	MockScenario2Test() {
		player = new Player();
		player.setNombre("Player 1");
	}
	
	/* for getting board state */
	public Player getPlayer() {
		return player;
	}
			
	/* used only for testing */
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

	// first scenario data
    private Object inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1;
    
    // second scenario data
    private Object inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2;
    private boolean expected;

    public MockScenario2Test(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
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
    
    /* Executes each data set of the first scenario and returns true only if all steps are correct. */
    public boolean insertAirCraft(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2) {
    	boolean isCorrect = false;
    	
    	MockScenario1Test e1 = new MockScenario1Test();
    	// tries to insert first 5 cells ship
    	if (e1.insertAirCraft(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1)) {
    		// tries to insert second 5 cells ship
        	if (e1.insertAirCraft(inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2)) {
        		isCorrect = true;
        	}
    	}
    	
    	this.player = e1.getPlayer();
    		
		return isCorrect;
	}

    /* This test will run 8 times, it executes every data set row of each test case. */
    @Test
    public void test() {
    	initialize(); // needed for reset player and its board
    	
    	assertEquals(expected, insertAirCraft(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2));
    }
}