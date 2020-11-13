package HundirFlota;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BarcoTest {

	@Test
	public void testCreateShip() {
		/* first version of tests for barco
		Barco b=new Barco();
		String res_0 = "Porta-aviones"; 
		String res_1 = "Buque";
		String res_2 = "Lancha";
		String[][] resultado=b.getBarco();
		assertEquals(res_0,resultado[0][0]); 
		assertEquals(res_1,resultado[1][0]); 
		assertEquals(res_2,resultado[2][0]); 
		assertEquals("2",resultado[0][1]); 
		assertEquals("3",resultado[1][1]);
		assertEquals("5",resultado[2][1]); 
		assertEquals("5",resultado[0][2]); 
		assertEquals("4",resultado[1][2]);
		assertEquals("1",resultado[2][2]); */
		MockOb2 mock = new MockOb2();
		Barco b = new Barco(mock.getBarco(0).getPositions(),5);			//create portaaviones
		Barco b2 = new Barco(mock.getBarco(1).getPositions(),4);		//create buque
		Barco b3 = new Barco(mock.getBarco(2).getPositions(),1);		//create lancha
		
		//check if it create properly the ships
		assertEquals(b.getTypeOfBoat(),"Air Craft Carrier");
		assertEquals(b2.getTypeOfBoat(),"Vessel");
		assertEquals(b3.getTypeOfBoat(),"Motor Boat");
		assertNotEquals(b.getTypeOfBoat(),"Vessel");
		assertNotEquals(b2.getTypeOfBoat(),"Motor BAoat");
		assertNotEquals(b3.getTypeOfBoat(),"Air Craft Carrier");
		
		//check that positions size is equal as length
		assertEquals(b.getLength(),b.getPositions().size());
		assertEquals(b2.getLength(),b2.getPositions().size());
		assertEquals(b3.getLength(),b3.getPositions().size());
		
		//check that boats arent sunked when created
		assertFalse(b.isSunk());
		assertFalse(b2.isSunk());
		assertFalse(b3.isSunk());
	}	
	@Test
	public void testifHit() {
		MockOb2 mock = new MockOb2();
		Barco b = mock.getBarco(0);
		Barco b2 = mock.getBarco(1);
		Barco b3 = mock.getBarco(2);
		
		/*1st we check if its 0 before we call the ifHit function
		 * 2nd we call ifHit function
		 * 3rd we check if its 1 after we called ifHit function
		 * 4th we check if after calling again the function ifHit it still 1
		 * */
		
		//portaaviones test
		//1st test
		assertEquals(b.getPositions().get(0)[2],0);
		b.ifHit(1,0);
		assertEquals(b.getPositions().get(0)[2],1);
		b.ifHit(1,0);
		assertEquals(b.getPositions().get(0)[2],1);
		//2nd test
		assertEquals(b.getPositions().get(1)[2],0);
		b.ifHit(1,1);
		assertEquals(b.getPositions().get(1)[2],1);
		b.ifHit(1,1);
		assertEquals(b.getPositions().get(1)[2],1);
		//3rd test
		assertEquals(b.getPositions().get(2)[2],0);
		b.ifHit(1,2);
		assertEquals(b.getPositions().get(2)[2],1);
		b.ifHit(1,2);
		assertEquals(b.getPositions().get(2)[2],1);
		//4th test
		assertEquals(b.getPositions().get(3)[2],0);
		b.ifHit(1,3);
		assertEquals(b.getPositions().get(3)[2],1);
		b.ifHit(1,3);
		assertEquals(b.getPositions().get(3)[2],1);
		//5th test
		assertEquals(b.getPositions().get(4)[2],0);
		b.ifHit(1,4);
		assertEquals(b.getPositions().get(4)[2],1);
		b.ifHit(1,4);
		assertEquals(b.getPositions().get(4)[2],1);
		
		//buque test
		//1st test
		assertEquals(b2.getPositions().get(0)[2],0);
		b2.ifHit(9,1);
		assertEquals(b2.getPositions().get(0)[2],1);
		b2.ifHit(9,1);
		assertEquals(b2.getPositions().get(0)[2],1);
		//2nd test
		assertEquals(b2.getPositions().get(1)[2],0);
		b2.ifHit(9,2);
		assertEquals(b2.getPositions().get(1)[2],1);
		b2.ifHit(9,2);
		assertEquals(b2.getPositions().get(1)[2],1);
		//3rd test
		assertEquals(b2.getPositions().get(2)[2],0);
		b2.ifHit(9,3);
		assertEquals(b2.getPositions().get(2)[2],1);
		b.ifHit(9,3);
		assertEquals(b2.getPositions().get(2)[2],1);
		//4th test
		assertEquals(b2.getPositions().get(3)[2],0);
		b2.ifHit(9,4);
		assertEquals(b2.getPositions().get(3)[2],1);
		b2.ifHit(9,4);
		assertEquals(b2.getPositions().get(3)[2],1);
		
		//lancha test
		assertEquals(b3.getPositions().get(0)[2],0);
		b3.ifHit(5,5);
		assertEquals(b2.getPositions().get(0)[2],1);
		b2.ifHit(5,5);
		assertEquals(b2.getPositions().get(0)[2],1);
	}
	@Test
	public void testIsSunk() {
		MockOb2 mock = new MockOb2();
		Barco b = mock.getBarco(0);
		Barco b2 = mock.getBarco(1);
		Barco b3 = mock.getBarco(2);
		/*1st we will check that every boat isn't sunk
		 * 2nd we will shoot some positions from each boat (not all positions)
		 * 3rd we will check that boats arent sunk
		 * 4th we will shoot all boats to make them sunk
		 * 5th we will check if boats are sunk
		 * */
		//1st Test
		assertFalse(b.isSunk());
		assertFalse(b2.isSunk());
		assertFalse(b3.isSunk());
		//2nd Test
		b.ifHit(1,0);
		b.ifHit(1,1);
		b.ifHit(1,2);
		b.ifHit(1,3);
		b2.ifHit(9,1);
		b2.ifHit(9,2);
		b2.ifHit(9,3);
		assertFalse(b.isSunk());
		assertFalse(b2.isSunk());
		assertFalse(b3.isSunk());
		//3r Test
		b.ifHit(1,4);
		b2.ifHit(9,4);
		b3.ifHit(5,5);
		assertTrue(b.isSunk());
		assertTrue(b2.isSunk());
		assertTrue(b3.isSunk());
		
	}
	
	

}
