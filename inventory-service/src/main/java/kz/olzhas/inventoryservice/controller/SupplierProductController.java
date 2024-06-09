package kz.olzhas.inventoryservice.controller;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.SupplierProductDtoMapper;
import kz.olzhas.inventoryservice.service.SupplierProductService;
import kz.olzhas.inventoryservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-product")
@RequiredArgsConstructor
public class SupplierProductController {

    private final SupplierProductService supplierService;
    private final SupplierProductDtoMapper supplierProductDtoMapper;

    @PostMapping("/{supId}")
    public void createSupplierProduct(@PathVariable("supId") Long supId,@RequestBody SupplierProductDTO supplierDTO) {
        supplierService.save(supId,supplierDTO);
    }
    @GetMapping
    public List<SupplierProductDTO> getAllSupplier() {
        return supplierProductDtoMapper.toDtoList(supplierService.getAll());
    }

    @PutMapping("/{id}")
    public void updateSupplierProduct(@PathVariable Long id, @RequestBody SupplierProductDTO supplierProductDTO) {
        supplierService.update(id, supplierProductDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplierProduct(@PathVariable Long id) {

        supplierService.deleteById(id);
    }
    @GetMapping("/{id}")
    public SupplierProductDTO getsProduct(@PathVariable Long id) {
        return supplierService.getById(id);
    }
}
