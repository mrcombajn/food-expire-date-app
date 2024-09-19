/**
 * pl.expiredateapp.repository is a package for repository classes.
 */
package pl.expiredateapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.expiredateapp.repository.entity.recipe.Recipe;

/**
 * Recipe Repository class.
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
