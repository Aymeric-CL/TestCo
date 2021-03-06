package ProjetDonjonG1;


public class Objet {
	
	private String name;

	
	
	public Objet(String name) throws ExceptionObjet {
		setName(name);
		
	}


	
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) throws ExceptionObjet {
		if (name.length() >= 3 && isACaractere(name))
			this.name = name;
		else
			throw new ExceptionObjet(" le nom de la fourmis n'est pas bon");
	}
	
	
	
	
	public boolean isACaractere(String s) {
		for (int i= 0; i<s.length(); i++)
			if(!Character.isDigit(s.charAt(i)))
				return false;
		return true;
			
	}

}
