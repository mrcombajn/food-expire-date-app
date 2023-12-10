package pl.expiredateapp.dtos;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class ProductDto implements Serializable {

    private final int id;

    private final String name;

}
