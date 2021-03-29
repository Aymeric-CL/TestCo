package ProjetDonjonG1;

import java.util.Scanner;

public class TestJeu {
	
	public static void main(String[] args) throws ExceptionGrille, ExceptionPersonnage,  ExceptionPotion, ExceptionObjet, ExceptionInventaire {
		
		
		
		
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
			e.printStackTrace();
		}
		finally {
		g2.afficher();
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
				e.printStackTrace();
			}
			finally {
				g2.afficher();
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
		e.printStackTrace();
		
	}
	finally {
		g2.afficher();
	}
	}
	
	g2.afficher();
	
	
	
	
	
	
	
	
	
	
	}}
		/*
		//création d'un personnage :
		Personnage p01 = new Personnage("p01" , 50);
		
		// création d'une grille
		Grille g1=new Grille(10,10,"g1");
		
		
		
		// Placement du personagane dans la grille 
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

