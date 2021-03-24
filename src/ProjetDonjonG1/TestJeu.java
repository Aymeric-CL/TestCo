package ProjetDonjonG1;

import java.util.Scanner;

public class TestJeu {
	
	public static void main(String[] args) throws ExceptionGrille, ExceptionPersonnage,  ExceptionPotion, ExceptionObjet, ExceptionInventaire {
		
		//création d'un personnage :
		Personnage p1 = new Personnage ("perso" , 50);
		
		// création d'une grille
		Grille g1=new Grille(10,10);
		
		// Placement du personagane dans la grille 
		g1.placerJoueur(3, 4, "J");
		
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
		
		
		Scanner sc = new Scanner(System.in);
		 
			
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
			g1.deplacementH();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("B")){
			g1.deplacementB();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("D")) {				
			g1.deplacementD();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move1.equals("G")){
			g1.deplacementG();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
		if(move2.equals("H")) {
			g1.deplacementH();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("B")) {
			g1.deplacementB();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}

		if( move2.equals("D")) {
			g1.deplacementD();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move2.equals("G")){
			g1.deplacementG();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
			
			
		if( move3.equals("H")) {
			g1.deplacementH();
			System.out.println(" ");		
			System.out.println(" ");
			g1.afficher();
			
		}
		if(move3.equals("B")) {
			g1.deplacementB();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("D")) {
			g1.deplacementD();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move3.equals("G")) {
			g1.deplacementG();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
			
			
			
		if(move4.equals("H")) {
			g1.deplacementH();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("B")) {
			g1.deplacementB();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if( move4.equals("D" )) {
			g1.deplacementD();
			System.out.println(" ");
			System.out.println(" ");
			g1.afficher();
		}
		if(move4.equals("G" )) {
			g1.deplacementG();
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



