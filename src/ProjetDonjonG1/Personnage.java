package ProjetDonjonG1;

import java.util.ArrayList;

public class Personnage {
	private int vie;
	private String name;

	public Personnage(String name, int vie) {
		setName(name);
		setVie(vie);
		
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int v) {
		this.vie=vie;
		
	}
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String toString() {
		return "Point de vie de "+ name + " est " + vie;

}


}
