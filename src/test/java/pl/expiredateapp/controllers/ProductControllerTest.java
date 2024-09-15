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
import java.util.Calendar;
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

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final ArrayList<ProductDto> PRODUCT_DTOS = new ArrayList<>();

    @BeforeAll
    static void initialize() {
        PRODUCT_DTOS.add(new ProductDto(new Product(1, "Chipsy", "Chipsy ziemniaczane", "123456789", new Date(2024, Calendar.JUNE, 28))));
        PRODUCT_DTOS.add(new ProductDto(new Product(1, "Ser", "ser", "123456789", new Date(2023, Calendar.DECEMBER, 23))));
        PRODUCT_DTOS.add(new ProductDto(new Product(1, "Chleb tostowy", "Chleb żytni", "123456789", new Date(2024, Calendar.FEBRUARY, 3))));
    }


    @Test
    void checkIfEndpointReturnsAllProductDtos() throws Exception {
        //Mockito.when -> look at static import
        when(productService.getAllProducts())
                .thenReturn(PRODUCT_DTOS);

        //MockMvcRequestBuilders.get -> look at static import
        //MockMvcResultHandlers.print -> look at static import
        //MockMvcResultMatchers.status -> look at static import, we expect that the test return 200 status code
        this.mockMvc
                .perform(get("/api/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(OBJECT_MAPPER.writeValueAsString(PRODUCT_DTOS)));
    }
}