package structure;
import personnes.*;

public class Ecole {
	private String nom;
	private Instituteur directeur;
	private Classe[] classes = new Classe[50];
	private int nbClasses = 0;
	
	
	public Ecole(String nom, Instituteur directeur) {
		this.nom = nom;
		this.directeur = directeur;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Instituteur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Instituteur directeur) {
		this.directeur = directeur;
	}
	
	
	public void ajouterClasse(Classe classe) {
		classes[nbClasses] = classe;
		nbClasses ++;
	}
	
	public int getNbEleves() {
		int total = 0;
		for (int i = 0;i<nbClasses;i++) total += classes[i].getNbEleves();
		return total;
	}
	
	private void viderEcole() {
		classes = new Classe[50];
		nbClasses = 0;
	}
	
	private boolean classePossible(Eleve eleve) {
		boolean possible = false;
		int i = 0;
		while (!possible && i<nbClasses) {
			Classe classe = classes[i];
			possible = classe.ajoutElevePossible(eleve);
			i ++;
		}
		return possible;
	}
	
	private void creerNouvelleClasse(Eleve eleve) {
		Classe nouvelleClasse  = new Classe(eleve.getNiveau());
		nouvelleClasse.ajouterEleve(eleve);
		ajouterClasse(nouvelleClasse);
	}
	
	private boolean ajouterRapprochement(Eleve eleve) {
		boolean ajout = false;
		int i = 0;
		while (!ajout && i < nbClasses) {
			Classe classe = classes[i];
			if (classe.estDansRapprochement(eleve) && classe.ajoutElevePossible(eleve)) {
				classe.ajouterEleve(eleve);
				ajout = true;
			}
			i ++;
		}
		return ajout;
	}
	
	private float calculDifferenceMoyenne(Classe classe,Eleve eleve) {
		float[] moyennes = classe.calculerMoyennes();
		float differenceNiveau = Math.abs(moyennes[0] - eleve.getNiveauScolaire());
		float differenceComportement = Math.abs(moyennes[1] - eleve.getNiveauComportement());
		return differenceNiveau + differenceComportement;
	}
	
	private void ajouterSelonMoyenne(Eleve eleve) {
		float differenceMoyenneMax = 0;
		int indexDifferenceMax = 0;
		for (int i=0;i<nbClasses;i++) {
			Classe classe = classes[i];
			if (classe.ajoutElevePossible(eleve)) {
				float sommeDifference = calculDifferenceMoyenne(classe, eleve);
				if (sommeDifference > differenceMoyenneMax) {
					differenceMoyenneMax = sommeDifference;
					indexDifferenceMax = i;
				}
			}
		}
		classes[indexDifferenceMax].ajouterEleve(eleve);
	}
	
	private void ajouterEleve(Eleve eleve) {
		if (!classePossible(eleve)) {
			creerNouvelleClasse(eleve);
		} else {
			if (!ajouterRapprochement(eleve)) {
				ajouterSelonMoyenne(eleve);
			}
		}
	}
	
	public void genererEcole(Eleve[] listeEleves) {
		int nbEleves = listeEleves.length;
		viderEcole();
		for (int i = 0;i<nbEleves;i++) {
			Eleve eleve = listeEleves[i];
			ajouterEleve(eleve);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		for (int i = 0;i<nbClasses;i++) {
			message.append(classes[i].toString());
			message.append("\n");
		}
		return message.toString();
	}
}