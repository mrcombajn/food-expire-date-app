package pl.expiredateapp.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import pl.expiredateapp.entities.Recipe;

@Repository
public interface RecipesRepository extends CrudRepository<Recipe, Long> {
}
