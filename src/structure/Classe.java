package structure;

import personnes.Eleve;
import personnes.Instituteur;

public class Classe {
	Niveau niveauPrincipal;
	Niveau niveauSecondaire; // Pour les classes à double niveau
	Eleve[] eleves = new Eleve[50];
	int nbEleves = 0;
	Instituteur instituteur;
	
	public Classe(Niveau niveau) {
		super();
		this.niveauPrincipal = niveau;
	}
	
	public void ajouterNiveau(Niveau niveau) {
		niveauSecondaire = niveau;
	}
	
	public boolean estDansEloignement(Eleve eleve) {
		boolean dedans = false;
		int i = 0;
		while (!dedans && i<nbEleves) {
			int j = 0;
			while (!dedans && j< eleves[i].getNbEloignement()) {
				if (eleves[i].estDansEloignement(eleve)) dedans = true;
				j ++;
			}
			i ++;
		}
		return dedans;
	}
	
	public boolean estDansRapprochement(Eleve eleve) {
		boolean dedans = false;
		int i = 0;
		while (!dedans && i<nbEleves) {
			int j = 0;
			while (!dedans && j< eleves[i].getNbRapprochement()) {
				if (eleves[i].estDansRapprochement(eleve)) dedans = true;
				j ++;
			}
			i ++;
		}
		return dedans;
	}
	
	public boolean estDansEleves(Eleve eleve) {
		boolean dedans = false;
		int i = 0;
		while (!dedans && i<nbEleves) {
			if (eleves[i] == eleve) dedans = true;
			i ++;
		}
		return dedans;
	}
	
	public void ajouterEleve(Eleve eleve) {
		eleves[nbEleves] = eleve;
		nbEleves ++;
	}
	
	public void niveauSuperieurClasse() throws Exception {
		for (int i=0;i<nbEleves;i++) eleves[i].niveauSuperieur();
	}
	
	public float[] calculerMoyennes() {
		float[] moyennes = new float[2];
		float sommeNiveau = 0;
		float sommeComportement = 0;
		for (int i = 0;i<nbEleves;i++) {
			Eleve eleve = eleves[i];
			sommeNiveau += eleve.getNiveauScolaire();
			sommeComportement += eleve.getNiveauComportement();
		}
		moyennes[0] = sommeNiveau / nbEleves;
		moyennes[1] = sommeComportement / nbEleves;
		return moyennes;
	}

	public Niveau getNiveauPrincipal() {
		return niveauPrincipal;
	}

	public Niveau getNiveauSecondaire() {
		return niveauSecondaire;
	}

	public Instituteur getInstituteur() {
		return instituteur;
	}

	public void setInstituteur(Instituteur instituteur) {
		this.instituteur = instituteur;
	}
	
}
