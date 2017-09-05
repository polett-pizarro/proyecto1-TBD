package cl.citiaps.spring.backend.entities;
 
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="actor")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor<Films> implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    @Column(name="actor_id", unique=true, nullable=false)
    private int actorId;
 
    @Column(name="first_name", nullable=false, length=45)
    private String firstName;
 
    @Column(name="last_name", nullable=false, length=45)
    private String lastName;
 
    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;
   
   
   
    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name="film_actor",
        joinColumns=@JoinColumn(name="actor_id"),
        inverseJoinColumns=@JoinColumn(name="film_id"))
   
    private Set<Film> films=new HashSet<Film>();
 
    public Set<Film> getFilm() {
        return this.films;
    }
 
   
   
    public Actor() {
    }
   
   
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
   
    public int getActorId() {
        return this.actorId;
    }
 
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
   
    public String getFirstName() {
        return this.firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return this.lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
 
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
   
   
 
}