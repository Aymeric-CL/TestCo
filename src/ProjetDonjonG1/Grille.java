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
		if(grille[l][c]=="???" || grille[l][c]=="...") {
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
		if(grille[l][c]=="XXX"|| grille[l][c]=="???"|| grille[l][c]=="...") {
			grille[l][c]= "~~~" ; 
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


	
	public String chercheperso() {
		int i;
		int j ;
		for(j=0 ; j<nbCol ; j++) {
			for( i=0 ; i<nbLig ; i++) {
				if(grille[i][j]== "XXX") {
					return i +" "+j ;
				}
			}
		}
		return null;
	}
		
	
	public int cherchePersoLigne() {
		int i;
		int j ;
		for(j=0 ; j<nbCol ; j++) {
			for( i=0 ; i<nbLig ; i++) {
				if(grille[i][j]== "XXX"){
					return i ;
					
				}
			}
		}
		return 0;
		
	}
	public int cherchePersoColonne() {
		int i;
		int j ;
		for( i=0 ; i<nbLig ; i++) {
			for(j=0 ; j<nbCol ; j++) {
				if(grille[i][j]== "XXX"){
					return j ;
					
				}
			}
		}
		return 0;
		
	}
	
	public void testCase(int l , int c,Grille g1 , Personnage perso ) throws ExceptionPiege, ExceptionObjet, ExceptionPotion, ExceptionGrille{
		String g=grille[l][c];
		String m ;
		if(g == "~~~" ) {
			m = "~~~"; 
			testCasePiege(perso);
			g1.modifieCase(l, c, m);		
		}
		if(g == "ppp" ){
			m = "ppp";
			testCasePotion(perso);
			g1.modifieCase(l, c, m);
			
		}
		if( g == "###") {
			m= "###";
			testCaseMur(perso, g1);	
			g1.modifieCase(l, c, m);
			
			
			
		}
			
		if( g == "vvv") {
			m = "vvv ";
			g1.modifieCase(l, c, m);
		}
		
	}


	
	public void  testCasePiege (Personnage perso) throws ExceptionPiege, ExceptionObjet {
		Piege p =new Piege();
		int piegeAleatoire = (int)(Math.random());
			if(piegeAleatoire==0) {
				p.piegeMequa();				
			}
			else {
				p.piegeMag();
		}
		System.out.println(p.toString());
		p.modificationPv();
		perso.degatObjet(p);
		
		
	}
	
	public void testCasePotion(Personnage perso) throws ExceptionObjet, ExceptionPotion {
		Potion p = new Potion();
		System.out.println(p.toString());
		
		
		
		
	}
	public void testCaseMur(Personnage perso,Grille g1) throws ExceptionObjet, ExceptionMur, ExceptionGrille {
		Mur m = new Mur();
		System.out.println(m.toString());
		m.modificationPv();
		perso.degatObjet(m);
	}
		
	public void testCaseRamasserPotion(int l , int c, Personnage perso ) throws ExceptionObjet, ExceptionPotion, ExceptionPersonnage, ExceptionInventaire {
		String g=grille[l][c];
		Potion p = new Potion();
		if (g == "ppp") {
			perso.ramasserPotion (p);
			System.out.println(" La potion a été ramassez et ajouter a votre inventaire ");	
			grille[l][c] = "...";
			
		}
		else {
			System.err.println("Vous n'etes pas sur une case potion ");
		}
	
	}
	
	
	public void testUtiliseP(Personnage perso) throws ExceptionObjet, ExceptionPotion, ExceptionPersonnage, ExceptionInventaire{
		Potion p = new Potion();
		perso.utiliserPotion(p);
	}
	
	public String chercheOb() {
		
		for(int j=0 ; j<nbCol ; j++) {
			for( int i=0 ; i<nbLig ; i++) {
				if(grille[i][j]== "vvv"){
					return i +" "+ j ;
				}
			}
		}
		return null;
	}
	
	public void modifieCase(int l , int c , String modif ) throws ExceptionGrille {
		String tmp;
		if(modif == "ppp") {
			tmp = grille[l][c];
			grille[l][c]="ppp";	
		}
		if(modif.equals("###")) {
			tmp=grille[l][c];
			grille[l][c]="###";	
			
		}
		if ( modif == "~~~") {
			tmp = grille[l][c];
			grille[l][c]="~~~";	
		}
		
		if (modif == "vvv") {
			tmp = grille[l][c];
			grille[l][c]="vvv";	

		}
		if( modif == "R") {
			tmp = grille[l][c];
			grille[l][c]="???";	
			
		}
		
	}
	public boolean testDeplacement(int l , int c, Personnage perso,String deplacement ) throws ExceptionPiege, ExceptionObjet, ExceptionPotion, ExceptionGrille {
		String g=grille[l][c];
		boolean bol = false ;
		if(grille[l][c] == "###") {
			bol = true;
			

		}
		return bol ;
	}
}