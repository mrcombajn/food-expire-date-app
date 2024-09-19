package pl.expiredateapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.dtos.products.ProductDto;
import pl.expiredateapp.entities.Product;
import pl.expiredateapp.entities.exceptions.EntityNotFoundException;
import pl.expiredateapp.services.ProductService;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

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

    private static final ArrayList<ProductDto> DTO = new ArrayList<>();

    @BeforeAll
    static void initialize() {
        DTO.add(new ProductDto(new Product(1, "Chipsy", "Chipsy ziemniaczane", "123456789", LocalDate.of(2024, Month.JUNE, 28))));
        DTO.add(new ProductDto(new Product(1, "Ser", "ser", "123456789", LocalDate.of(2023, Month.DECEMBER, 23))));
        DTO.add(new ProductDto(new Product(1, "Chleb tostowy", "Chleb żytni", "123456789", LocalDate.of(2024, Month.FEBRUARY, 3))));
    }


    @Test
    void checkIfEndpointReturnsAllProductDto() throws Exception {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());

        //Mockito.when -> look at static import
        when(productService.getAllProducts())
                .thenReturn(DTO);

        //MockMvcRequestBuilders.get -> look at static import
        //MockMvcResultHandlers.print -> look at static import
        //MockMvcResultMatchers.status -> look at static import, we expect that the test return 200 status code
        this.mockMvc
                .perform(get("/api/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(OBJECT_MAPPER.writeValueAsString(DTO)));
    }

    @Test
    void checkIfGetElementByIdReturnsExceptionWhenInvalidId() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(1);
        productRequest.setBarcode("123456789");

        when(productService.getProductById(productRequest))
                .thenThrow(new EntityNotFoundException("Cannot find product with given id!"));

        this.mockMvc
                .perform(get("/api/product/url")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productRequest)))
                .andExpect(status().is4xxClientError());
    }

    private String asJsonString(Object object) throws RuntimeException {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }
}