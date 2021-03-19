package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;


public class Personnage {
	private int vie;
	private String name;
	private Inventaire inventaire;
	private boolean enVie = true;
	

	public Personnage(String name, int vie) throws ExceptionPersonnage, ExceptionInventaire  {
		setName(name);
		setVie(vie);
		
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) throws ExceptionPersonnage {
		if (vie >0 )
			this.vie=vie;
		else
			throw new ExceptionPersonnage ("Le personnage n'a plus du vie");
		
		
	}
	public String getName() {
		return name;
		
	}
	public void setName(String name) throws ExceptionPersonnage {
		if (name.length() >= 2 )
			this.name = name;
		else
			throw new ExceptionPersonnage(" le nom du personnage n'est pas bon");
			
	}
	
	public void mort() {
		enVie=false;
	}

	private void utiliserPotion() throws ExceptionPersonnage, ExceptionInventaire {
		if (!inventaire.isEmpty()) {
			Objet objet = inventaire.pop();
			int rajoutPv = objet.modificationPv();
			this.vie+= rajoutPv;
		}
		
			
	
	}
	
	
	public String toString() {
		return "Point de vie de "+ name + " est " + vie;

}


}
