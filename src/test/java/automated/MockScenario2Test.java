package automated;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HundirFlota.Player;

/*
 *  This class performs a Data-driven test of all test cases of the second use case scenario. 
 *  */
public class MockScenario2Test {
	private Player player;
	
	private static final char CSV_DELIMITER = ';';
	public static final String CSV_FILE = "datasets_scenario2.csv";
	
	MockScenario2Test() {
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
	
	/* This test will run 14 times (one time per data set). */
    @ParameterizedTest(name = "{index}: Test with X1Orig={0}, Y1Orig={1}, X1Dest={2}, Y1Dest={3}, "
			+ "X2Orig={4}, Y2Orig={5}, X2Dest={6}, Y2Dest={7} result: {8}")
    @CsvFileSource(resources = CSV_FILE, delimiter = CSV_DELIMITER, numLinesToSkip = 1)
    public void test(String inputOriginRow1, String inputOriginCol1, String inputDestRow1, String inputDestCol1, 
    		String inputOriginRow2, String inputOriginCol2, String inputDestRow2, String inputDestCol2,
    		boolean expected) throws Exception {
    	initialize(); // needed for reset player and its board
    	
    	MockScenario1Test e1 = new MockScenario1Test();
    	if (e1.mockInsertAirCraft(inputOriginRow1, inputOriginCol1, inputDestRow1, inputDestCol1)) {
    		assertEquals(expected, e1.mockInsertAirCraft(inputOriginRow2, inputOriginCol2, inputDestRow2, inputDestCol2));
    	} else { 
    		assert(false);
    	}
    	
    }
}