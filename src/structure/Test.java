package structure;
import personnes.*;
import java.util.Random;


public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Instituteur vero = new Instituteur("Veronique", 15);
		Eleve[] listeEleves = new Eleve[999];
		Random rand = new Random();
        Eleve[] listeRapprochement = new Eleve[100];
        int nbRapprochement = 0;
		
		for (int i=0;i<997;i=i+3) {
			Eleve eleve = new Eleve(String.valueOf(i),Niveau.CP,rand.nextInt(11),rand.nextInt(11));
			Eleve eleve2 = new Eleve(String.valueOf(i+1),Niveau.CP,rand.nextInt(11),rand.nextInt(11));
			Eleve eleve3 = new Eleve(String.valueOf(i+2),Niveau.CP,rand.nextInt(11),rand.nextInt(11));
			
			eleve.ajouterEloignement(eleve2);
			eleve.ajouterEloignement(eleve3);
			eleve2.ajouterEloignement(eleve3);
			
            if (i % 12 == 0) {
                for (int j = 0;j<nbRapprochement;j++) {
                    eleve.ajouterRapprochement(listeRapprochement[j]);
                }
                listeRapprochement[nbRapprochement] = eleve;
                nbRapprochement ++;
            }
			
			for (int j=1;j*200<i;j++) {
				eleve.niveauSuperieur();
				eleve2.niveauSuperieur();
				eleve3.niveauSuperieur();
			}
			
			
			listeEleves[i] = eleve;
			listeEleves[i+1] = eleve2;
			listeEleves[i+2] = eleve3;
		}
		Ecole ecole = new Ecole("super ecole",vero);
		ecole.genererEcole(listeEleves);
		System.out.println(ecole);
	}

}
