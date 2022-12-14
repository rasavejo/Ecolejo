package personnes;

import structure.Niveau;

public class Eleve extends Humain {
	int niveauScolaire;
	int niveauComportement;
	Niveau niveau;
	Eleve[] eloignement = new Eleve[20];
	Eleve[] rapprochement = new Eleve[20];
	int nbEloignement = 0;
	int nbRapprochement = 0;
	
	
	public Eleve(String nom,Niveau niveau,int niveauScolaire, int niveauComportement) {
		super(nom);
		this.niveau = niveau;
		this.niveauScolaire = niveauScolaire;
		this.niveauComportement = niveauComportement;
	}
	
	public boolean estDansEloignement(Eleve eleve) {
		boolean dedans = false;
		int i = 0;
		while (!dedans && i<nbEloignement) {
			if (eloignement[i] == eleve) dedans = true;
			i ++;
		}
		return dedans;
	}
	
	public void ajouterEloignement(Eleve eleve) {
		if (!estDansEloignement(eleve)) {
		eloignement[nbEloignement] = eleve;
		nbEloignement ++;
		}
	}
	
	public boolean estDansRapprochement(Eleve eleve) {
		boolean dedans = false;
		int i = 0;
		while (!dedans && i<nbRapprochement) {
			if (rapprochement[i] == eleve) dedans = true;
			i ++;
		}
		return dedans;
	}
	
	public void ajouterRapprochement(Eleve eleve) {
		if (!estDansRapprochement(eleve)) {
		rapprochement[nbRapprochement] = eleve;
		nbRapprochement ++;
		}
	}

	public int getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(int niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

	public int getNiveauComportement() {
		return niveauComportement;
	}

	public void setNiveauComportement(int niveauComportement) {
		this.niveauComportement = niveauComportement;
	}

	public int getNbEloignement() {
		return nbEloignement;
	}

	public int getNbRapprochement() {
		return nbRapprochement;
	}
}
