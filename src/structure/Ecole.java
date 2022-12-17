package structure;
import personnes.Humain;

public class Ecole {
	String nom;
	Humain directeur;
	Classe[] classes = new Classe[50];
	int nbClasses = 0;
	
	public Ecole(String nom, Humain directeur) {
		super();
		this.nom = nom;
		this.directeur = directeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Humain getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Humain directeur) {
		this.directeur = directeur;
	}
	
	
	public void ajouterClasse(Classe classe) {
		classes[nbClasses] = classe;
		nbClasses ++;
	}
	
	public void niveauSuperieurEcole() throws Exception {
		for (int i=0;i<nbClasses;i++) classes[i].niveauSuperieurClasse();
	}
}