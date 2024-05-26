package kz.olzhas.inventoryservice.controller;


import kz.olzhas.inventoryservice.dto.SupplierRequest;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.SupplierRequestMapper;
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
public class MainController {

    private final SupplierService supplierService;
    private final SupplierResponseMapper supplierResponseMapper;
    private final SupplierRequestMapper supplierRequestMapper;
    private final SupplierRepository supplierRepository;
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void createSupplier(@RequestBody SupplierRequest supplierRequest){
        Supplier supplier = supplierRequestMapper.toEntity(supplierRequest);
        supplierService.createSupplier(supplier);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSuppliers();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateSupplier(@RequestBody SupplierRequest supplierRequest){
        Supplier supplier = supplierRequestMapper.toEntity(supplierRequest);
        supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
    }
}
