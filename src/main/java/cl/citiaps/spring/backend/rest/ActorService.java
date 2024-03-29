package cl.citiaps.spring.backend.rest;
 
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;

@CrossOrigin(origins = "http://localhost:8083")//se debe poner el puerto que ustedes usan en Vue;
@RestController  
@RequestMapping("/actors")
public class ActorService {
   
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmRepository filmRepository;
 
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorRepository.findAll();
    }
   
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable("id") Integer id) {
        return actorRepository.findOne(id);
    }
   
   
    @RequestMapping(value ="/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public Set<Film> findFilmActors(@PathVariable("id") Integer id) {
            return actorRepository.findOne(id).getFilm();
    }
 
   
   
   
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Actor create(@RequestBody Actor resource) {
         return actorRepository.save(resource);
    }
   
    @RequestMapping(value ="/{id}/films/{id2}" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String vincular(@PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        Actor actor = actorRepository.findOne(id);
        Film film = filmRepository.findOne(id2);
        if (actor != null && film != null){
            actor.getFilm().add(film);
            actorRepository.save(actor);
            return "yes";
        }
        else{
            return "no";
        }
         //return actorRepository.save(resource);
    }
 
     
}