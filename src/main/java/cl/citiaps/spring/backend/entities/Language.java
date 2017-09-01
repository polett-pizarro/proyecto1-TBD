package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.mapping.Set;

import java.sql.Timestamp;
/**
 * The persistent language for the actor database table.
 * 
 */
@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT a FROM Language a")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="language_id", unique=true, nullable=false)
	private int languageId;

	@Column(name="name", nullable=false, length=20)
	private String name;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	private Set films;

	@OneToMany (cascade=CascadeType.ALL , mappedBy="language")
	public Set getFilms(){return this.films;}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Language() {
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}