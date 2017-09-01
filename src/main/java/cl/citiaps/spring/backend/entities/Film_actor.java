package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
/**
 * The persistent language for the actor database table.
 * 
 */

@Entity
@Table(name="film_actor")
@NamedQuery(name="Film_actor.findAll", query="SELECT a FROM Film_actor a")
public class Film_actor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int filmActorId;

	private int actorId;
	private int filmId;
	
	public Film_actor() {
	}
	
	public int getFilmActorId() {
        return filmActorId;
    }
    
    public void setFilmActorId(int filmActorId) {
        this.filmActorId = filmId;
	    }
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
    public int getActor() {
        return actorId;
    }

	public void setActor(int actor) {
		 this.actorId = actor;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    public int getFilm() {
        return filmId;
    }
 
    public void setFilm(int film) {
        this.filmId = film;
    }
    
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

}
