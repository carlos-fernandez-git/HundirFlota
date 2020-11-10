package HundirFlota;

import java.util.ArrayList;

public class MockOb2 {
	private ArrayList<Barco> barcos = new ArrayList<Barco>();

	public MockOb2() {
		//we create different type of ships to test the methods of class Barco

		/*
		 *Creating "portaaviones"
		 */
		ArrayList<int[]> positions1 = new ArrayList<int[]>();
		ArrayList<int[]> positions2 = new ArrayList<int[]>();
		ArrayList<int[]> positions3 = new ArrayList<int[]>();
		int[] pos1_1 = new int[3];
		pos1_1[0]=1; 
		pos1_1[1]=0;
		pos1_1[2]=0;
		positions1.add(getPos(pos1_1));
		
		int[] pos1_2 = new int[3];
		pos1_2[0]=1;
		pos1_2[1]=1;
		pos1_2[2]=0;
		positions1.add(getPos(pos1_2));
		
		int[] pos1_3 = new int[3];
		pos1_3[0]=1;
		pos1_3[1]=2;
		pos1_3[2]=0;
		positions1.add(getPos(pos1_3));
		
		int[] pos1_4 = new int[3];
		pos1_4[0]=1;
		pos1_4[1]=3;
		pos1_4[2]=0;
		positions1.add(getPos(pos1_4));
		
		int[] pos1_5 = new int[3];
		pos1_5[0]=1;
		pos1_5[1]=4;
		pos1_5[2]=0;
		positions1.add(getPos(pos1_5));
		Barco barco1 = new Barco(positions1,5);
		/*
		 *Creating "buque"
		 */
		
		
		int[] pos2_1 = new int[3];
		pos2_1[0]=9;
		pos2_1[1]=1;
		pos2_1[2]=0;
		positions2.add(getPos(pos2_1));
		
		int[] pos2_2 = new int[3];
		pos2_2[0]=9;
		pos2_2[1]=2;
		pos2_2[2]=0;
		positions2.add(getPos(pos2_2));

		int[] pos2_3 = new int[3];
		pos2_3[0]=9;
		pos2_3[1]=3;
		pos2_3[2]=0;
		positions2.add(getPos(pos2_3));
		
		int[] pos2_4 = new int[3];
		pos2_4[0]=9;
		pos2_4[1]=4;
		pos2_4[2]=0;
		positions2.add(getPos(pos2_4));
		Barco barco2 = new Barco(positions2,4);
		/*

		 *Creating "lancha"
		 */
		int[] pos3_1 = new int[3];
		pos3_1[0]=5;
		pos3_1[1]=5;
		pos3_1[2]=0;
		positions3.add(pos3_1);
		Barco barco3 = new Barco(positions3,1);
		
		/*
		 *Adding every ship to the barcos array. 
		 */
		barcos.add(barco1);
		barcos.add(barco2);
		barcos.add(barco3);
	}
	public Barco getBarco(int i) {
		return barcos.get(i);
	}
	public  int[] getPos(int [] x){
		return x;	
	}	
}
