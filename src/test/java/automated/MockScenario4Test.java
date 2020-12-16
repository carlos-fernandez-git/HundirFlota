package automated;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the fourth use case scenario. 
 *  */
@RunWith(Parameterized.class)
public class MockScenario4Test {
	private Player player;
	
	MockScenario4Test() {
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
			+ "X2Orig={4}, Y2Orig={5}, X2Dest={6}, Y2Dest={7}, "
			+ "X3Orig={8}, Y3Orig={9}, X3Dest={10}, Y3Dest={11}, "
			+ "X4Orig={9}, Y4Orig={10}, X4Dest={11}, Y4Dest={12} result: {13}")
    public static ArrayList<Object> data() {
    	
    	/* Scenario 4. */
   
    	// Test Case 1.
    	ArrayList<Object> S4TC1 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 5, 3, 5, 6, true }, 
    	}));
    	
    	// Test Case 2.
    	ArrayList<Object> S4TC2 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 4, 1, 4, 4, true }, 
    	}));
    	
    	// Test Case 3.
    	ArrayList<Object> S4TC3 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 4, 0, 4, 3, true }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 0, 6, 0, 9, true },
    	}));
    	
    	
    	// Test Case 4.
    	ArrayList<Object> S4TC4 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, "\n", 0, 0, 0, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 0, "\n", 0, 0, false },
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 0, 0, "\n", 0, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 0, 0, 0, "\n", false },
    	}));
    	
    	// Test Case 5.
    	ArrayList<Object> S4TC5 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 10, 10, 0, 0, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, -1, -1, 0, 0, false },
    	}));
    	
    	// Test Case 6.
    	ArrayList<Object> S4TC6 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, 0, 0, 0, 0, false }, 
    	}));
    	
    	
    	ArrayList<Object> tcs = new ArrayList<Object>(S4TC1);
    	tcs.addAll(S4TC2);
    	tcs.addAll(S4TC3);
    	tcs.addAll(S4TC4);
    	tcs.addAll(S4TC5);
    	tcs.addAll(S4TC6);
    	
        return tcs;
    }

	// first scenario data
    private Object inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1;
    
    // second scenario data
    private Object inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2;
    
    // third scenario data
    private Object inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3;
    
    // fourth scenario data
    private Object inputOriginRow4, inputOriginCol4, inputDestinationRow4, inputDestinationCol4;
    private boolean expected;

    public MockScenario4Test(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2, 
    		Object inputOriginRow3, Object inputOriginCol3, Object inputDestinationRow3, Object inputDestinationCol3,
    		Object inputOriginRow4, Object inputOriginCol4, Object inputDestinationRow4, Object inputDestinationCol4,
    		boolean expected) {
        this.inputOriginRow1 = inputOriginRow1;
        this.inputOriginCol1 = inputOriginCol1;
        this.inputDestinationRow1 = inputDestinationRow1;
        this.inputDestinationCol1 = inputDestinationCol1;
        
        this.inputOriginRow2 = inputOriginRow2;
        this.inputOriginCol2 = inputOriginCol2;
        this.inputDestinationRow2 = inputDestinationRow2;
        this.inputDestinationCol2 = inputDestinationCol2;
        
        this.inputOriginRow3 = inputOriginRow3;
        this.inputOriginCol3 = inputOriginCol3;
        this.inputDestinationRow3 = inputDestinationRow3;
        this.inputDestinationCol3 = inputDestinationCol3;
        
        this.inputOriginRow4 = inputOriginRow4;
        this.inputOriginCol4 = inputOriginCol4;
        this.inputDestinationRow4 = inputDestinationRow4;
        this.inputDestinationCol4 = inputDestinationCol4;
        
        this.expected = expected;
    }
    
    public boolean insert(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2,
    		Object inputOriginRow3, Object inputOriginCol3, Object inputDestinationRow3, Object inputDestinationCol3,
    		Object inputOriginRow4, Object inputOriginCol4, Object inputDestinationRow4, Object inputDestinationCol4) {
    	boolean isCorrect = false;
    	
    	MockScenario3Test e3 = new MockScenario3Test();
    	// first runs all first and second scenario's tests.
    	if (e3.insert(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2,
    			inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3)) {
    		
			// executes this scenario tests.
			if (e3.insertVessel(inputOriginRow4, inputOriginCol4, inputDestinationRow4, inputDestinationCol4)) {
    			isCorrect = true;
    		}
    	}
    	
    	this.player = e3.getPlayer();
    	
    	return isCorrect;
    }

    /* This test will run 11 times, it executes every data set row of each test case. */
    @Test
    public void test() {
    	initialize(); // needed for reset player and its board
    	
    	assertEquals(expected, insert(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2,
    			inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3,
    			inputOriginRow4, inputOriginCol4, inputDestinationRow4, inputDestinationCol4));
    }
}