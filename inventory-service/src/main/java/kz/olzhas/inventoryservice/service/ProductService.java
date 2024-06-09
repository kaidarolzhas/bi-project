package kz.olzhas.inventoryservice.service;


import kz.olzhas.inventoryservice.dto.product.ProductDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);
    void update(Long id, ProductDto productDto);
    void deleteById(Long id);
    List<ProductDto> getAll();
    ProductDto getById(Long id);


}
