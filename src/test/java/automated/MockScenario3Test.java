package automated;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the third use case scenario. 
 *  */
@RunWith(Parameterized.class)
public class MockScenario3Test {
	private Player player;
	
	MockScenario3Test() {
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
			+ "X3Orig={8}, Y3Orig={9}, X3Dest={10}, Y3Dest={11} result: {12}")
    public static ArrayList<Object> data() {
    	
    	/* Scenario 3. */
   
    	// Test Case 1.
    	ArrayList<Object> S3TC1 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 3, 2, 3, 5, true }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 1, 2, 1, 5, true },
    	}));
    	
    	// Test Case 2.
    	ArrayList<Object> S3TC2 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 1, 6, 1, true }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 6, 6, 6, true },
    	}));
    	
    	// Test Case 3.
    	ArrayList<Object> S3TC3 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 0, 9, 3, true }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 7, 0, 7, 3, true },
    	}));
    	
    	// Test Case 4.
    	ArrayList<Object> S3TC4 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 0, 6, 0, true }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 9, 6, 9, true },
    	}));
    	
    	// Test Case 5.
    	ArrayList<Object> S3TC5 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, "\n", 0, 0, 0, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 0, "\n", 0, 0, false },
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 0, 0, "\n", 0, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 0, 0, 0, "\n", false },
    	}));
    	
    	// Test Case 6.
    	ArrayList<Object> S3TC6 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 9, 10, 10, 10, false }, 
    		{ 0, 0, 0, 4, 2, 0, 2, 4, -1, 9, -1, 9, false },
    		{ 0, 0, 0, 4, 2, 0, 2, 4, 0, 10, 5, 5, false },
    	}));
    	
    	ArrayList<Object> tcs = new ArrayList<Object>(S3TC1);
    	tcs.addAll(S3TC2);
    	tcs.addAll(S3TC3);
    	tcs.addAll(S3TC4);
    	tcs.addAll(S3TC5);
    	tcs.addAll(S3TC6);
    	
        return tcs;
    }

	// first scenario data
    private Object inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1;
    
    // second scenario data
    private Object inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2;
    
    // third scenario data
    private Object inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3;
    private boolean expected;

    public MockScenario3Test(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2, 
    		Object inputOriginRow3, Object inputOriginCol3, Object inputDestinationRow3, Object inputDestinationCol3,
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
        
        this.expected = expected;
    }
    
    public boolean insert(Object inputOriginRow1, Object inputOriginCol1, Object inputDestinationRow1, Object inputDestinationCol1, 
    		Object inputOriginRow2, Object inputOriginCol2, Object inputDestinationRow2, Object inputDestinationCol2,
    		Object inputOriginRow3, Object inputOriginCol3, Object inputDestinationRow3, Object inputDestinationCol3) {
    	boolean isCorrect = false;
    	
    	MockScenario2Test e2 = new MockScenario2Test();
    	// first runs the third scenario
    	if (e2.insertAirCraft(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2)) {
    		this.player = e2.getPlayer();
    		// then, only if previous scenario tests are OK, executes this scenario test
    		if (this.insertVessel(inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3)) {
    			isCorrect = true;
    		}
    	}
    	
    	return isCorrect;
    }
    
    public boolean insertVessel(Object inputOriginRow3, Object inputOriginCol3, Object inputDestinationRow3, Object inputDestinationCol3) {
    	boolean isCorrect = false;
		
    	try {
    		int originRow = (int) inputOriginRow3;
    		int originCol = (int) inputOriginCol3;
    		if (player.getTablero().insertBoatfirstpos(originRow, originCol, 4)) {
    			int destinationRow = (int) inputDestinationRow3;
    			int destinationCol = (int) inputDestinationCol3;
    			if(player.getTablero().insertBoatLastPosition(originRow, originCol, destinationRow, destinationCol, 4)) {
    				isCorrect = true;
    			}
    		}
		} catch (ClassCastException ex) {
			 //ex.printStackTrace(); // uncomment this line for debug purposes
		} catch (InputMismatchException ex) {
			 //ex.printStackTrace(); // uncomment this line for debug purposes
		}
		
		return isCorrect;
    }

    /* This test will run 15 times, it executes every data set row of each test case. */
    @Test
    public void test() {
    	initialize(); // needed for reset player and its board
    	
    	assertEquals(expected, insert(inputOriginRow1, inputOriginCol1, inputDestinationRow1, inputDestinationCol1, 
    			inputOriginRow2, inputOriginCol2, inputDestinationRow2, inputDestinationCol2,
    			inputOriginRow3, inputOriginCol3, inputDestinationRow3, inputDestinationCol3));
    }
}