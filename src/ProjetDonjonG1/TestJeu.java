package ProjetDonjonG1;

import java.util.Scanner;

public class TestJeu {
	
	public static void main(String[] args) throws ExceptionGrille, ExceptionPersonnage,  ExceptionPotion, ExceptionObjet, ExceptionInventaire, ExceptionPiege {
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" veuillez rentrer votre prénom pour commencer la partie");
		String prenom = sc.next();
		
		Grille g1 = new Grille("g1");
		Grille g2 = new Grille("g2");
		
		
		
		/*
		 *placement des murs sur le graphe g2 car si on fait des 
		 *murs aléatoire on peut rester bloquer donc on a decider
		 *de ne pas faire de mur aléatoire
		 */
		g2.apparaitreMur(1, 1);
		g2.apparaitreMur(2, 6);
		g2.apparaitreMur(2, 7);
		g2.apparaitreMur(2, 8);
		g2.apparaitreMur(3, 4);
		g2.apparaitreMur(6, 6);
		g2.apparaitreMur(6, 7);
		g2.apparaitreMur(6, 8);
		g2.apparaitreMur(8, 2);
		g2.apparaitreMur(8, 3);
		g2.apparaitreMur(8, 10);
		g2.apparaitreMur(9, 7);
		
		g2.afficher();
		
		/*
		 * création des potions aléatoire
		 */
		try {
			
		int i = 0;
		while(i<5 ) {
			int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			
			if (g2.getCase(Xaléatoire, Yaléatoire) == "???") {
				g2.apparaitrePotion(Xaléatoire, Yaléatoire);
			i+=1;
			}
		}}
		catch(Exception e) {
			//e.printStackTrace();
		}
		finally {
		//g2.afficher();
		}
		
		/*
		 * création des pièges aléatoire
		 */
		try {
			int i = 0;
			while(i<5 ) {
				int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
				int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			
			if (g2.getCase(Xaléatoire, Yaléatoire) == "???") {
				g2.apparaitrePiege(Xaléatoire, Yaléatoire);
			i+=1;
			}}}
			catch(Exception e) {
				//e.printStackTrace();
			}
			finally {
				//g2.afficher();
			}
			
		
		
		
		/*
		 * création de objectif, on va tester si il y a au moins une case 
		 * de libre autour de l'objectif que le joeur puisse y acceder c'est pour ca
		 * qu'il y a autant de condition dans le if on a tester 4 cases.
		 */
	boolean t = true;
	while(t) {
	try {
		Boolean i = true;
		while(i) {
			int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			if(g2.accederCaseGrille(Xaléatoire, Yaléatoire) == "???") {
				if (g2.accederCaseGrille(Xaléatoire, Yaléatoire-1) == "???"   ||
						g2.accederCaseGrille(Xaléatoire-1, Yaléatoire) == "???" ||
						g2.accederCaseGrille(Xaléatoire, Yaléatoire+1) == "???" || 
						g2.accederCaseGrille(Xaléatoire+1, Yaléatoire) == "???" ) {
				
					g2.apparaitreObjectif(Xaléatoire, Yaléatoire);
					i = false;
					t= false;
					
				}
					
			}
			
		}}
	catch(Exception e){
		//e.printStackTrace();
		
	}
	finally {
		//g2.afficher();
	}
	}

/*
 * création et placement du personnage 
 * 	
 */
	
	
	
	boolean t2 = true; 
	while(t2) { //vas tourner temps qu'on a pas trouver une place au personnage
	try {
		
			Boolean i = true;
			while(i) {
				int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
				int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
				if(g2.accederCaseGrille(Xaléatoire, Yaléatoire) == "???") {
					if (g2.accederCaseGrille(Xaléatoire, Yaléatoire-1) == "???"   ||
							g2.accederCaseGrille(Xaléatoire-1, Yaléatoire) == "???" ||
							g2.accederCaseGrille(Xaléatoire, Yaléatoire+1) == "???" || 
							g2.accederCaseGrille(Xaléatoire+1, Yaléatoire) == "???" ) {
						g1.apparaitrePersonnage(Xaléatoire, Yaléatoire);
						i = false;
						t2= false;
						}
					}
				}
			}
	
			catch( Exception e) {
				//e.printStackTrace();
			}
			finally {
				//g1.afficher();
			}}
	
