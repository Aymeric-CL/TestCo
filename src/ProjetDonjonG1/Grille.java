package ProjetDonjonG1;
import java.util.*;

public class Grille {
	
	private int nbLig; // nombre ligne 
	private int nbCol; // nombre colonne 
	private  String[][] grille;
		
	// constructeur 
		
	public Grille(int l , int c ) {
		nbLig = l;
		nbCol = c;
		grille = new String [nbLig][nbCol];
			
			
		for(int i=0; i< nbLig; i++) {
			for(int j= 0; j< nbCol;j++) {
				grille[i][j] = "?" ;	
					
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
		return grille[l-1][c-1];
	}

	public void setGrille(String[][] grille) {
		this.grille = grille;
	}
		
		
	public void afficher() {
		
		for(int i=0; i< nbLig; i++) {
			for(int j= 0; j< nbCol;j++) {
				System.out.print(" " +grille[i][j]);
				}
			System.out.println();
		}
		System.out.println();		
				
	}
	
	public void placer(int l, int c,String e) throws ExceptionGrille {
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="?") {
			grille[l][c]= e;
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
	}
	
	
	public void deplacementH( ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "J") {
					if(i-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]=".";
						grille[i-1][j]=tmp;
					}
				}
			}
		}
	}
	
	public void deplacementB( ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "J") {
					if(i+1 <= nbLig ) {
						tmp = grille[i][j];
						grille[i][j]=".";
						grille[i+1][j]=tmp;
						return;
					}
				}
			}
		}
	}
	public void deplacementD( ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "J") {
					if(j+1 <=nbCol ) {
						tmp = grille[i][j];
						grille[i][j]=".";
						grille[i][j+1]=tmp;
						return;
					}
				}
			}
		}
	}
	public void deplacementG( ) throws ExceptionGrille {
		String tmp;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "J") {
					if(j-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]=".";
						grille[i][j-1]=tmp; 
					}
				}
			}
		}
	}
}
		
	

