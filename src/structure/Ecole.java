package structure;
import personnes.*;

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
	
	private void viderEcole() {
		classes = new Classe[50];
		nbClasses = 0;
	}
	
	private boolean classePossible(Eleve eleve) {
		boolean possible = false;
		int i = 0;
		while (!possible && i<nbClasses) {
			Niveau niveauEleve = eleve.getNiveau();
			Classe classe = classes[i];
			possible =  (niveauEleve == classe.getNiveauPrincipal()) || (niveauEleve == classe.getNiveauSecondaire());
			possible = possible && classe.estDansEloignement(eleve);
			i ++;
		}
		return possible;
	}
	
	private void creerNouvelleClasse(Eleve eleve) {
		classes[nbClasses] = new Classe(eleve.getNiveau());
		classes[nbClasses].ajouterEleve(eleve);
		nbClasses ++;
	}
	
	private boolean ajouterRapprochement(Eleve eleve) {
		boolean ajout = false;
		int i = 0;
		while (!ajout && i < nbClasses) {
			Classe classe = classes[i];
			if (classe.estDansRapprochement(eleve)) {
				classe.ajouterEleve(eleve);
				ajout = true;
			}
			i ++;
		}
		return ajout;
	}
	
	private void ajouterMoyenne(Eleve eleve) {
		float differenceMoyenneMax = 0;
		int indexDifferenceMax = 0;
		for (int i=0;i<nbClasses;i++) {
			Classe classe = classes[i];
			float[] moyennes = classe.calculerMoyennes();
			float differenceNiveau = Math.abs(moyennes[0] - eleve.getNiveauScolaire());
			float differenceComportement = Math.abs(moyennes[1] - eleve.getNiveauComportement());
			float sommeDifference = differenceNiveau + differenceComportement;
			if (sommeDifference > differenceMoyenneMax) {
				differenceMoyenneMax = sommeDifference;
				indexDifferenceMax = i;
			}
		}
		classes[indexDifferenceMax].ajouterEleve(eleve);
	}
	
	private void ajouterEleve(Eleve eleve) {
		if (!classePossible(eleve)) {
			creerNouvelleClasse(eleve);
		} else {
			if (!ajouterRapprochement(eleve)) {
				ajouterMoyenne(eleve);
			}
		}
	}
	
	public void genererEcole(Eleve[] listeEleves,int nbEleves) {
		viderEcole();
		for (int i = 0;i<nbEleves;i++) {
			Eleve eleve = listeEleves[i];
			ajouterEleve(eleve);
		}
	}
}