package ProjetDonjonG1;
import java.util.Scanner;
public class TestGrille {
	

	public static void main(String[] args) throws ExceptionPersonnage, ExceptionGrille, ExceptionObjet, ExceptionPotion, ExceptionInventaire, ExceptionPiege, ExceptionObjetif {
		/*
		
		// TODO Auto-generated method stub
		//crée la grille
		Grille g1=new Grille("g1");
		Grille g2 = new Grille("g2");
		
		
		
		
	//////////// INITIALISATION DES OBJETS///////////
		Potion po1 = new Potion("po1",3);
		Piege pi1 = new Piege("pi1",-3);
		Objectif ob1 = new Objectif("ob1");
		Mur mu1 = new Mur("mu1", -2);
		
		g2.apparaitreMur(1, 3, mu1);
		g2.apparaitreObjectif(3, 3, ob1);
		g2.apparaitrePiege(5, 5, pi1);
		g2.apparaitrePotion(2, 2, po1);
		g2.afficher();
		
		//// Test de la methode accederCaseGrilles(i,j)
		System.out.println(" test de la methode acceder case grille grille2 case 2,2 ");
		System.out.println(g2.accederCaseGrille(2, 2));
		System.out.println(" test de la methode acceder case grille grille1 case 1,1");
		System.out.println(g1.accederCaseGrille(1,1));
		///la methode accederCaseGrilles(i,j) marche.
		
		
		Personnage p1 = new Personnage("J01",10,3,2);
		
		
	////   TEST SI LE JOEUR EST SUR UN OBJET OU PAS
		*/
		
		/*
		 * cette partie de programme parcours la première grille elle cherche
		 * où est le joueur dès qu'elle voit où est le joueur elle regarde 
		 * si dans la deuxième grille il se trouve un objet si il se trouve un objet alors 
		 * elle affiche la potion sur la grille du joueur 
		 */
		/*
		
		
		System.out.println( " Test des deux grille ");
		if (g2.getNbLig() == g1.getNbLig() && g2.getNbCol() == g1.getNbCol()) {
		for(int i =0; i< g2.getNbLig();i++) {
			for(int j= 0;j< g2.getNbCol();j++) {
				//System.out.print(i);
				//System.out.println(j);
				if (g1.accederCaseGrille(i, j) == "j") {
					if (g2.accederCaseGrille(i, j) == po1.getName()) {
						g1.apparaitrePotion(i, j);
					}
				}
				
				
			}}}
		else 
			System.err.println(" la grille "+g1.getNomGrille()+" et la grille "+g2.getNomGrille()+" n'ont pas la meme taille ");
	
		
		g1.placerJoueur(3, 4, p1);
		// affiche la grille 
		g1.afficher();
		
		g1.deplacementH(p1);
		g1.afficher();
		g1.deplacementH(p1);
		g1.afficher();
		g1.deplacementD(p1);
		g1.afficher();
		g1.deplacementD(p1);
		g1.afficher();
		g1.deplacementB(p1);
		g1.afficher();
		g1.deplacementB(p1);
		g1.afficher();
		g1.deplacementG(p1);
		g1.afficher();
		g1.deplacementG(p1);
		g1.afficher();
	
	
	/////// Test des methodes placerObjet //////////
*/
		
	/////////////////////////////////////Test deuxieme partie////////////////////////////////////////////////////////
		Grille g1 = new Grille("g1");
		Personnage p = new Personnage("p1",3,3);
		
		
		
		int x = p.getCoorX();
		int y = p.getCoorY();
		
		g1.apparaitrePersonnage(x, y);
		g1.apparaitrePiege(6, 6);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
