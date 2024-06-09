package kz.olzhas.inventoryservice.service;

import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import kz.olzhas.inventoryservice.model.SupplierProduct;

import java.util.List;

public interface SupplierProductService {
    void save(Long supId, SupplierProductDTO supplierProductDTO);

    void update(Long id, SupplierProductDTO supplierProductDTO);

    void deleteById(Long id);

    List<SupplierProduct> getAll();

    SupplierProductDTO getById(Long id);
}
