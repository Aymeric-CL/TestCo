package ProjetDonjonG1;

public class testInventaire {

	public static void main(String[] args) throws ExceptionObjet, ExceptionPotion, ExceptionInventaire {
		// TODO Auto-generated method stub
		
		Inventaire inventaire = new Inventaire();
		Potion o = new Potion("potion",2);
		Potion o1 = new Potion("potion1",1);
		Potion o2 = new Potion("potion2",3);
		Potion o3 = new Potion("potion3",2);
		inventaire.addPotion(o);
		inventaire.addPotion(o1);
		inventaire.addPotion(o2);
		inventaire.addPotion(o3);

		System.out.println(inventaire.size());
		
		
		
	}

}
