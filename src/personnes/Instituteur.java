package personnes;

public class Instituteur extends Humain {
	int anciennete;

	public Instituteur(String nom, int anciennete) {
		super(nom);
		this.anciennete = anciennete;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
	
}
