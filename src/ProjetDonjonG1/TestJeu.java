package ProjetDonjonG1;

import java.util.Scanner;

public class TestJeu {
	
	public static void main(String[] args) throws ExceptionGrille, ExceptionPersonnage,  ExceptionPotion, ExceptionObjet, ExceptionInventaire, ExceptionPiege, ExceptionObjetif {
		
		
		
	//////////////INITIALISATION DE CERTAINE CHOSE AVANT PARTIE//////////////////////
		
		Scanner sc = new Scanner(System.in); //initialisation d'un scanner
		System.out.println(" veuillez rentrer votre prénom pour commencer la partie");
		String prenom = sc.next(); // scaner pour le prenom du joeur
		
		Grille g1 = new Grille("g1");// grille que va voir le joueur
		Grille g2 = new Grille("g2");// grille ou on va placer tout les objets sans que le joueur voit cette grille
		Grille g3 = new Grille("g3");// grille qui va nous aider a savoir si le joueur est deja passé sur cette case ou non
		
		
		
		/*
		 *placement des murs sur le graphe g2 car si on fait des 
		 *murs aléatoire on peut rester bloquer donc on a decider
		 *de ne pas faire de mur aléatoire
		 */
		g2.apparaitreMur(1, 1);// placement du premier mur sur la grille g2
		g2.apparaitreMur(2, 6);// placement du deuxième mur sur la grille g2
		g2.apparaitreMur(2, 7);// ...
		g2.apparaitreMur(2, 8);
		g2.apparaitreMur(3, 4);
		g2.apparaitreMur(6, 6);
		g2.apparaitreMur(6, 7);
		g2.apparaitreMur(6, 8);
		g2.apparaitreMur(8, 2);
		g2.apparaitreMur(8, 3);
		g2.apparaitreMur(8, 10);
		g2.apparaitreMur(9, 7);// placement du douxième mur sur la grille g2
		
		
		
		/*
		 * création des potions aléatoire 
		 */
		
		
		
		
			
		int i1 = 0;
		while(i1<5 ) {
			int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			
			if (g2.accederCaseGrille(Xaléatoire, Yaléatoire).equals("???")) {
				g2.apparaitrePotion(Xaléatoire, Yaléatoire);
				i1+=1;
			}
		}
		
		
		/*
		 * création des pièges aléatoire 
		 */
		
		int i2 = 0;
		while(i2<5 ) {
			int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			
		if (g2.accederCaseGrille(Xaléatoire, Yaléatoire).equals("???")) {
			g2.apparaitrePiege(Xaléatoire, Yaléatoire);
		i2+=1;
		}}
			
			
		
		
		
		/*
		 * création de objectif, on va tester si il y a au moins une case 
		 * de libre autour de l'objectif que le joeur puisse y acceder c'est pour ça
		 * qu'il y a autant de condition dans le if on a tester 4 cases.
		 */
	try {	
	boolean t = true;
	while(t) {
			Boolean i3 = true;
		while(i3) {
			int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
			int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
			if(g2.accederCaseGrille(Xaléatoire, Yaléatoire).equals("???")) {
				if (g2.accederCaseGrille(Xaléatoire, Yaléatoire-1).equals("???")  ||
						g2.accederCaseGrille(Xaléatoire-1, Yaléatoire).equals("???")||
						g2.accederCaseGrille(Xaléatoire, Yaléatoire+1).equals("???")|| 
						g2.accederCaseGrille(Xaléatoire+1, Yaléatoire).equals("???")) {
				
					g2.apparaitreObjectif(Xaléatoire, Yaléatoire);
					i3 = false;
					t= false;
					
				}
					
			}
			
		}
	
	}
	}
	catch(Exception e) {
		//e.printStackTrace();
	}
/*
 * création et placement du personnage 
 * 	
 */
	
/////////////////// Placement du personnage/////////////////////
	
	
	int coordonnéePersonnageXDépart = 0;
	int coordonnéePersonnageYDépart = 0;
	boolean t2 = true; // initialisation de la variable T2 a true
	
	while(t2) { //vas tourner temps qu'on a pas trouver une place au personnage
	try {
		
	
	
		
			Boolean i = true;
			while(i) {
				int Xaléatoire = 1+(int) (Math.random()*((10-1)+1));
				int Yaléatoire = 1+(int) (Math.random()*((10-1)+1));
				if(g2.accederCaseGrille(Xaléatoire, Yaléatoire).equals("???")) {
					if (g2.accederCaseGrille(Xaléatoire, Yaléatoire-1).equals("???")  |
							g2.accederCaseGrille(Xaléatoire-1, Yaléatoire).equals("???") |
							g2.accederCaseGrille(Xaléatoire, Yaléatoire+1).equals("???") | 
							g2.accederCaseGrille(Xaléatoire+1, Yaléatoire).equals("???") ) {
							g1.apparaitrePersonnage(Xaléatoire, Yaléatoire);
							g2.apparaitrePersonnage(Xaléatoire, Yaléatoire);
							 coordonnéePersonnageXDépart = Xaléatoire;
							 coordonnéePersonnageYDépart = Yaléatoire;
						i = false;
						t2= false;
						}
					}
				}
			}
	
	catch(Exception e) {
		//e.printStackTrace();
		
	}}
	//création du personnage
	
	Personnage p1 = new Personnage(prenom,coordonnéePersonnageXDépart,coordonnéePersonnageYDépart);
	

	
	
	
/////////////////////COMMMENCEMENT DE LA PARTIE////////////////////////////////////////////
	
	
	 
	System.out.println(" Salut ! la partie va bientot commencer "+prenom+" prépare toi !");
	g1.afficher();
	g2.afficher();/////a enlever 
	
	
	
	Piege piege = new Piege();
	Potion potion = new Potion();
	Mur mur = new Mur();
	Objectif objectif = new Objectif();
	//Inventaire inventaire1 = new Inventaire(); 
	
	
	while(p1.getVie()> 0 && objectif.obectifAAtteindre(g1.chercheperso(), g2.chercheOb()) ){
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
		
	////////////TEST DES MOUVEMENTS RENTRÉS PAR LE JOEUR /////////////////////////////// ( opérationnel)
		
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
			if(move4.equals("H") || move4.equals("B") || move4.equals("D") || move4.equals("G") || move4.equals("R") || move4.equals("U") ) {
				boucle+=1;
			}
			else {
				System.out.println(" Vous n'avez pas bien saisie le quatrième mouvement veuillez le ressaisir : ");
				move4 = sc.next();
				boucle = 0;
			}				
						
	}
		
		
		
		
		
			
		int cX0 = p1.retourneCoorX();
		int cY0 = p1.retourneCoorY();
		
		
		
	///////////////////////////Mouvement 1/////////////////////////////////////
		
		int l1 = g1.cherchePersoLigne();
		int c1 = g1.cherchePersoColonne();
		
		System.out.println(p1.toString());
		if( move1.equals("H")){
			g2.testCase(l1, c1, g1, p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
			g1.deplacementH("XXX",p1);
			
		}
		if(move1.equals("B")){
			g1.deplacementB("XXX",p1);
			g2.testCase(l1, c1,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
			
				
		}
		if(move1.equals("D")) {				
			g1.deplacementD("XXX",p1);
			g2.testCase(l1, c1,g1,p1);	
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
			
			
		}
		if(move1.equals("G")){
			g1.deplacementG("XXX",p1);
			g2.testCase(l1, c1,g1,p1);	
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();		
		}
		if(move1.equals("R")){
			g2.testCaseRamasserPotion(l1, c1, p1);
		}
		if(move1.equals("U")) {
			g2.testUtiliseP(p1);;
			
		}
		
		
//////////////////////////Mouvement 2//////////////////////////////////////////////
		
		int l2 = g1.cherchePersoLigne();
		int c2 = g1.cherchePersoColonne();

		if(move2.equals("H")) {
			g1.deplacementH("XXX",p1);	
			g2.testCase(l2, c2,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("B")) {
			g1.deplacementB("XXX",p1);
			g2.testCase(l2, c2,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move2.equals("D")) {
			g1.deplacementD("XXX",p1);
			g2.testCase(l2, c2,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		if(move2.equals("G")){
			g1.deplacementG("XXX",p1);
			g2.testCase(l2, c2,g1,p1);	
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("R")){
			g2.testCaseRamasserPotion(l2, c2, p1);		
			}
		if(move2.equals("U")) {
			g2.testUtiliseP(p1);
		}
//////////////////////////Mouvement 3//////////////////////////////////////////////

		int l3 = g1.cherchePersoLigne();
		int c3 = g1.cherchePersoColonne();
		
		if(move3.equals("H")) {
			g1.deplacementH("XXX",p1);
			g2.testCase(l3, c3,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("B")) {
			g1.deplacementB("XXX",p1);
			g2.testCase(l3, c3,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move3.equals("D")) {
			g1.deplacementD("XXX",p1);
			g2.testCase(l3, c3,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if(move3.equals("G")){
			g1.deplacementG("XXX",p1);
			g2.testCase(l3, c3,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("R")){
			g2.testCaseRamasserPotion(l3, c3, p1);		
			}
		if(move3.equals("U")) {
			g2.testUtiliseP(p1);
		}
//////////////////////////Mouvement 4//////////////////////////////////////////////

		int l4 = g1.cherchePersoLigne();
		int c4 = g1.cherchePersoColonne();
		if(move4.equals("H")) {
			
			g1.deplacementH("XXX",p1);
			g2.testCase(l4, c4,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		
		if(move4.equals("B")) {
			g1.deplacementB("XXX",p1);
			g2.testCase(l4, c4,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move4.equals("D")) {
			g1.deplacementD("XXX",p1);
			g2.testCase(l4, c4,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if(move4.equals("G")){
			g1.deplacementG("XXX",p1);
			g2.testCase(l4, c4,g1,p1);
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("R")){
			g2.testCaseRamasserPotion(l4, c4, p1);	
		}
		if(move4.equals("U")) {
			g2.testUtiliseP(p1);
		}
		System.out.println(p1.toString());
		/*
		
		
		int cX1 = p1.retourneCoorX();
		int cY1 = p1.retourneCoorY();
		boolean var11 = false;
		boolean var12 = false;
		
		
System.out.println(" Test de mes class ");


		
		System.out.println(g1);
		g1.apparaitrePersonnage(cX0, cY0);
		System.out.println(g1);
		g1.apparaitreMur(cX1, cY1);
		System.out.println(g1);
		
		
		
		
		if(g2.accederCaseGrille(cX1, cY1).equals("~~~")) {
			if (g3.accederCaseGrille(cX1, cY1).equals("???")) {
				g3.apparaitrePiege(cX1, cY1);
				var11 = true;
				}
			System.out.println("vous etes sur un piege");
			System.out.println(p1.degatObjet(piege));
			g1.afficher();
			
		}
			
		if(g2.accederCaseGrille(6, 6).equals("###")) {
			System.out.println(" rentré dans mur");
			p1.degatObjet(mur);
			g1.apparaitrePersonnage(cX0, cY0);
			g1.apparaitreMur(cX1, cY1);
			g3.apparaitreMur(cX1, cY1);
			}
			g1.afficher();
			
		if(g2.accederCaseGrille(cX1, cY1).equals("PPP")) {
			if (g3.accederCaseGrille(cX1, cY1).equals("???")){
				g3.apparaitrePotion(cX1, cY1);
				var12 = true;
			}
			else
			{
				inventaire1.add(potion);
			}
			g1.afficher();
		}
		if(g2.accederCaseGrille(cX1, cY1).equals("vvv")) {
			objAtteint = false;
			System.out.println("BRAVOOOO ! vous avez trouvé l'objectif ");
			
		}}
		
		*/
			
			
		
		
		/*		
		
		
//////////////////////////Mouvement 2//////////////////////////////////////////////
		
		if(move2.equals("H")) {
			g1.deplacementH("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");	
		}
		if(move2.equals("B")) {
			g1.deplacementB("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");	
		}

		if( move2.equals("D")) {
			g1.deplacementD("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
			
		}
		if(move2.equals("G")){
			g1.deplacementG("XXX",p1);
			System.out.println(" ");
			System.out.println(" ");
		}
		
		
		
		
		
		if(var11) {
			g1.apparaitrePiege(cX1, cY1);
		}
		if(var12) {
			g1.apparaitrePotion(cX1, cY1);
		}
		
		int cX2 = p1.retourneCoorX();
		int cY2 = p1.retourneCoorY();
		boolean var21 = false;
		boolean var22 = false;
		
		
		if(g2.accederCaseGrille(cX2, cY2).equals("~~~")) {
			if (g3.accederCaseGrille(cX2, cY2).equals("???")) {
				g3.apparaitrePiege(cX2, cY2);
				var21 = true;
				}
			System.out.println("vous etes sur un piege");
			p1.degatObjet(piege);
			g1.afficher();
			
		}
			
		if(g2.accederCaseGrille(cX2, cY2).equals("###")) {
			p1.degatObjet(mur);
			g1.placerJoueur(cX1, cY1, p1);
			g1.apparaitreMur(cX2, cY2);
			g3.apparaitreMur(cX2, cY2);
			}
			g1.afficher();
			
		if(g2.accederCaseGrille(cX2, cY2).equals("PPP")) {
			if (g3.accederCaseGrille(cX2, cY2).equals("???")){
				g3.apparaitrePotion(cX2, cY2);
				var22 = true;
			}
			else
			{
				inventaire1.add(potion);
			}
			g1.afficher();
		}
		if(g2.accederCaseGrille(cX2, cY2).equals("vvv")) {
			objAtteint = false;
			System.out.println("BRAVOOOO ! vous avez trouvé l'objectif ");
			
		}
		
		
		
		
		
		
//////////////////////////Mouvement 3//////////////////////////////////////////////		
		
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
		
		
		
		
		if(var21) {
			g1.apparaitrePiege(cX1, cY1);
		}
		if(var22) {
			g1.apparaitrePotion(cX1, cY1);
		}
		
		int cX3 = p1.retourneCoorX();
		int cY3 = p1.retourneCoorY();
		boolean var31 = false;
		boolean var32 = false;
		
		
		if(g2.accederCaseGrille(cX3, cY3).equals("~~~")) {
			if (g3.accederCaseGrille(cX3, cY3).equals("???")) {
				g3.apparaitrePiege(cX3, cY3);
				var31 = true;
				}
			System.out.println("vous etes sur un piege");
			p1.degatObjet(piege);
			g1.afficher();
			
		}
			
		if(g2.accederCaseGrille(cX3, cY3).equals("###")) {
			p1.degatObjet(mur);
			g1.placerJoueur(cX2, cY2, p1);
			g1.apparaitreMur(cX3, cY3);
			g3.apparaitreMur(cX3, cY3);
			}
			g1.afficher();
			
		if(g2.accederCaseGrille(cX3, cY3).equals("PPP")) {
			if (g3.accederCaseGrille(cX3, cY3).equals("???")){
				g3.apparaitrePotion(cX3, cY3);
				var32 = true;
			}
			else
			{
				inventaire1.add(potion);
			}
			g1.afficher();
		}
		if(g2.accederCaseGrille(cX3, cY3).equals("vvv")) {
			objAtteint = false;
			System.out.println("BRAVOOOO ! vous avez trouvé l'objectif ");
			
		}
		
		
//////////////////////////Mouvement 4//////////////////////////////////////////////		
		
		
		
		
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
		

		if(var31) {
			g1.apparaitrePiege(cX1, cY1);
		}
		if(var32) {
			g1.apparaitrePotion(cX1, cY1);
		}
		
		int cX4 = p1.retourneCoorX();
		int cY4 = p1.retourneCoorY();
		boolean var41 = false;
		boolean var42 = false;
		
		
		if(g2.accederCaseGrille(cX4, cY4).equals("~~~")) {
			if (g3.accederCaseGrille(cX4, cY4).equals("???")) {
				g3.apparaitrePiege(cX4, cY4);
				var31 = true;
				}
			System.out.println("vous etes sur un piege");
			p1.degatObjet(piege);
			g1.afficher();
			
		}
			
		if(g2.accederCaseGrille(cX4, cY4).equals("###")) {
			p1.degatObjet(mur);
			g1.placerJoueur(cX3, cY3, p1);
			g1.apparaitreMur(cX4, cY4);
			g3.apparaitreMur(cX4, cY4);
			}
			g1.afficher();
			
		if(g2.accederCaseGrille(cX4, cY4).equals("PPP")) {
			if (g3.accederCaseGrille(cX4, cY4).equals("???")){
				g3.apparaitrePotion(cX4, cY4);
				var42 = true;
			}
			else
			{
				inventaire1.add(potion);
			}
			g1.afficher();
		}
		if(g2.accederCaseGrille(cX4, cY4).equals("vvv")) {
			objAtteint = false;
			System.out.println("BRAVOOOO ! vous avez trouvé l'objectif ");
			
		}
	
	
	
	
		else if( move1 == "R" ||  move2 == "R"|| move2 == "R"|| move4 == "R" ) {
			//Inventaire.addPotion(potion1);
		}
		else if (move1 == "U" || move2 == "U"|| move3 == "U"|| move4 == "U") {
			//Personnage.utiliserPotion();
		}
		
		
		
		System.out.println("Les coordonnées de X sont "+p1.getCoorX()+" les coordonnées de Y sont "+p1.getCoorY());
		*/
	}
	}
}


	




















































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

