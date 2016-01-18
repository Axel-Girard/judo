package base;

import java.util.ArrayList;

import beans.Competition;
import beans.Personne;

public class Base {
	private static ArrayList<Personne> personnes = new ArrayList<Personne>();
	private static ArrayList<Competition> competitions = new ArrayList<Competition>();

	protected static void ajouter() {
		if (personnes.size() < 1) {
			Personne admin = new Personne(0, "root", "toor", "noir");
			admin.setAdmin(true);
			admin.setValider(true);
			personnes.add(admin);
		}
		if (competitions.size() < 3) {
			Competition c = new Competition("01/01/16",
					"103, rue Pompidou, Orléan");
			c.addCompetiteurs(0);
			c.addVainqueur(0);
			competitions.add(c);
			competitions.add(new Competition("29/02/48",
					"18, rue des papillons, Nantes"));
			competitions.add(new Competition("24/07/16",
					"24, avenu de la rébublique, Paris"));
		}
	}

	public static Personne findPersonne(int id) {
		Personne p = null;
		ajouter();
		for (Personne pers : personnes) {
			if (pers.getId() == id) {
				p = pers;
			}
		}
		return p;
	}

	public static Personne findPersonne(String pseudo, String mdp) {
		Personne p = null;
		ajouter();
		for (Personne pers : personnes) {
			if (pers.getPseudo().equals(pseudo) && pers.getMdp().equals(mdp)) {
				p = pers;
			}
		}
		return p;
	}

	public static ArrayList<Personne> findInvalidPersonne() {
		ArrayList<Personne> p = new ArrayList<Personne>();
		ajouter();
		for (Personne pers : personnes) {
			if (!pers.isValider()) {
				p.add(pers);
			}
		}
		return p;
	}

	public static boolean isJudoka(int id) {
		boolean isJudoka = false;
		if (findPersonne(id) != null) {
			isJudoka = true;
		}
		return isJudoka;
	}

	public static boolean isAdmin(int id) {
		boolean isAdmin = false;
		if (findPersonne(id) != null) {
			isAdmin = true;
		}
		return isAdmin;
	}

	public static ArrayList<Competition> getCompetitions() {
		ajouter();
		return competitions;
	}

	public static void addCompetitions(Competition c) {
		ajouter();
		competitions.add(c);
	}

	public static void add(Personne p) {
		personnes.add(p);
	}

	public static void removePersonne(Personne p) {
		personnes.remove(p);
	}

	public static Competition findCompet(String date, String ville) {
		ajouter();
		Competition c = null;
		for (int i = 0; i < getCompetitions().size(); i++) {
			Competition comp = getCompetitions().get(i);
			if (comp.getDate().equals(date) && comp.getAdresse().equals(ville)) {
				c = comp;
			}
		}
		return c;
	}

	public static ArrayList<Personne> getPersonnes() {
		return personnes;
	}
	public static void setPersonnes(ArrayList<Personne> personnes) {
		Base.personnes = personnes;
	}
}
