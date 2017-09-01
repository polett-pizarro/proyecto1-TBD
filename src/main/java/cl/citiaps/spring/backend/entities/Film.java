package cl.citiaps.spring.backend.entities;

//import org.hibernate.mapping.set;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT a FROM Film a")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	private int languageId;
	private int originalLanguajeId;
	
	@ElementCollection
	private Set<Film_actor> actorFilms = new HashSet<Film_actor>();
	
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
	
    public Film() {
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
    public float getRentalRate() {
        return rentalRate;
    }
    
    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public float getReplacementCost() {
        return replacementCost;
    }
    
    public void setReplacementCost(float replacementCost) {
        this.replacementCost = replacementCost;
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getSpecialFeatures() {
        return specialFeatures;
    }
    
    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
	
    
	@ManyToOne (fetch=FetchType.LAZY) 
	@JoinColumn(name="language_id",nullable=false)
	public int getlenguaje(){return this.languageId;}
	 
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="original_languaje_id")
	public int getOriginallenguaje(){return this.originalLanguajeId;}
	
    
    @OneToMany(mappedBy = "film")
    public Set<Film_actor> getActorFilms() {
        return actorFilms;
    }
 
    public void setActorFilms(Set<Film_actor> films) {
        this.actorFilms = films;
    }
     
    public void addActorFilm(Film_actor actorFilm) {
        this.actorFilms.add(actorFilm);
    }

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}