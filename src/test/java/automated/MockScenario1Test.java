package automated;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the first use case scenario. 
 *  */
public class MockScenario1Test {
	private Player player;
	
	private static final char CSV_DELIMITER = ';';
	public static final String CSV_FILE = "datasets_scenario1.csv";
	
	MockScenario1Test() {
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
	
	/* This test will run 24 times (one time per data set). */
    @ParameterizedTest(name = "{index}: Test with XOrig={0}, YOrig={1}, XDest={2}, YDest={3}, result: {4}")
    @CsvFileSource(resources = CSV_FILE, delimiter = CSV_DELIMITER, numLinesToSkip = 1)
    public void test(String inputOriginRow, String inputOriginCol, String inputDestRow, String inputDestCol, boolean expected) throws Exception {
    	initialize(); // needed for reset player and its board
    	assertEquals(expected, mockInsertAirCraft(inputOriginRow, inputOriginCol, inputDestRow, inputDestCol));
    }
	
    /* Executes each data set of each test case. */
    protected boolean mockInsertAirCraft(String inputOriginRow, String inputOriginCol, String inputDestRow, String inputDestCol) {
    	boolean isCorrect = false;
		
    	try {
    		int originRow = Integer.valueOf(inputOriginRow);
    		int originCol = Integer.valueOf(inputOriginCol);
    		if (player.getTablero().insertBoatfirstpos(originRow, originCol, 5)) {
    			int destRow = Integer.valueOf(inputDestRow);
    			int destCol = Integer.valueOf(inputDestCol);
    			if(player.getTablero().insertBoatLastPosition(originRow, originCol, destRow, destCol, 5)) {
    				isCorrect = true;
    			}
    		}
		}
		catch (NumberFormatException ex) {
			 //ex.printStackTrace(); // uncomment this line for debug purposes
		}
		
		return isCorrect;
	}
}