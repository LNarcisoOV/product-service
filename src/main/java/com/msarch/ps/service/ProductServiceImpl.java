package com.msarch.ps.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import com.msarch.ps.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product save(ProductDTO productDTO){
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getValue());
        return productRepository.save(product);
    }

    @Override
    public Product get(Long productId) {
        return Optional.of(productRepository.findById(productId)).orElseThrow(() -> new NoResultException(String.format("Product with id %d not found.", productId)));
    }

    @Override
    public Product updateByPatch(Product product, JSonPatch jSonPatch) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                .setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));

        JsonNode jsonNodeProduct = objectMapper.convertValue(product, JsonNode.class);
        JSonNode jsonNode = jSonPatch.apply(jsonNodeProduct);
        Product productUpdate = objectMapper.treeToValue(patchJsonNode, Product.class);
        return save(productUpdate);
    }

    @Override
    public void delete(Long productId) {
        Product product = get(productId);
        productRepository.delete(product);
    }
}
