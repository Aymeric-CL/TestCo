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
			throw new ExceptionGrille("Zone occupee");
		}
		return " La potion est place ";
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
			throw new ExceptionGrille("Zone occupee");
		}
		return " Le piege est place ";
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
			throw new ExceptionGrille("Zone occupee");
		}
		return " L'objectif est place ";
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
			throw new ExceptionGrille("Zone occupee");
		}
		return " Le mur est place ";
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
			throw new ExceptionGrille("Zone occupee");
		}
		return " Le personnage est place ";
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
						t.changementCoordonnee(i, j+1);
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
						t.changementCoordonnee(i, j-1);
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
	
	public void testCase(int l , int c,Grille g1  ,Personnage perso ) throws ExceptionPiege, ExceptionObjet, ExceptionPotion, ExceptionGrille{
		String g=grille[l][c];
		String m ;
		if( g == "vvv") {
			m = "vvv ";
			g1.modifieCase(l, c, m);
		}
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
		System .out.println("vous activez votre super pourvoir et vous passez a traver le mur donc vous avez des degats.");
		System.out.println(m.toString());
		m.modificationPv();
		perso.degatObjet(m);
	}
		
	public void testCaseRamasserPotion(int l , int c, Personnage perso ) throws ExceptionObjet, ExceptionPotion, ExceptionPersonnage, ExceptionInventaire {
		String g=grille[l][c];
		Potion p = new Potion();
		if (g == "ppp") {
			perso.ramasserPotion (p);
			System.out.println(" La potion a ete ramassee et ajoutee a votre inventaire ");	
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
	
	
	
	public void initialisationGrille(Grille g1 , Grille g2) throws ExceptionGrille {
		
		
		/*
		 * creation de objectif, on va tester si il y a au moins une case 
		 * de libre autour de l'objectif que le joueur puisse y acceder c'est pour ca
		 * qu'il y a autant de condition dans le if on a tester 4 cases.
		 */
		
		try {	
			boolean t = true;
			while(t) {
					Boolean i3 = true;
				while(i3) {
					int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
					int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
					if(g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
						if (g2.accederCaseGrille(Xaleatoire, Yaleatoire-1).equals("???")  ||
								g2.accederCaseGrille(Xaleatoire-1, Yaleatoire).equals("???")||
								g2.accederCaseGrille(Xaleatoire, Yaleatoire+1).equals("???")|| 
								g2.accederCaseGrille(Xaleatoire+1, Yaleatoire).equals("???")) {
						
							g2.apparaitreObjectif(Xaleatoire, Yaleatoire);
							i3 = false;
							t= false;
							
						}
							
					}
					
				}
			
			}
			}
			catch(Exception e) {
			
			}
		/*
		 * creation de mur aleatoire
		 */
		int i = 0;
		while (i<12 ) {
			int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
			if (g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
				g2.apparaitreMur(Xaleatoire, Yaleatoire);
				i+=1;
			}
		}
		
		
		/*
		 * creation des potions aleatoires 
		 */
	
			
		int i1 = 0;
		while(i1<5 ) {
			int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
			
			if (g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
				g2.apparaitrePotion(Xaleatoire, Yaleatoire);
				i1+=1;
			}
		}
		
		
		/*
		 * creation des pieges aleatoires
		 */
		
		int i2 = 0;
		while(i2<5 ) {
			int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
			
		if (g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
			g2.apparaitrePiege(Xaleatoire, Yaleatoire);
		i2+=1;
		}}
			
			
		
		
		
		
	
/////////////////// Placement du personnage/////////////////////
	
	
	int coordonneePersonnageXDepart = 0;
	int coordonneePersonnageYDepart = 0;
	boolean t2 = true; // initialisation de la variable T2 a true

	while(t2) { //va tourner temps qu'on a pas trouver une place au personnage
		try {




			Boolean i0 = true;
			while(i0) {
				int Xaleatoire = 1+(int) (Math.random()*((10-1)+1));
				int Yaleatoire = 1+(int) (Math.random()*((10-1)+1));
				if(g2.accederCaseGrille(Xaleatoire, Yaleatoire).equals("???")) {
					if (g2.accederCaseGrille(Xaleatoire, Yaleatoire-1).equals("???")  |
							g2.accederCaseGrille(Xaleatoire-1, Yaleatoire).equals("???") |
							g2.accederCaseGrille(Xaleatoire, Yaleatoire+1).equals("???") | 
							g2.accederCaseGrille(Xaleatoire+1, Yaleatoire).equals("???") ) {
						g1.apparaitrePersonnage(Xaleatoire, Yaleatoire);
						g2.apparaitrePersonnage(Xaleatoire, Yaleatoire);
						coordonneePersonnageXDepart = Xaleatoire;
						coordonneePersonnageYDepart = Yaleatoire;
						i0 = false;
						t2= false;
					}
				}
			}
		}

		catch(Exception e) {
			//e.printStackTrace();
		}
	}
	}
	
	
	public void testDeplacement(String move1 ,String  move2,String move3,String move4) {
		Scanner sc = new Scanner(System.in);
		int boucle = 0;
		while(boucle < 4) {
			if (move1.equals("H") | move1.equals("B") | move1.equals("D") | move1.equals("G") | move1.equals("R")| move1.equals("U") ) {
				boucle+=1;
				}
			else{
				System.out.println(" Vous n'avez pas bien saisie le premier mouvement veuillez le ressaisir : ");
				move1  = sc.next();
				boucle = 0;
					}
			if(move2.equals("H") || move2.equals("B") || move2.equals("D") || move2.equals("G") || move2.equals("R") || move2.equals("U") ) {
				boucle+=1;
				}
			else {
				System.out.println(" Vous n'avez pas bien saisie le deuxieme mouvement veuillez le ressaisir : ");
				move2 = sc.next();
				boucle = 0;
			}
			if(move3.equals("H") || move3.equals("B") || move3.equals("D") || move3.equals("G") || move3.equals("R") || move3.equals("U") ) {
				boucle+=1;
				}
			else {
				System.out.println(" Vous n'avez pas bien saisie le troisieme mouvement veuillez le ressaisir : ");
				move3 = sc.next();
				boucle = 0;
			}
			if(move4.equals("H") || move4.equals("B") || move4.equals("D") || move4.equals("G") || move4.equals("R") || move4.equals("U") ) {
				boucle+=1;
			}
			else {
				System.out.println(" Vous n'avez pas bien saisie le quatrieme mouvement veuillez le ressaisir : ");
				move4 = sc.next();
				boucle = 0;
			}
			
		}
	}
}



