package kz.olzhas.inventoryservice.service;

import kz.olzhas.inventoryservice.dto.SupplierDTO;
import kz.olzhas.inventoryservice.model.Supplier;

import java.util.List;

public interface SupplierService {
    void createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Long id);

    SupplierDTO getById(Long id);
}
