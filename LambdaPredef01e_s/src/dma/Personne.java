package dma;

public class Personne implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	private int age;
	private Voiture voiture;

	// constructeur par defaut
	public Personne()
	{
		nom="";
		prenom="";
		age=0;
	}
	public Personne(String n, String p)
	{
		nom=n;
		prenom=p;
		age=0;
	}
	public Personne(String n, String p, int a)
	{
		nom=n;
		prenom=p;
		age=a;
	}

	public Personne(Personne p)
	{
		nom=p.nom;
		prenom=p.prenom;
		age=p.age;
	}

	public void setNom(String n)
	{
		nom=n;
	}

	public void setPrenom(String p)
	{
		prenom=p;
	}

	public void setAge(int a)
	{
        age=a;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public int getAge()
	{
		return age;
	}

	public void print()
	{
		System.out.println("\nnom    : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("age    : " + age);
	}
	
	public void achete (Voiture voiture){
		this.voiture=voiture;
	}

	public String toString()
	{
		return "Nom    : " + nom+" Prenom : " +
				prenom+" Age: " + age+ " (Voiture: "+voiture+ ")\n";
	}

} 
