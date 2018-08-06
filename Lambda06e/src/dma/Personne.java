package dma;

public class Personne implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	private int age;

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

	public String toString()
	{
		return "Nom    : " + nom+" Prenom : " +
				prenom+" Age: " + age+'\n';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
} 
