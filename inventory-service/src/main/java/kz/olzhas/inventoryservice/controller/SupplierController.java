package kz.olzhas.inventoryservice.controller;


import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.SupplierDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.SupplierResponseMapper;
import kz.olzhas.inventoryservice.model.Supplier;
import kz.olzhas.inventoryservice.repository.SupplierRepository;
import kz.olzhas.inventoryservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;
    private final SupplierResponseMapper supplierResponseMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void createSupplier(@RequestBody SupplierDTO supplierRequest){
        Supplier supplier = supplierResponseMapper.toEntity(supplierRequest);
        supplierService.createSupplier(supplier);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierDTO> getAllSupplier(){
        return supplierResponseMapper.toDtoList(supplierService.getAllSuppliers());
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateSupplier(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = supplierResponseMapper.toEntity(supplierDTO);
        supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
    }

    @GetMapping("/{id}")
    public SupplierDTO getSup(@PathVariable Long id) {
        return supplierService.getById(id);
    }
}
