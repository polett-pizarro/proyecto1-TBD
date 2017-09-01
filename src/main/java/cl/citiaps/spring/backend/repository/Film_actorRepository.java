package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Film_actor;

public interface Film_actorRepository extends PagingAndSortingRepository<Film_actor, Integer> {
	

}