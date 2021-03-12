package ProjetDonjonG1;

public class TestGrille {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grille g1=new Grille(15,15);
		g1.afficher();
		Personnage J2=new Personnage("ToTo",10);
		g1.placer(5, 5, "J1");
		g1.afficher();
		g1.déplacement("sddz");
		g1.afficher();

	}

}
