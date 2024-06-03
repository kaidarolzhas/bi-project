package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.ProductMapper;
import kz.olzhas.inventoryservice.model.Product;
import kz.olzhas.inventoryservice.repository.ProductRepository;
import kz.olzhas.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        if (!productRepository.existsById(product.getId())) {
            productRepository.saveAndFlush(product);
        }
    }

    @Override
    public void update(Long id, ProductDto productDto) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setCategory(productDto.getCategory());
            product.get().setCount(productDto.getCount());
            product.get().setPrice(productDto.getPrice());
            product.get().setName(productDto.getName());
            product.get().setOrder(productDto.getOrder());
            product.get().setExpirationDate(productDto.getExpirationDate());
            productRepository.saveAndFlush(product.get());
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
}
