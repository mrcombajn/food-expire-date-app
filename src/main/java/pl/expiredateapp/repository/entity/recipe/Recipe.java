/**
 * pl.expiredateapp.repository.entity.recipe is package for product entity definitions.
 */
package pl.expiredateapp.repository.entity.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import pl.expiredateapp.controllers.dto.recipe.RecipeDto;
import pl.expiredateapp.repository.entity.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipe entity class.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="ingredients")
    private String ingredients;

    @Column(name="description")
    private String description;

    @Column(name="steps")
    private String steps;

    @ManyToMany
    @JoinTable(
            name = "recipes_product",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products = new ArrayList<>();

    /**
     * Recipe constructor.
     * @param recipeDto RecipeDto from endpoint.
     */
    @SneakyThrows
    public Recipe(RecipeDto recipeDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipeDto.getName();
        this.ingredients = objectMapper.writeValueAsString(recipeDto.getIngredients());
        this.steps = objectMapper.writeValueAsString(recipeDto.getSteps());
        this.description = recipeDto.getDescription();
    }
}
