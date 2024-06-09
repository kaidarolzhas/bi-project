package kz.olzhas.inventoryservice.controller;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.OrderProductDTO;
import kz.olzhas.inventoryservice.service.OrderProductService;
import kz.olzhas.inventoryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order-product")
@RequiredArgsConstructor
public class OrderProductController {
    private final OrderProductService orderProductService;

    @PostMapping
    public void creteOrder(@RequestBody OrderProductDTO orderProductDTO) {
        orderProductService.save(orderProductDTO);
    }
    @GetMapping()
    public List<OrderProductDTO> getAllProduct() {
        return orderProductService.getAll();
    }

    @PutMapping("/{id}")
    public void updateOrderProduct(@PathVariable Long id, @RequestBody OrderProductDTO orderProductDTO) {
        orderProductService.update(id, orderProductDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        orderProductService.deleteById(id);
    }

    @GetMapping("/{id}")
    public OrderProductDTO getProduct(@PathVariable Long id) {
        return orderProductService.getById(id);
    }

}
