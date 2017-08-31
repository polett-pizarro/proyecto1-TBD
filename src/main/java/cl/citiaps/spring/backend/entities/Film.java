package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT a FROM Film a")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int actorId;

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


	public int getActorId() {
		return actorId;
	}


	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	public String getReleaseYear() {
		return releaseYear;
	}


	public int getRentalDuration() {
		return rentalDuration;
	}


	public float getRentalRate() {
		return rentalRate;
	}


	public int getLength() {
		return length;
	}


	public float getReplacementCost() {
		return replacementCost;
	}


	public String getRating() {
		return rating;
	}


	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	


}