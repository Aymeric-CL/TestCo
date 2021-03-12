package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	
	public static final Inventaire Potion = null;
	private List<Objet>inventaire = new ArrayList<Objet>();
	
	
	public void addPotion (Objet o) throws ExceptionInventaire {
		if (o!= null)
			inventaire.add(o);
		else 
			throw new ExceptionInventaire("Erreur dans l'inventaire");
	}
	public int size() {
		return inventaire.size();
		
	}

	
	
	
	
	
	

}
