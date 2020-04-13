package projet;

/**
 * on utilise la date du package SQL car on n'a pas besoin de l'heure exacte, le jour nous suffit
 */
import java.sql.Date;
import java.util.Collection;

public class Oeuvre {
	private String cote;
	private Collection<String> auteurs;
	private String titre;
	private Date dateDeParution;
	private Collection<String> tags;

	public Oeuvre(String cote, Collection<String> auteurs, String titre, Date dateDeParution, Collection<String> tags) {
		this.cote = cote;
		this.auteurs = auteurs;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
		this.tags = tags;
	}
}