package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	
	public static final Inventaire Potion = null;
	private List<Objet>inventaire = new ArrayList<Objet>();
	
	
	public void addPotion (Objet o) {
		if (o!= null)
			inventaire.add(o);
	}
	public int size() {
		return inventaire.size();
		
	}

	
	
	
	
	
	

}
