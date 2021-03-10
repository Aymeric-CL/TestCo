package ProjetDonjonG1;

public class Objectif extends Objet{
	private int box ; 
// box est la case où ce trouve l'objectif a atteindre pour finir le jeu
	
	public Objectif (int box, String name) throws ExceptionObjet, ExceptionObjetif {
		super(name);
		setBox(box);
	}
		

	public int getBox() {
		return box;
	}

	public void setBox(int box) throws  ExceptionObjetif {
		if (0< box )
			this.box = box;
		else {
				throw new ExceptionObjetif("La case n'exise pas");
		}
	}
	
	public void obectifAAtteindre (int box ,int casePersonnage) {
			if(casePersonnage != box ) {
				System.out.println("L'objectif n'est pas atteint veuilliez rejoué");
			}
			else {
				System.out.println("L'objectif est atteint ");
			}
	}
	

}
