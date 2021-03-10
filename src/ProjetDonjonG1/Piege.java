package ProjetDonjonG1;

public class Piege extends Objet {
	private String piegeMecanique;
	private String piegeMagique;
	


	public Piege ( String name) throws  ExceptionPiege, ExceptionObjet{
		super(name);
	}
	
	public String getPiegeMecanique() {
		return piegeMecanique;
	}

	public void setPiegeMecanique(String piegeMecanique) throws ExceptionPiege {
		if (piegeMecanique.length() >= 3) {
			this.piegeMecanique = piegeMecanique;
		}
		else
			throw new ExceptionPiege("Le piege n'existe pas");
	}
			
	
	public String getPiegeMagique() {
		return piegeMagique;
	}

	public void setPiegeMagique(String piegeMagique) throws ExceptionPiege{
		if (piegeMagique.length() >= 3) {
			this.piegeMagique = piegeMagique;
		}
		else 
			throw new ExceptionPiege("Le piege n'existe pas");

	}
		
	
	
	public int piegeMequa(int pv  )throws ExceptionPiege {
		int piegeAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
		if(piegeAleatoire == 1 ) {
			System.out.print("Vous avez declenché une chute de pierre ");
			pv-=5;
		}
		else if (piegeAleatoire == 2 ){
			System.out.print("Vous êtes tombé(e) dans une fosse ");
			pv-=2;
			
		}
		else if (piegeAleatoire == 3 ){
			System.out.print("Vous êtes dans une salle remplie d'eau ");
			pv-=1;
		}
		else {
			throw new ExceptionPiege("Le piege méquanique n'existe pas");
		}
		System.out.print("Le nombre de PV restant est de : ");
		return pv;
		
	}
	
	
	public int piegeMag(int pv )throws ExceptionPiege {
		int piegeAleatoire = 1 + (int)(Math.random() * ((2 - 1) + 1));
		if(piegeAleatoire == 1) {
			System.out.print("Vous avez reçus un sort d'immobilité ");
			pv-=3;
		}
		else if (piegeAleatoire == 2 ){
			System.out.print("Vous avez reçus un sort d'aveuglement");
			pv-=2;
		}
	
		else {
			throw new ExceptionPiege("Le piege méquanique n'existe pas");
		}
		System.out.print("Le nombre de PV restant est de : ");
		return  pv ;
	}
}
	
