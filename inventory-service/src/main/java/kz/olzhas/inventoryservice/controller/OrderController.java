package kz.olzhas.inventoryservice.controller;


import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void creteOrder(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
    }
    @GetMapping("/{resId}")
    public List<OrderDto> getAll(@PathVariable("resId") Long resId) {
        return orderService.getAll(resId);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return orderService.getById(id);
    }

}
