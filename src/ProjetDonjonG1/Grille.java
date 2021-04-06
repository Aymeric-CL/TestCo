package ProjetDonjonG1;
import java.util.*;

public class Grille {
	
	private String nomGrille;
	private int nbLig; // nombre ligne 
	private int nbCol; // nombre colonne 
	private  String[][] grille;
		
	// constructeur 
		
	public Grille(String nomGrille ) throws ExceptionGrille {
		setNbLig(10);
		setNbCol(10);
		setNomGrille(nomGrille);
		grille = new String [nbLig][nbCol];
			
			
		for(int i=0; i< nbLig; i++) {
			for(int j= 0; j< nbCol;j++) {
				grille[i][j] = "???" ;	
					
			}	
		}	
	}
	
	
	
	
	

	public String getNomGrille()  {
		return nomGrille;
	}
	
	public void setNomGrille(String nomGrille) throws ExceptionGrille{
		if (nomGrille.length() >= 2)
			this.nomGrille = nomGrille;
		else
			throw new ExceptionGrille(" Le nom de la grille n'est pas correcte");
	}






	public int getNbLig() {
		return nbLig;
	}

	public void setNbLig(int nbLig) throws ExceptionGrille {
		if (nbLig > 0)
			this.nbLig = nbLig;
		else 
			throw new ExceptionGrille(" Le nombre de ligne de la grille n'est pas bon ");
			
	}

		
			
	public int getNbCol() {
		return nbCol;
	}

	public void setNbCol(int nbCol) throws ExceptionGrille {
		if( nbCol > 0)
			this.nbCol = nbCol;
		else
			throw new ExceptionGrille(" le nombre de colonne de la grille n'est pas bon");
	}
	
	
	public String[][] getGrille() {
		return grille;
	}
	
	public void setGrille(String[][] grille) throws ExceptionGrille {
		if ( grille != null)
			this.grille = grille;
		else
			throw new ExceptionGrille(" la grille est null ");
	}

	
	
	
	public String getCase(int l, int c) {
		return grille[l-1][c-1];
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
	
	
	
	public String apparaitrePotion(int l, int c ) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="???") {
			grille[l][c]= "ppp"; 
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " La potion est placé ";
	}
	
	public String apparaitrePiege(int l, int c) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="???") {
			grille[l][c]= "~~~"; 
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " Le piege est placé ";
	}
	
	public String apparaitreObjectif(int l, int c ) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="???") {
			grille[l][c]= "vvv"; 
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " L'objectif est placé ";
	}
	
	public String apparaitreMur(int l, int c) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="???") {
			grille[l][c]= "###";
			
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " Le mur est placé ";
	}
	
	public String apparaitrePersonnage(int l, int c) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		
		if(grille[l][c] == "???")  {
			grille[l][c]= "XXX";
			
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " Le personnage est placé ";
	}
	
	public String accederCaseGrille(int i, int j) throws ExceptionGrille{
		i=i-1;
		j=j-1;
		if(i<0 || j<0 || i>nbLig || j>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			}
		else {
			return grille[i][j];
		}
		}
	
	

	
	
	
	
	
	
	public void deplacementH(String p, Personnage t ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "XXX" ) {
					if(i-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i-1][j]=tmp;
						/*
						if(grille[i-1][j].equals("###"))
							grille[i-1][j]=tmp;
						else
							grille[i-1][j]=tmp;
						t.changementCoordonnée(i-1, j);
						*/
						return;
						
					}
				}
			}
		}
	}
	
	public void deplacementB(String p, Personnage t ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "XXX") {
					if(i+1 <= nbLig ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i+1][j]=tmp;
						/*
						if(grille[i+1][j].equals("###"))
							grille[i+1][j]=tmp;
						else
							grille[i+1][j]=tmp;
						t.changementCoordonnée(i+1, j);
						*/
						return;
					}
				}
			}
		}
	}
	public void deplacementD( String p, Personnage t) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "XXX") {
					if(j+1 <=nbCol ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i][j+1]=tmp;
						/*
						if(grille[i][j+1].equals("###"))
							grille[i][j+1]=tmp;
						else
							grille[i][j+1]=tmp;
						t.changementCoordonnée(i, j+1);
						*/
						return;
					}
				}
			}
		}
	}
	public void deplacementG(String p, Personnage t ) throws ExceptionGrille {
		String tmp;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "XXX") {
					if(j-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i][j-1]=tmp;
						
						/*
						if(grille[i][j-1].equals("###"))
							grille[i][j-1]=tmp;
						else
							grille[i][j-1]=tmp;
						t.changementCoordonnée(i, j-1);
						*/
						return;
					}
				}
			}
		}
	}
	
	





}
	
	

