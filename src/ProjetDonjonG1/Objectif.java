package ProjetDonjonG1;

public class Objectif extends Objet{
	private  String[][] box ; 
	
// box est la case où ce trouve l'objectif a atteindre pour finir le jeu
	
	
	
	public Objectif () throws ExceptionObjet, ExceptionObjetif {
		super("Objectif");
	}
	
	
	
	
	
	public String[][] getBox() {
		return box;
	}
	
	public void setBox(String[][] box)  {
			this.box = box;	
	}
	
	
	
	

	public boolean obectifAAtteindre(String  caseP , String box ) {
		boolean bol = true;
			if(caseP.equals(box) ) {
				System.out.println("L'objectif est atteint ");
				bol = false ;
			}
			else {
				System.out.println("L'objectif n'est pas atteint ");
			}
			return bol;
	}


	
	public int modificationPv() {
		return 0;
	}	
}

