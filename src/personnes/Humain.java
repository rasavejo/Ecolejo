package personnes;

public class Humain {
	String nom;
	Niveau niveau;
	int numClasse;
	
	
	public Humain(String nom, Niveau classe,int numClasse) {
		super();
		this.nom = nom;
		this.niveau = classe;
		this.numClasse = numClasse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}
