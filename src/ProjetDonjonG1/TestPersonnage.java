package ProjetDonjonG1;

public class TestPersonnage {

	public static void main(String[] args) throws ExceptionPersonnage, ExceptionObjet, ExceptionPotion, ExceptionInventaire {
		

		
		
		
		
		
		Personnage p = new Personnage("John",13);
		System.out.println(p.mort());
		System.out.println(p);
		Personnage p2 = new Personnage("jc",0);
		System.out.println(p2.mort());
		System.out.println(p2);
		
		/*Personnage p4 = new Personnage("Paul",-4);
		System.out.println(p4.mort());
		System.out.println(p4);/*
		

		
		/*test utilisation potion/*
		 * 
		 */
		Personnage p3 = new Personnage("Charle", 2);
		Potion potion1 = new Potion("potion1",4);
		System.out.println(p3);
		p3.ramasserPotion(potion1);
		p3.utiliserPotion(potion1);
		System.out.println(p3);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
