package pl.expiredateapp.repository.entity.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import pl.expiredateapp.controllers.dto.recipe.RecipeDto;
import pl.expiredateapp.repository.entity.product.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    /**
     * Recipe entity ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Recipe entity name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Recipe entity ingredients.
     */
    @Column(name = "ingredients")
    private String ingredients;

    /**
     * Recipe entity description.
     */
    @Column(name = "description")
    private String description;

    /**
     * Recipe entity steps.
     */
    @Column(name = "steps")
    private String steps;

    /**
     * Recipe entity products.
     */
    @ManyToMany
    @JoinTable(
            name = "recipes_product",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    /**
     * Recipe constructor.
     * @param recipeDto RecipeDto from endpoint.
     */
    @SneakyThrows
    public Recipe(final RecipeDto recipeDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipeDto.getName();
        this.ingredients = objectMapper
                .writeValueAsString(recipeDto.getIngredients());
        this.steps = objectMapper
                .writeValueAsString(recipeDto.getSteps());
        this.description = recipeDto.getDescription();
    }

}
