package modele;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "numero")

@Entity
@Table(name = "pret")
public class Pret implements Serializable{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	Integer numero;
	
	@ManyToOne
    @JoinColumns({
        @JoinColumn(name="cote", referencedColumnName="cote"),
        @JoinColumn(name="numero_exemplaire", referencedColumnName="numero")
    })
	Exemplaire exemplaire;

	@JoinColumn(name = "numero_adherent")
	@ManyToOne
	Adherent adherent;

	@Column(name = "date_emprunt")
	LocalDateTime dateEmprunt;

	/**
	 * la date théorique de fin de pret (sera une durée sous forme d'Interval en SQL)
	 */
	@Column(name = "duree_theorique")
	Period duréeThéorique;

	/**
	 * date effective du rendu du pret
	 */
	@Column(name = "date_rendu")
	LocalDateTime dateRendu;

	public boolean aEteRendu() {
		return dateRendu != null;
	}

	public Pret(Adherent adherent, Exemplaire exemplaire, LocalDateTime dateEmprunt, Period duréeThéorique) {
		this(null, exemplaire, adherent, dateEmprunt, duréeThéorique, dateEmprunt);
	}

	@Override
	public String toString() {
		return "le livre " + getExemplaire() + " prete le " + getDateEmprunt() + " à " + getAdherent();
	}
}