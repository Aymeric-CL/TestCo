package ProjetDonjonG1;

import java.util.ArrayList;


public class Personnage{
	private int vie;
	private String name;
	private ArrayList<Inventaire>inventaire= new ArrayList<Inventaire>();
	private boolean enVie = true;
	

	public Personnage(String name, int vie) throws ExceptionPersonnage {
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
	public ArrayList<Inventaire>getInventaire(){
		return inventaire;
	}
	public void setInventaire(ArrayList<Inventaire> inventaire) {
        this.inventaire = inventaire;
    }
	
	public void mort() {
		enVie=false;
	}

	public void utiliserPotion() throws ExceptionPersonnage {
		int guerison = 3;
		int i = 0;
		while((i<getInventaire().size())& getInventaire().get(i)!= Inventaire.Potion){
			i++;
		}
		if(getInventaire().get(i)==Inventaire.Potion) {
            setVie(this.getVie()+guerison);
            inventaire.remove(i);
		}
		
	}
	public void ramasserPotion(Potion potion, Personnage p) {
		
	}
	
	public String toString() {
		return "Point de vie de "+ name + " est " + vie;

}


}
