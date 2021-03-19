package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xml.internal.utils.IntStack;

public class Inventaire extends Stack<Objet>{
	
	public static final Inventaire Potion = null;
	
	
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
