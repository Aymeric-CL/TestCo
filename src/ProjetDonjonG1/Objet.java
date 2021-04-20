package ProjetDonjonG1;

//  Class abstraite car on ne vas pas instancier un objet c'est abstrait.
public abstract class Objet  {
	
	// variable name pour le nom de l'objet
	private String name;

	
	// constructeur de name 
	public Objet(String name) throws ExceptionObjet {
		setName(name);
		
	}


	//getter de la variable name
	public String getName() {
		return name;
	}


	// setter de la variable name on test la longueur et s'il est compose d'au 
	// moins 1 lettre.
	public void setName(String name) throws ExceptionObjet {
		if (name.length() >= 2 && (isACaractere(name)== false))
			this.name = name;
		else
			throw new ExceptionObjet(" le nom de l'objet n'est pas bon");
	}
	
	
	
	// methode qui permet de savoir si la chaine de charactere passe en parametre
	// est compose que de chiffre = true, si il y a des lettres = false.
	public boolean isACaractere(String s) {
		for (int i= 0; i<s.length(); i++)
			if(!Character.isDigit(s.charAt(i)))
				return false;
		return true ;
			
	}

	// methode qui permet d'afficher le nom de l'objet.
	public String toString() {
		return " le nom de l'objet est "+getName();	
		}
	
	
	// methode qui va nous permettre d'enlever des pv au personnage.
	public abstract int modificationPv();


	
	
}
