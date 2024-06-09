package kz.olzhas.inventoryservice.controller;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.ProductMapper;
import kz.olzhas.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping()
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
