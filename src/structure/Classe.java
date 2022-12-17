package structure;

import personnes.Eleve;
import personnes.Instituteur;

public class Classe {
	Niveau niveau;
	Eleve[] eleves = new Eleve[50];
	int nbEleves = 0;
	Instituteur instituteur;
	
	public Classe(Niveau niveau,Instituteur instituteur) {
		super();
		this.niveau = niveau;
		this.instituteur = instituteur;
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
	
	private boolean estDansEleves(Eleve eleve) {
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
	
}
