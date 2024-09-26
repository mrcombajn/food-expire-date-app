package pl.expiredateapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.expiredateapp.repository.entity.recipe.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
