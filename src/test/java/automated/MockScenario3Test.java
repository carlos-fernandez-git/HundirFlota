package automated;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the third use case scenario. 
 *  */
public class MockScenario3Test {
	private Player player;
	
	private static final char CSV_DELIMITER = ';';
	public static final String CSV_FILE = "datasets_scenario3.csv";
	
	MockScenario3Test() {
		player = new Player();
		player.setNombre("Player 1");
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
			
	public void initialize() {
		player = new Player();
    	player.setNombre("Player 1");
	}
	
	/* This test will run 15 times (one time per data set). */
    @ParameterizedTest(name = "{index}: Test with X1Orig={0}, Y1Orig={1}, X1Dest={2}, Y1Dest={3}, "
			+ "X2Orig={4}, Y2Orig={5}, X2Dest={6}, Y2Dest={7}, "
			+ "X3Orig={8}, Y3Orig={9}, X3Dest={10}, Y3Dest={11} result: {12}")
    @CsvFileSource(resources = CSV_FILE, delimiter = CSV_DELIMITER, numLinesToSkip = 1)
    public void test(String inputOriginRow1, String inputOriginCol1, String inputDestRow1, String inputDestCol1, 
    		String inputOriginRow2, String inputOriginCol2, String inputDestRow2, String inputDestCol2,
    		String inputOriginRow3, String inputOriginCol3, String inputDestRow3, String inputDestCol3,
    		boolean expected) throws Exception {
    	initialize(); // needed for reset player and its board
    	
    	MockScenario1Test e1 = new MockScenario1Test();
    	if (e1.mockInsertAirCraft(inputOriginRow1, inputOriginCol1, inputDestRow1, inputDestCol1)) {
    		if (e1.mockInsertAirCraft(inputOriginRow2, inputOriginCol2, inputDestRow2, inputDestCol2)) {
        		assertEquals(expected, mockInsertVessel(inputOriginRow3, inputOriginCol3, inputDestRow3, inputDestCol3));
        	} else { // end second mockInsertAirCraft
        		assert(false);
        	}
    	} else { // end first mockInsertAirCraft
    		assert(false);
    	}
    }
    
    public boolean mockInsertVessel(String inputOriginRow3, String inputOriginCol3, String inputDestinationRow3, String inputDestinationCol3) {
    	boolean isCorrect = false;
		
    	try {
    		int originRow = Integer.valueOf(inputOriginRow3);
    		int originCol = Integer.valueOf(inputOriginCol3);
    		if (player.getTablero().insertBoatfirstpos(originRow, originCol, 4)) {
    			int destinationRow = Integer.valueOf(inputDestinationRow3);
    			int destinationCol = Integer.valueOf(inputDestinationCol3);
    			if(player.getTablero().insertBoatLastPosition(originRow, originCol, destinationRow, destinationCol, 4)) {
    				isCorrect = true;
    			}
    		}
    	} catch (NumberFormatException ex) {
		 //ex.printStackTrace(); // uncomment this line for debug purposes
   		}
		
		return isCorrect;
    }
}