package kz.olzhas.inventoryservice.controller;


import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.service.OrderService;
import kz.olzhas.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void createProduct(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
    }
    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
