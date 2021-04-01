package ProjetDonjonG1;

import java.util.ArrayList;
import java.util.List;


public class Personnage {
	private int vie;
	private String name;
	private Inventaire inventaire;
	private boolean enVie = true;
	private int coorX;
	private int coorY;
	

	public Personnage(String name,int coorX, int coorY) throws ExceptionPersonnage, ExceptionInventaire  {
		setName(name);
		setVie(50);
		setCoorX(coorX);
		setCoorY(coorY);
		
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
	
	
	
	
	public int getCoorX() {
		return coorX;
	}
	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}


	public int getCoorY() {
		return coorY;
	}
	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}


	public String mort() {
		if ( vie <= 0) {
			enVie=false;
			return "Le personnage est mort";
		}
		else {
			return "Le personnage est en vie";
		}
			
	}

	public void utiliserPotion() throws ExceptionPersonnage, ExceptionInventaire {
		if (!inventaire.isEmpty()) {
			Objet objet = inventaire.pop();
			int rajoutPv = objet.modificationPv();
			this.vie+= rajoutPv;
		}
		
			
	
	}
	
	
	public String toString() {
		return "Point de vie de "+ name + " est " + vie;

}
	public void changementCoordonnée(int coorX, int coorY) {
		this.coorX = coorX;
		this.coorY = coorY;
	}

	
	
	public int retourneCoorX() {
		return this.coorX;
	}
	public int retourneCoorY() {
		return this.coorY;
	}
	
	public int degatObjet(Objet o) {
		int modif = o.modificationPv();
		this.vie = this.vie +modif;
		return this.vie ;
	}
}
