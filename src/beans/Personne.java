package beans;

public class Personne {
	private int id;
	private String pseudo;
	private String mdp;
	private String ceinture;
	private boolean admin;
	private boolean valider;
	
	public Personne(int id, String pseudo, String mdp, String ceinture) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.ceinture = ceinture;
		valider = false;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getCeinture() {
		return ceinture;
	}
	public void setCeinture(String ceinture) {
		this.ceinture = ceinture;
	}
	public boolean isValider() {
		return valider;
	}
	public void setValider(boolean valider) {
		this.valider = valider;
	}
}
