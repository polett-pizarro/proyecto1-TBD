package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
/**
 * The persistent language for the actor database table.
 * 
 */
/*
@Entity
@Table(name="film_actor")
@NamedQuery(name="Film_actor.findAll", query="SELECT a FROM Film_actor a")
public class Film_actor implements Serializable {
	/*
	private static final long serialVersionUID = 1L;
	
	private Actor actorId;
	private Film FilmId;

	@Id
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="actor_id", nullable=false)
	public Actor getActorId(){return this.actorId;}

	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="film_id", nullable=false)
	public Film getFilmId(){return this.FilmId;}

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Film_actor() {
	}
	
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
}
	*/
