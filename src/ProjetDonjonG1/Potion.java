package ProjetDonjonG1;

public class Potion extends Objet{
	
	
	/*
	 * création de la variable potion
	 */
	private int potion;

	/*
	 * création du constructeur de potion
	 */
	public Potion(String name, int potion) throws ExceptionObjet, ExceptionPotion {
		super(name);
		setPotion(potion);
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * getter de potion
	 */
	public int getPotion() {
		return potion;
	}

	/*
	 * setter de potion on veut que des valeurs positive
	 */
	public void setPotion(int potion) throws ExceptionPotion {
		if (potion > 0) {
			this.potion = potion;
		}
		else
			throw new ExceptionPotion(" la valeur de la potion n'est pas bonne");
			
		
	}





	/*
	 * on modifie la methode de objet pour retourner le gain 
	 * que va apporter une potion au personnage
	 */
	
	
	/*
	 * on modifie la methode toString de objet pour savoir combien 
	 * va rajouter de pv la potion.
	 */
	public String toString() {
		return super.toString()+" la potion rajoute "+getPotion()+" point de vie";
	}



	@Override
	public int modificationPv() {
		int potion = this.potion;
		return potion;
	}
	
	
	
}