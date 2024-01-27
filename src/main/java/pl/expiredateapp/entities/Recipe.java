package pl.expiredateapp.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import lombok.*;
import pl.expiredateapp.dtos.recipes.RecipeDto;

import javax.xml.validation.Schema;
import java.util.ArrayList;
import java.util.List;

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

    @SneakyThrows
    public Recipe(RecipeDto recipeDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipeDto.getName();
        this.ingredients = objectMapper.writeValueAsString(recipeDto.getIngredients());
        this.steps = objectMapper.writeValueAsString(recipeDto.getSteps());
        this.description = recipeDto.getDescription();
    }
}
