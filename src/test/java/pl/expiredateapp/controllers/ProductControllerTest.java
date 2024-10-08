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
import pl.expiredateapp.controllers.dto.product.ProductDto;
import pl.expiredateapp.services.exceptions.EntityNotFoundException;
import pl.expiredateapp.services.ProductService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@DirtiesContext
class ProductControllerTest {

    /**
     * Mock MVC.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Mocked Product service.
     */
    @MockBean
    private ProductService productService;

    /**
     * Object mapper for objects serialization/deserialization.
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * List of Data Transfer Objects expected from response.
     */
    private static final ArrayList<ProductDto> DTO = new ArrayList<>();

    /**
     * Expected message for EntityNotFoundException.
     */
    private static final String MESSAGE = "Cannot find product with given id!";

    @BeforeAll
    static void initialize() {
        loadDtoFromFile();
    }

    @Test
    void checkIfEndpointReturnsAllProductDto() throws Exception {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());

        //Mockito.when -> look at static import
        when(productService.getAllProducts())
                .thenReturn(DTO);

        //MockMvcRequestBuilders.get -> look at static import
        //MockMvcResultHandlers.print -> look at static import
        //MockMvcResultMatchers.status ->
        // look at static import, we expect that the test return 200 status code
        this.mockMvc
                .perform(get("/api/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        content().json(OBJECT_MAPPER.writeValueAsString(DTO)));
    }

    @Test
    void checkIf4xxStatusIsReturnedWhenDbNotCotainsItems() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(List.of());

        this.mockMvc
                .perform(get("/api/products"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void checkIfGetElementByIdReturnsExceptionWhenInvalidId() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(1);
        productRequest.setBarcode("123456789");

        when(productService.getProductById(productRequest))
            .thenThrow(
                new EntityNotFoundException(MESSAGE));

        this.mockMvc
                .perform(get("/api/product/url")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(productRequest)))
                .andExpect(status().is4xxClientError());
    }

    private String asJsonString(final Object object) throws RuntimeException {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void loadDtoFromFile() {
        String url = Objects.requireNonNull(
                ProductControllerTest.class
                        .getClassLoader()
                        .getResource("databaseObjects.json"))
                .getFile();

        try (InputStream inputStream = new FileInputStream(url)) {
            var arrayList = OBJECT_MAPPER
                    .readValue(inputStream, ArrayList.class);

            for (var object : arrayList) {
                DTO.add(
                    OBJECT_MAPPER.convertValue(object, ProductDto.class));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
