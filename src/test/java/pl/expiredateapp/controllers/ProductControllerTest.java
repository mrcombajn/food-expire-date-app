package pl.expiredateapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import pl.expiredateapp.dtos.products.ProductDto;
import pl.expiredateapp.entities.Product;
import pl.expiredateapp.services.ProductService;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@DirtiesContext
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static ArrayList<ProductDto> productDtos = new ArrayList<>();

    @BeforeAll
    static void initialize() {
        productDtos.add(new ProductDto(new Product(1, "Chipsy", "Chipsy ziemniaczane", "123456789", new Date(2024, 5, 28))));
        productDtos.add(new ProductDto(new Product(1, "Ser", "ser", "123456789", new Date(2023, 11, 23))));
        productDtos.add(new ProductDto(new Product(1, "Chleb tostowy", "Chleb żytni", "123456789", new Date(2024, 1, 3))));
    }


    @Test
    void checkIfEndpointReturnsAllProductDtos() throws Exception {
        //Mockito.when -> look at static import
        when(productService.getAllProducts())
                .thenReturn(productDtos);

        //MockMvcRequestBuilders.get -> look at static import
        //MockMvcResultHandlers.print -> look at static import
        //MockMvcResultMatchers.status -> look at static import, we expect that the test return 200 status code
        this.mockMvc
                .perform(get("/product"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDtos)));
    }
}