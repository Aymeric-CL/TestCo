package ProjetDonjonG1;
import java.util.Scanner;
public class TestGrille {
	

	public static void main(String[] args) throws ExceptionPersonnage, ExceptionGrille {
		// TODO Auto-generated method stub
		//crée la grille
		Grille g1=new Grille(6,6);
		//g1.afficher();
		// on place le joueur 
		g1.placerJoueur(3, 4, "J");
		// affiche la grille 
		g1.afficher();
		
		g1.deplacementH();
		g1.afficher();
		g1.deplacementH();
		g1.afficher();
		g1.deplacementD();
		g1.afficher();
		g1.deplacementD();
		g1.afficher();
		g1.deplacementB();
		g1.afficher();
		g1.deplacementB();
		g1.afficher();
		g1.deplacementG();
		g1.afficher();
		g1.deplacementG();
		g1.afficher();
	}

}
