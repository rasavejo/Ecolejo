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
	
	public Niveau niveauSuperieur(Niveau niveau) throws Exception {
		switch (niveau) {
			case CP : return (Niveau.CE1);
			case CE1 : return (Niveau.CE2);
			case CE2 : return (Niveau.CM1);
			case CM1 : return (Niveau.CM2);
			default : throw new Exception("Erreur pas de niveau supérieur");
		}
}
}