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
@NamedQueries ({
	@NamedQuery(name="Film_actor.findAll", query="SELECT fa FROM Film_actor fa"),
	@NamedQuery(name="find all movies by actor by his id", query="SELECT f FROM Film f, Film_actor fa WHERE fa.actorId = :id AND f.filmId = fa.filmId"),
	@NamedQuery(name="find all actors by movie by his id", query="SELECT a FROM Actor a, Film_actor fa WHERE fa.filmId = :id AND a.actorId = fa.actorId")

})
public class Film_actor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@Id
	//private int filmActorId;
	
	@Id
	@Column(name="actor_id", nullable=false)
	private int actorId;
	
	@Id
	@Column(name="film_id", nullable=false)
	private int filmId;
	
	public Film_actor() {
	}
	
	/*public int getFilmActorId() {
        return filmActorId;
    }
    
    public void setFilmActorId(int filmActorId) {
        this.filmActorId = filmId;
	    }
	*/
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
