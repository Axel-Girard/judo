package beans;

import java.util.ArrayList;
import java.util.List;

import base.Base;

public class Competition {
	private List<Personne> competiteurs = new ArrayList<Personne>();
	private String date;
	private String adresse;
	private Personne vainqueur;
	
	public Competition( String date, String adresse) {
		super();
		this.date = date;
		this.adresse = adresse;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Personne> getCompetiteurs() {
		return competiteurs;
	}
	public void setCompetiteurs(List<Personne> competiteurs) {
		this.competiteurs = competiteurs;
	}
	public boolean addCompetiteurs(int id){
		boolean add = false;
		for(Personne pers: Base.getPersonnes()){
			if(pers.getId() == id){
				competiteurs.add(pers);
				add = true;
			}
		}
		return add;
	}
	public Personne getVainqueur() {
		return vainqueur;
	}
	public void setVainqueur(Personne vainqueur) {
		this.vainqueur = vainqueur;
	}
	public void addVainqueur(int id){
		for(Personne pers: Base.getPersonnes()){
			if(pers.getId() == id){
				vainqueur = pers;
			}
		}
	}
}
