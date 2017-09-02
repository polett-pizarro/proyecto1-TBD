package cl.citiaps.spring.backend.entities;

//import org.hibernate.mapping.set;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/*import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
*/


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
/*
	@Column(name="lenguage_id",nullable=false)
	private int languageId;
	
	@Column (name="original_language_id")
	private int originalLanguageId;
	*/
	
	
	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=255)
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="release_year", length=4)
	private String releaseYear;
	
	@Column(name="rental_duration", nullable=false )
	private int rentalDuration;
	
	@Column(name="rental_rate",nullable=false )
	private float rentalRate;
	
	@Column(name="length")
	private int length;
	
	@Column(name="replacement_cost", nullable=false)
	private float replacementCost;
	
	@Column(name="rating")
	private String rating;

	@Column(name="special_features")
	private String specialFeatures;
	
	@Column (name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	
	//@ElementCollection
	//private Set<Film_actor> actorFilms = new HashSet<Film_actor>();
    
	
	/*@ManyToOne (fetch=FetchType.LAZY) 
	@JoinColumn(name="language_id",nullable=false)
	public int getlenguaje(){return this.languageId;}
	 
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="original_language_id")
	public int getOriginallenguaje(){return this.originalLanguajeId;}
	*/
    
    /*@OneToMany(mappedBy = "film")
    public Set<Film_actor> getActorFilms() {
        return actorFilms;
    }*/
	
	
	
	public Film() {
    }

	
	
	/*public Set<Film_actor> getActorFilms() {
		return actorFilms;
	}*/

	


	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public String getRating() {
		return rating;
	}

	public float getReplacementCost() {
		return replacementCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
    public int getFilmId() {
        return filmId;
    }
    
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }
    
    public float getRentalRate() {
		return rentalRate;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }
    
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }
    
    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

	public int getLength() {
		return length;
	}
	
	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="films")
	private Set<Actor> actors=new HashSet<Actor>();
	
	public Set<Actor> getActors() {
		return this.actors;
	}

   
   
}