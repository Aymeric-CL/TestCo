package ProjetDonjonG1;

public class Mur extends Objet {
	
	/*
	 * création de la variable degats
	 */
	private int degats;
	
	
	/*
	 * Constructeur de la classe Mur qui prends en parametre
	 * le nom du mur ex : mur1, mur2 ect.. et les dégats
	 * que ce mur va enlever.
	 */
	public Mur() throws ExceptionObjet, ExceptionMur {
		super("Mur");
		setDegats(-3);
		// TODO Auto-generated constructor stub
	}


	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) throws ExceptionMur {
		if (degats < 0)
			this.degats = degats;
		else 
			throw new ExceptionMur(" les degats de mur ne sont pas bon");
			
	}
	
	
	@Override
	public int modificationPv() {
		int degats = this.degats;
		return degats;
	}
	
	
	public String toString() {
		return super.toString()+" les degats du mur son de "+getDegats();
				
	}
	

	
	
	


	





	

	
	
	
	

}
