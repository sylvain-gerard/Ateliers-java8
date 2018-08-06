package dma;

public class Voiture {
	public static final double TAUX_TVA=20.0;
	
	private String nom;
	private String marque;
	private double prix;
	private int vitesseMax;	
	
	public Voiture(String nom, String marque, double prix, int vitesseMax) {
		super();
		this.nom = nom;
		this.marque = marque;
		this.prix = prix;
		this.vitesseMax = vitesseMax;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}	
	public String getMarque() {
		return marque;
	}	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getVitesseMax() {
		return vitesseMax;
	}
	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	public Voiture augmentation(float pc){
		prix = prix * (1 + pc/100);
		return this;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", marque=" + marque + ", prix=" + prix
				+ ", vitesse=" + vitesseMax;
	}

}
