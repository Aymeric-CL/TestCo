package ProjetDonjonG1;

import java.util.Scanner;

public class TestObjet {
	
	
	
	public static void main(String[] args) throws ExceptionObjet, ExceptionMur, ExceptionPotion {
		
		
		
		
		             //TEST DE LA CLASS MUR 
		
		/*
		 * test si on peut instancier le mur et si la methode toString
		 * marche 
		 */
		Mur mur1 = new Mur("mur1",-1);
		System.out.println(mur1);
		//Mur mur2 = new Mur("mur2",3); 
		
		/*
		 * test de la methode modificationPv()
		 */
		
		System.out.println(mur1.modificationPv());
		
		
				//TEST DE CLASS POTION
		
		/*
		 * test de si on peut instancier la potion et l'afficher avec 
		 * la classe toString
		 */
		
		Potion potion1 = new Potion("potion1",4);
		System.out.println(potion1);
		
		//Potion potion2 = new Potion("potion2",-2);
		
		/*
		 * test de la methode modificationPv()
		 */
		System.out.println(potion1.modificationPv());
		
		
		

	}
}
