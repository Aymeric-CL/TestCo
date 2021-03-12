package ProjetDonjonG1;
import java.util.*;

public class Grille {
	private int nbLig; // nombre ligne 
	private int nbCol; // nombre colonne 
	private String [][] grille;
		
	// constructeur 
		
	public Grille(int l, int c) {
		nbLig = l;
		nbCol = c;
		grille = new String[nbLig][nbCol];
			
			
		for(int i=0; i< nbLig; i++) {
			for(int j= 0; j< nbCol;j++) {
				grille[i][j] = "?";	
					
			}	
		}	
	}

	public int getNbLig() {
		return nbLig;
	}

	public void setNbLig(int nbLig) {
		this.nbLig = nbLig;
	}

		
			
	public int getNbCol() {
		return nbCol;
	}

	public void setNbCol(int nbCol) {
		this.nbCol = nbCol;
	}

		
		
		
		
	public String[][] getGrille() {
		return grille;
	}
	public String getCase(int l, int c) {
		return grille[l][c];
	}

	public void setGrille(String[][] grille) {
		this.grille = grille;
	}
		
		
	public void afficher() {
		for(int i=0; i< nbLig; i++) {
			for(int j= 0; j< nbCol;j++) {
				System.out.print(grille[i][j]);
				}
			System.out.println();
		}
		System.out.println();		
				
	}
	
	public void placer(int l, int c,String e) {
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			System.err.println("Hors donjon");
			return;
		}
		if(grille[l][c]=="?") {
			grille[l][c]= e;
		}
		else {
			System.err.println("Zone occupée");
		}
	}
	
	/*
	public void déplacementH() {
		String tmp;
		for (int i=0; i<nbLig; i++) {
			for (int j=0; j<nbCol;j++) {
				if(grille [i][j] == "J1" || grille [i][j]=="J2") {
					if (i-1>= 0 && grille[i-1][j] != "|") {
						tmp=grille[i][j];
						grille[i][j]=" ";
						grille[i-1][j]= tmp;
					}
				}
			}
		}
		
	}
	
	
	public void déplacementB() {
		String tmp;
		for (int i=0; i<nbLig; i++) {
			for (int j=0; j<nbCol;j++) {
				if(grille [i][j] == "J1" || grille [i][j]=="J2") {
					if (i+1< nbLig && grille[i+1][j] != "|") {
						tmp=grille[i][j];
						grille[i][j]=" ";
						grille[i+1][j]= tmp;
					}
				}
			}
		}
		
	}
	
	public void déplacementG() {
		String tmp;
		for (int i=0; i<nbLig; i++) {
			for (int j=0; j<nbCol;j++) {
				if(grille [i][j] == "J1" || grille [i][j]=="J2") {
					if (j-1>= 0 && grille[i][j-1] != "|") {
						tmp=grille[i][j];
						grille[i][j]=" ";
						grille[i][j-1]= tmp;
					}
				}
			}
		}
		
	}
	
	
	public void déplacementD() {
		String tmp;
		for (int i=0; i<nbLig; i++) {
			for (int j=0; j<nbCol;j++) {
				if(grille [i][j] == "J1" || grille [i][j]=="J2") {
					if (j+1<= nbCol && grille[i][j+1] != "|") {
						tmp=grille[i][j];
						grille[i][j]=" ";
						grille[i][j+1]= tmp;
					}
				}
			}
		}
		
	}
	*/
	public void déplacement(String move) {
		for (int k=0; k<move.length(); k++) {
			if(move.charAt(k) =='z') {
				String tmp;
				for (int i=0; i<nbLig; i++) {
					for (int j=0; j<nbCol;j++) {
						if(grille [i][j] == "J1" || grille [i][j]=="J2") {
							if (i-1>= 0 && grille[i-1][j] != "|") {
								tmp=grille[i][j];
								grille[i][j]=" ";
								grille[i-1][j]= tmp;
							}
						}
					}
				}

				
			}
			if(move.charAt(k)=='s') {
				String tmp;
				for (int i=0; i<=nbLig; i++) {
					for (int j=0; j<nbCol;j++) {
						if(grille[i][j] == "J1" || grille [i][j]=="J2") {
							if (i+1<nbLig && grille[i+1][j] != "|") {
								tmp=grille[i][j];
								grille[i][j]=" ";
								grille[i+1][j]= tmp;
							}
						}
					}
				}
				
			}
			if(move.charAt(k)=='q') {
				String tmp;
				for (int i=0; i<nbLig; i++) {
					for (int j=0; j<nbCol;j++) {
						if(grille [i][j] == "J1" || grille [i][j]=="J2") {
							if (j-1>= 0 && grille[i][j-1] != "|") {
								tmp=grille[i][j];
								grille[i][j]=" ";
								grille[i][j-1]= tmp;
							}
						}
					}
				}
			}
			if(move.charAt(k)=='d') {
				String tmp;
				for (int i=0; i<nbLig; i++) {
					for (int j=0; j<nbCol;j++) {
						if(grille [i][j] == "J1" || grille [i][j]=="J2") {
							if (j+1< nbCol && grille[i][j+1] != "|") {
								tmp=grille[i][j];
								grille[i][j]=" ";
								grille[i][j+1]= tmp;
							}
						}
					}
				}
			}
		}
	}
}


