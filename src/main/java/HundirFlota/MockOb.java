package HundirFlota;
import java.util.ArrayList;
import java.util.Hashtable;

public class MockOb  {

	
	private ArrayList boards=new ArrayList();
	public MockOb(){
		//Initial values
		int TableroIni[][];
		TableroIni=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				TableroIni[i][j]=0;
			}
		}
		//Mid values
		boards.add(TableroIni);
		int Tablero2[][];
		Tablero2=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Tablero2[i][j]=0;
			}
		}
		for(int x=0;x<5;x++) {
			Tablero2[0][x]=1;
		}
		boards.add(Tablero2);
		int Tablero3[][];
		Tablero3=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Tablero3[i][j]=0;
			}
		}
		for(int x=0;x<5;x++) {
			Tablero3[0][x]=1;
		}

		for(int z=0;z<5;z++) {
			Tablero3[z][8]=1;
		}
		boards.add(Tablero3);
		//Frontier values
		int Tablero4[][];
		Tablero4=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Tablero4[i][j]=0;
			}
		}
		Tablero4[0][9]=1;
		Tablero4[9][9]=1;
		Tablero4[9][0]=1;
		Tablero4[0][0]=1;
		boards.add(Tablero4);
		
		//To test the other cases on checKSpace
		int Tablero5[][];
		Tablero5=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Tablero5[i][j]=0;
			}
		}
		for(int x=4;x<10;x++) {
			Tablero5[4][x]=1;
		}

		for(int k=1;k<6;k++) {
			Tablero5[2][k]=1;
		}
		for(int z=4;z<9;z++) {
			Tablero5[z][1]=1;
		}
		boards.add(Tablero5);
		
	}
	


	public int[][] getTablero(int param) {
		//System.out.println(boards.size());
		return (int[][]) boards.get(param);
	}

	
	

}