	/*
	 * chercher où est placé le joeur dans la grille 1 pour le créer car je ne pouvais pas créer
	 * le joeur dans le try ci-dessus
	 */
	
	
	//System.out.println(" test création personnage ");
	int coordonnéePersonnageXDépart = 0;
	int coordonnéePersonnageYDépart = 0;
	boolean rt = true;
		for(int i =0; i< g1.getNbLig();i++) {
			for(int j= 0;j< g1.getNbCol();j++) {
				if (g1.accederCaseGrille(i, j) == "XXX") {
					 coordonnéePersonnageXDépart = i;
					 coordonnéePersonnageYDépart = j;
				}
			}
		}
	/*
	 * création du personnage	
	 */
	Personnage p1 = new Personnage(prenom,coordonnéePersonnageXDépart,coordonnéePersonnageYDépart);
	
	
	
	/*
	 * commencement de la partie
	 */
	
	
	System.out.println(" Salut ! la partie va bientot commencer "+prenom+" prépare toi !");
	g1.afficher();
	g2.afficher();
	
	boolean objectif = true; // pour l'objectif 
	while(p1.getVie()> 0 && objectif/* ou que l'objectif n'est pas atteint */) {
		System.out.println("        Veuilliez saisir vos 4 prochain mouvement  : ");
		System.out.println(" ");
		System.out.println("     - H pour aller en HAUT ");
		System.out.println("     - B pour aller en BAS ");
		System.out.println("     - D pour aller à DROITE ");
		System.out.println("     - G pour aller à GAUCHE ");
		System.out.println("     - R pour ramasser un objet ");
		System.out.println("     - U pour utiliser un objet ");
		System.out.println(" ");
	
	
	
	 
		
		System.out.println(" ");
		System.out.print(" Premier mouvement : ");
		String move1 = sc.next();
		System.out.print(" Deuxieme mouvement : ");
		String move2 = sc.next();
		System.out.print(" Troisieme mouvement : ");
		String move3 =sc.next();
		System.out.print(" Quatrieme mouvement : ");
		String move4 = sc.next();
		
		System.out.println(" Affichage des mouvements ");
		System.out.println(move1);
		System.out.println(move2);
		System.out.println(move3);
		System.out.println(move4);
		
	//////////// Test si les mouvement rentré par le joueur son bon
		int boucle = 0;
		while(boucle < 4) {
			if (move1.equals("H") | move1.equals("B") | move1.equals("D") | move1.equals("G") | move1.equals("R")| move1.equals("U") ) {
				boucle+=1;
				}
			else{
				System.out.println(" Vous n'avez pas bien saisie le premier mouvement veillez le ressaisir : ");
				move1  = sc.next();
				boucle = 0;
					}
			if(move2.equals("H") || move2.equals("B") || move2.equals("D") || move2.equals("G") || move2.equals("R") || move2.equals("U") ) {
				boucle+=1;
				}
			else {
				System.out.println(" Vous n'avez pas bien saisie le deuxième mouvement veuillez le ressaisir : ");
				move2 = sc.next();
				boucle = 0;
			}
			if(move3.equals("H") || move3.equals("B") || move3.equals("D") || move3.equals("G") || move3.equals("R") || move3.equals("U") ) {
				boucle+=1;
				}
			else {
				System.out.println(" Vous n'avez pas bien saisie le troisième mouvement veuillez le ressaisir : ");
				move3 = sc.next();
				boucle = 0;
			}
			if(move4.equals("H") || move4.equals("B") || move4.equals("D") || move4.equals("G") || move4.equals("4") || move4.equals("U") ) {
				boucle+=1;
			}
			else {
			System.out.println(" Vous n'avez pas bien saisie le troisième mouvement veuillez le ressaisir : ");
			move3 = sc.next();
			boucle = 0;
			}				
						
						
					
			
			
			
		}
			
		
		

		if( move1.equals("H")){
			g1.deplacementH("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("B")){
			g1.deplacementB("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("D")) {				
			g1.deplacementD("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("G")){
			g1.deplacementG("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		
		int cX = p1.retourneCoorX();
		int cY = p1.retourneCoorY();
		
		//if(g1.accederCaseGrille(cX, cY).equals("???")) {
			if (g2.accederCaseGrille(cX, cY).equals("###")) {
				// le personnage se prend un mur
				Mur mur1 = new Mur();
				g1.apparaitreMur(cX, cY);
				p1.degatObjet(mur1);
				if(p1.getVie() > 0) {
					System.out.println( "vous vous êtes prit un mur il vous reste : "+p1.getVie()+" de vie");	
				}}
				else {
					System.out.println(p1.mort());
					
				}
			if(g2.accederCaseGrille(cX, cY).equals("~~~")) {
				// le personnage tombe sur un piege
				Piege piege1 = new Piege();
				g1.apparaitrePiege(cX, cY);
				p1.degatObjet(piege1);
				if(p1.getVie() > 0) {
					System.out.println(" vous êtes tombé dans un piège il vous reste : "+p1.getVie()+" de vie");
				}}
				else {
					System.out.println(p1.mort());
					
				}
			if(g2.accederCaseGrille(cX, cY).equals("ppp")) {
				Potion potion = new Potion();
				g1.apparaitrePotion(cX, cY);
			}
			
			if(g2.accederCaseGrille(cX, cY).equals("vvv")) {
				g1.apparaitreObjectif(cX, cY);
				objectif = false;
				System.out.println("le joeur a gagné");
				
			}
			

				
		
				
		
		
		if(move2.equals("H")) {
			g1.deplacementH("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("B")) {
			g1.deplacementB("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move2.equals("D")) {
			g1.deplacementD("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("G")){
			g1.deplacementG("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		
		
		
		
		if( move3.equals("H")) {
			g1.deplacementH("XXX",p1);
			System.out.println(" ");		
			System.out.println(" ");
			g1.afficher();
		
		}
		if(move3.equals("B")) {
			g1.deplacementB("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("D")) {
			g1.deplacementD("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("G")) {
			g1.deplacementG("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		
		
		if(move4.equals("H")) {
			g1.deplacementH("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("B")) {
			g1.deplacementB("XXX", p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if( move4.equals("D" )) {
			g1.deplacementD("XXX", p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("G" )) {
			g1.deplacementG("XXX", p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
	
	
	
	
		else if( move1 == "R" ||  move2 == "R"|| move2 == "R"|| move4 == "R" ) {
			//Inventaire.addPotion(potion1);
		}
		else if (move1 == "U" || move2 == "U"|| move3 == "U"|| move4 == "U") {
			//Personnage.utiliserPotion();
		}
		
		
		
		System.out.println("Les coordonnées de X sont "+p1.getCoorX()+" les coordonnées de Y sont "+p1.getCoorY());
		}}}


		/*
		//création d'un personnage :
		Personnage p01 = new Personnage("p01" , 50);
		
		// création d'une grille
		Grille g1=new Grille(10,10,"g1");
		
		
		
		// Placement du personnage dans la grille 
		g1.placerJoueur(3, 4, p01);
		
		// afficher la grille 
		g1.afficher();
		
		// création d'une potion
		Potion potion1 = new Potion("potion1",4);
		
		
		
		
		
		System.out.println("        Veuilliez saisir vos 4 prochain mouvement  : ");
		System.out.println(" ");
		System.out.println("     - H pour aller en HAUT ");
		System.out.println("     - B pour aller en BAS ");
		System.out.println("     - D pour aller à DROITE ");
		System.out.println("     - G pour aller à GAUCHE ");
		System.out.println("     - R pour ramasser un objet ");
		System.out.println("     - U pour utiliser un objet ");
		System.out.println(" ");
		
		
		
		 
			
		System.out.println(" ");
		System.out.print(" Premier mouvement : ");
		String move1 = sc.next();
		System.out.print(" Deuxieme mouvement : ");
		String move2 = sc.next();
		System.out.print(" Troisieme mouvement : ");
		String move3 =sc.next();
		System.out.print(" Quatrieme mouvement : ");
		String move4 = sc.next();
			

		if( move1.equals("H")){
			g1.deplacementH(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("B")){
			g1.deplacementB(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("D")) {				
			g1.deplacementD(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("G")){
			g1.deplacementG(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
		if(move2.equals("H")) {
			g1.deplacementH(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("B")) {
			g1.deplacementB(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move2.equals("D")) {
			g1.deplacementD(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("G")){
			g1.deplacementG(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
			
			
		if( move3.equals("H")) {
			g1.deplacementH(p01);
			System.out.println(" ");		
			System.out.println(" ");
			g1.afficher();
			
		}
		if(move3.equals("B")) {
			g1.deplacementB(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("D")) {
			g1.deplacementD(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("G")) {
			g1.deplacementG(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
		if(move4.equals("H")) {
			g1.deplacementH(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("B")) {
			g1.deplacementB(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if( move4.equals("D" )) {
			g1.deplacementD(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("G" )) {
			g1.deplacementG(p01);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		
		
		
		else if( move1 == "R" ||  move2 == "R"|| move2 == "R"|| move4 == "R" ) {
			//Inventaire.addPotion(potion1);
		}
		else if (move1 == "U" || move2 == "U"|| move3 == "U"|| move4 == "U") {
			//Personnage.utiliserPotion();
		}
	}
}

*/

