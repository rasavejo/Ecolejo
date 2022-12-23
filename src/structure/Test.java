package structure;
import personnes.*;
import java.util.Random;


public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Eleve[] listeEleves = new Eleve[500];
		Instituteur vero = new Instituteur("Veronique", 15);
		Random rand = new Random();
		
		for (int i=0;i<500;i++) {
			Eleve eleve = new Eleve(String.valueOf(i),Niveau.CP,rand.nextInt(11),rand.nextInt(11));
			for (int j=1;j*100<i;j++) eleve.niveauSuperieur();
			listeEleves[i] = eleve;
		}
		
		Ecole ecole = new Ecole("super ecole",vero);
		ecole.genererEcole(listeEleves);
		System.out.println(ecole);
	}

}
