package personnes;

import structure.Niveau;

public class Eleve extends Humain {
	private int niveauScolaire;
	private int niveauComportement;
	private Niveau niveau;
	private Eleve[] eloignement = new Eleve[100];
	private Eleve[] rapprochement = new Eleve[100];
	private int nbEloignement = 0;
	private int nbRapprochement = 0;
	
	
	public Eleve(String nom,Niveau niveau,int niveauScolaire, int niveauComportement) {
		super(nom);
		this.niveau = niveau;
		this.niveauScolaire = niveauScolaire;
		this.niveauComportement = niveauComportement;
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

	public Niveau getNiveau() {
		return niveau;
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
		if ((!estDansEloignement(eleve)) && (eleve.getNiveau() == this.niveau)){
		eloignement[nbEloignement] = eleve;
		nbEloignement ++;
		eleve.ajouterEloignement(this);
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
		if ((!estDansRapprochement(eleve)) && (eleve.getNiveau() == this.niveau)) {
		rapprochement[nbRapprochement] = eleve;
		nbRapprochement ++;
		eleve.ajouterRapprochement(this);
		}
	}
	
	public void niveauSuperieur() throws Exception {
		switch (this.niveau) {
			case CP : this.niveau = Niveau.CE1; 
				break;
			case CE1 : this.niveau = Niveau.CE2; 
				break;
			case CE2 : this.niveau = Niveau.CM1; 
				break;
			case CM1 : this.niveau = Niveau.CM2; 
				break;
			default : throw new Exception("Erreur pas de niveau supérieur");
		}
	}
	
}
