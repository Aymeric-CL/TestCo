package ProjetDonjonG1;

public class Piege extends Objet {
	private String piege;
	private int pvEnMoins = 0;
	


	
	
	public Piege() throws  ExceptionPiege, ExceptionObjet{
		super("piege");
		
	}
	
	
	
	
	
	public String getPiege() {
		return piege;
	}
	
	public void setPiege(String piege) throws ExceptionPiege {
		if (piege.length() >= 3) {
			this.piege = piege;
		}
		else
			throw new ExceptionPiege("Le piege n'existe pas");
	}
	
	
	
	
	
	public int getPvEnMoins() {
		return pvEnMoins;
	}

	public void setPvEnMoins(int pvEnMoins) throws ExceptionPiege {
		if(pvEnMoins<=0) {
			this.pvEnMoins = pvEnMoins; 
		}
		else {
			throw new ExceptionPiege("pvEnMoins est surement superieur a  0");
		}
	}
	
	
	
	
	
	public int piegeMequa( )throws ExceptionPiege {
		int piegeAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
		if(piegeAleatoire == 1 ) {
			System.out.print("Vous avez declenche une chute de pierre ");
			pvEnMoins-=5;
		}
		else if (piegeAleatoire == 2 ){
			System.out.print("Vous etes tombe(e) dans une fosse ");
			pvEnMoins-=2;	
		}
		else if (piegeAleatoire == 3 ){
			System.out.print("Vous etes dans une salle remplie d'eau ");
			pvEnMoins-=1;
		}
		else {
			throw new ExceptionPiege("Le piege mecanique n'existe pas");
		}
		return pvEnMoins;
		
	}
	
	
	
	
	
	public int piegeMag(  )throws ExceptionPiege {
		int piegeAleatoire = 1 + (int)(Math.random() * ((2 - 1) + 1));
		if(piegeAleatoire == 1) {
			System.out.print("Vous avez recus un sort d'immobilite ");
			pvEnMoins-=3;
		}
		else if (piegeAleatoire == 2 ){
			System.out.print("Vous avez recus un sort d'aveuglement ");
			pvEnMoins-=2;
		}
		else {
			throw new ExceptionPiege("Le piege mecanique n'existe pas ");
		}
		return  pvEnMoins ;
	}
	
	
	
	
	
	public int modificationPv() {
		int pvEnMoins = this.pvEnMoins;
		return pvEnMoins;
	}
	
	
	public String toString() {
		return super.toString()+ " vous avez perdu " + getPvEnMoins()+ " de point de vie";
		
	}

}
	
