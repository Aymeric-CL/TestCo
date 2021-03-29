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
	
	
	
	
	
	
	
	
	public void placerJoueur(int l, int c,Personnage e) throws ExceptionGrille {
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		if(grille[l][c]=="???") {
			grille[l][c]= e.getName();
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
	}
	
	
	
	
	
	
	
	public String apparaitrePotion(int l, int c ) throws ExceptionGrille{
		l=l-1;
		c=c-1;
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			throw new ExceptionGrille("Hors donjon");
			
		}
		
		// cette ligne sert a rien encore mais je test
		// des choses je l'enleverrais si elle me 
		//sert vraiment a rien
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
		
		// cette ligne sert a rien encore mais je test
		// des choses je l'enleverrais si elle me 
		//sert vraiment a rien
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
		
		// cette ligne sert a rien encore mais je test
		// des choses je l'enleverrais si elle me 
		//sert vraiment a rien
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
		
		// cette ligne sert a rien encore mais je test
		// des choses je l'enleverrais si elle me 
		//sert vraiment a rien
		if(grille[l][c]=="???") {
			grille[l][c]= "###";
			
		}
		else {
			throw new ExceptionGrille("Zone occupée");
		}
		return " Le mur est placé ";
	}
	
public String accederCaseGrille(int i, int j) {
	return grille[i][j];
}
	
	
	
	
	
	
	
	
	
	
	public void deplacementH(Personnage p ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== p.getName() ) {
					if(i-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i-1][j]=tmp;
					}
				}
			}
		}
	}
	
	public void deplacementB(Personnage p ) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== p.getName()) {
					if(i+1 <= nbLig ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i+1][j]=tmp;
						return;
					}
				}
			}
		}
	}
	public void deplacementD( Personnage p) throws ExceptionGrille {
		String tmp ;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== p.getName()) {
					if(j+1 <=nbCol ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i][j+1]=tmp;
						return;
					}
				}
			}
		}
	}
	public void deplacementG(Personnage p ) throws ExceptionGrille {
		String tmp;
		for( int i=0 ; i<nbLig ; i++) {
			for(int j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== p.getName()) {
					if(j-1 >=0 ) {
						tmp = grille[i][j];
						grille[i][j]="...";
						grille[i][j-1]=tmp; 
					}
				}
			}
		}
	}
	
	
	/*
	 * cette methode aurait pour but de renvoyer le
	 * numero de case d'un objet ou d'un joueur pour
	 * savoir si ils sont sur la meme case ou pas.
	 */
	public int numeroCase(){
		return 1;
	}





}
	
	

