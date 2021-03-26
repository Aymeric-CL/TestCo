package ProjetDonjonG1;

import java.util.Stack;

public class Inventaire extends Stack<Objet>{
	
	private static final Inventaire Potion = null;
	
	
	public void addPotion (Objet o) throws ExceptionInventaire {
		if (o!= null)
			this.add(o);
		else 
			throw new ExceptionInventaire("Erreur dans l'inventaire");
	}


	public int size() {
		return this.size();
		
	}

	
	
	
	
	
	

}
