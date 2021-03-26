package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Personnage{
	private int vie;
	private String name;
	private ArrayList<Objet> inventaire = new ArrayList<Objet>();
	private boolean enVie = true;
	

	public Personnage(String name, int vie) throws ExceptionPersonnage, ExceptionInventaire  {
		setName(name);
		setVie(vie);
		
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) throws ExceptionPersonnage {
		if (vie >=0 )
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
	  public ArrayList<Objet> getInventaire() {
	        return inventaire;
	    }

	    public void setInventaire(ArrayList<Objet> inventaire) {
	        this.inventaire = inventaire;
	    }
	
	public boolean mort() {
		if ( vie <= 0) {
			enVie=false;
			return (!enVie);
		}
		else {
			return (!enVie);
		}
			
	}
	public void ramasserPotion (Potion p) throws ExceptionInventaire, ExceptionPersonnage {
		if (p!= null)
			inventaire.add(p);
		else 
			throw new ExceptionInventaire("Erreur dans l'inventaire");
	}



	public void utiliserPotion(Objet potion) throws ExceptionPersonnage, ExceptionInventaire {
		if (!inventaire.isEmpty()) {
			for (int i =0; i<=inventaire.size();i++)
				if (potion!=null) {
						Objet objet = inventaire.remove(i);
						int rajoutPv = objet.modificationPv();
						this.vie+= rajoutPv;
				}
				else 
					throw new ExceptionInventaire("Erreur dans l'inventaire");

			
		}
		
			
	
	}
	
	
	public String toString() {
		return "Point de vie de "+ name + " est " + vie;

}


}
