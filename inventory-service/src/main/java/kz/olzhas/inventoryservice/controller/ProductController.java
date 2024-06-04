package kz.olzhas.inventoryservice.controller;

import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/{supId}")
    public void createProduct(@PathVariable("supId") Long supId,@RequestBody ProductDto productDto) {
        productService.save(supId,productDto);
    }
    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
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
