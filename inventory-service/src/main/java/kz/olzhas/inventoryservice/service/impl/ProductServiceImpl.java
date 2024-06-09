package kz.olzhas.inventoryservice.service.impl;


import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.ProductMapper;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.SupplierProductDtoMapper;
import kz.olzhas.inventoryservice.model.Product;
import kz.olzhas.inventoryservice.repository.ProductRepository;
import kz.olzhas.inventoryservice.repository.SupplierRepository;
import kz.olzhas.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ProductMapper productMapper;
    private final SupplierProductDtoMapper supplierProductDtoMapper;

    @Override
    public void save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Long id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            product.setExpirationDate(productDto.getExpirationDate());

            productRepository.saveAndFlush(product);
        }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public ProductDto getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::toDto).orElse(null);
    }
}
