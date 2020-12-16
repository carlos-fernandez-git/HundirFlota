package automated;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the sixth use case scenario. 
 *  */
public class MockScenario6Test {
	private Player player;
	
	private static final char CSV_DELIMITER = ';';
	public static final String CSV_FILE = "datasets_scenario6.csv";
	
	MockScenario6Test() {
		player = new Player();
		player.setNombre("Player 1");
	}
	
	public Player getPlayer() {
		return player;
	}
			
	public void initialize() {
		player = new Player();
    	player.setNombre("Player 1");
	}
	
	/* This test will run 17 times (one time per data set). */
    @ParameterizedTest(name = "{index}: Test with X1Orig={0}, Y1Orig={1}, X1Dest={2}, Y1Dest={3}, "
			+ "X2Orig={4}, Y2Orig={5}, X2Dest={6}, Y2Dest={7}, "
			+ "X3Orig={8}, Y3Orig={9}, X3Dest={10}, Y3Dest={11}, "
			+ "X4Orig={12}, Y4Orig={13}, X4Dest={14}, Y4Dest={15}, "
			+ "X5Orig={16}, Y5rig={17}, X5Dest={18}, Y5Dest={19}, "
			+ "X6Dest={20}, Y6Dest={21} result: {22}")
    @CsvFileSource(resources = CSV_FILE, delimiter = CSV_DELIMITER, numLinesToSkip = 1)
    public void test(String inputOriginRow1, String inputOriginCol1, String inputDestRow1, String inputDestCol1, 
    		String inputOriginRow2, String inputOriginCol2, String inputDestRow2, String inputDestCol2,
    		String inputOriginRow3, String inputOriginCol3, String inputDestRow3, String inputDestCol3,
    		String inputOriginRow4, String inputOriginCol4, String inputDestRow4, String inputDestCol4,
    		String inputOriginRow5, String inputOriginCol5, String inputDestRow5, String inputDestCol5,
    		String inputDestRow6, String inputDestCol6,
    		boolean expected) throws Exception {
    	initialize(); // needed for reset player and its board
    	
    	MockScenario1Test e1 = new MockScenario1Test();
    	if (e1.mockInsertAirCraft(inputOriginRow1, inputOriginCol1, inputDestRow1, inputDestCol1)) {
    		if (e1.mockInsertAirCraft(inputOriginRow2, inputOriginCol2, inputDestRow2, inputDestCol2)) {
    			MockScenario3Test e3 = new MockScenario3Test();
    			e3.setPlayer(e1.getPlayer());
        		if (e3.mockInsertVessel(inputOriginRow3, inputOriginCol3, inputDestRow3, inputDestCol3)) {
        			if (e3.mockInsertVessel(inputOriginRow4, inputOriginCol4, inputDestRow4, inputDestCol4)) {
        				if(e3.mockInsertVessel(inputOriginRow5, inputOriginCol5, inputDestRow5, inputDestCol5)) {
        					assertEquals(expected, this.mockInsertMotorBoat(inputDestRow5, inputDestCol5));
        				} else { // end fifth mockInsertVessel
        					assert(false); 
        				}
        			} else { // end fourth mockInsertVessel
        				assert(false); 
        			}
        		} else { // end third mockInsertVessel
        			assert(false);
        		}
        	} else { // end second mockInsertAirCraft
        		assert(false);
        	}
    	} else { // end first mockInsertAirCraft
    		assert(false); 
    	}
    }
    
    public boolean mockInsertMotorBoat(String inputDestRow6, String inputDestCol6) {
    	boolean isCorrect = false;
		
    	try {
    		int originRow = Integer.valueOf(inputDestRow6);
    		int originCol = Integer.valueOf(inputDestCol6);
    		if (player.getTablero().insertBoatfirstpos(originRow, originCol, 1)) {
    			isCorrect = true;
    		}
    	} catch (NumberFormatException ex) {
		 //ex.printStackTrace(); // uncomment this line for debug purposes
   		}
		
		return isCorrect;
    }
}