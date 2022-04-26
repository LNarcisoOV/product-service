package com.msarch.ps.model.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductSerialization extends JsonSerializer<Product> {

    private final ModelMapper modelMapper;

    public ProductSerialization(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        jsonGenerator.writeObject(productDTO);
    }
}
