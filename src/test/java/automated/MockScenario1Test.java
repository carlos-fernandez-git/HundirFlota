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
 *  This class performs a Data-driven test of all test cases of the first use case scenario. 
 *  */
@RunWith(Parameterized.class)
public class MockScenario1Test {
	private Player player;
	
	MockScenario1Test() {
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
	
	@Parameterized.Parameters(name = "{index}: Test with XOrig={0}, YOrig={1}, XDest={2}, YDest={3}, result: {4}")
    public static ArrayList<Object> data() {
    	ArrayList<Object> tcs = new ArrayList<Object>();
    	
    	/* Scenario 1. */
    	
    	// Test Case 1.
    	ArrayList<Object> S1TC1 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, 4, true }, 
			{ 9, 0, 9, 4, true }, 
			{ 0, 0, 4, 0, true }, 
			{ 0, 9, 4, 9, true }, 
    	}));
    	tcs.addAll(S1TC1);
    	
    	// Test Case 2.
    	ArrayList<Object> S1TC2 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ "a", "a", "a", "a", false }, 
			{ "0", "z", "z", "z", false }, 
			{ "0", "0", "?", "?", false }, 
			{ "0", "0", "0", "?", false }, 
    	}));
    	tcs.addAll(S1TC2);
    	
    	// Test Case 3.
    	ArrayList<Object> S1TC3 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ -1, 0, 0, 0, false }, 
			{ 10, 0, 0, 0, false }, 
			{ -2, 0, 0, 0, false }, 
			{ 11, 0, 0, 0, false }, 
    	}));
    	tcs.addAll(S1TC3);
    	
    	// Test Case 4.
    	ArrayList<Object> S1TC4 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, -1, 0, 0, false }, 
			{ 0, 10, 0, 0, false }, 
			{ 0, -2, 0, 0, false }, 
			{ 0, 11, 0, 0, false }, 
    	}));
    	tcs.addAll(S1TC4);
    	
    	// Test Case 5.
    	ArrayList<Object> S1TC5 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, -1, 0, false }, 
			{ 0, 0, 10, 0, false }, 
			{ 0, 0, -2, 0, false }, 
			{ 0, 0, 11, 0, false }, 
    	}));
    	tcs.addAll(S1TC5);
    	
    	// Test Case 6.
    	ArrayList<Object> S1TC6 = new ArrayList<Object>(Arrays.asList(new Object[][] {
    		{ 0, 0, 0, -1, false }, 
			{ 0, 0, 0, 10, false }, 
			{ 0, 0, 0, -2, false }, 
			{ 0, 0, 0, 11, false }, 
    	}));
    	tcs.addAll(S1TC6);
    	
        return tcs;
    }

	// first scenario data
    private Object inputOriginRow, inputOriginCol, inputDestinationRow, inputDestinationCol;
    private boolean expected;

    public MockScenario1Test(Object inputOriginRow, Object inputOriginCol, Object inputDestinationRow, Object inputDestinationCol, boolean expected) {
        this.inputOriginRow = inputOriginRow;
        this.inputOriginCol = inputOriginCol;
        this.inputDestinationRow = inputDestinationRow;
        this.inputDestinationCol = inputDestinationCol;
        this.expected = expected;
    }
    
    /* Executes each data set of each test case. */
    public boolean insertAirCraft(Object inputOriginRow, Object inputOriginCol, Object inputDestinationRow, Object inputDestinationCol) {
    	boolean isCorrect = false;
		
    	try {
    		int originRow = (int) inputOriginRow;
    		int originCol = (int) inputOriginCol;
    		if (player.getTablero().insertBoatfirstpos(originRow, originCol, 5)) {
    			int destinationRow = (int) inputDestinationRow;
    			int destinationCol = (int) inputDestinationCol;
    			if(player.getTablero().insertBoatLastPosition(originRow, originCol, destinationRow, destinationCol, 5)) {
    				isCorrect = true;
    			}
    		}
		}
		catch (ClassCastException ex) {
			 //ex.printStackTrace(); // uncomment this line for debug purposes
		} catch (InputMismatchException ex) {
			 //ex.printStackTrace(); // uncomment this line for debug purposes
		}
		
		return isCorrect;
	}

    /* This test will run 24 times, so 6 test cases with 4 arguments each one. */
    @Test
    public void test() {    	
    	initialize(); // needed for reset player and its board
    	
    	assertEquals(expected, insertAirCraft(inputOriginRow, inputOriginCol, inputDestinationRow, inputDestinationCol));
    }
}