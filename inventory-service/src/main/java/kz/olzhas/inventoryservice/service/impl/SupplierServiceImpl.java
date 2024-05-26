package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.model.Supplier;
import kz.olzhas.inventoryservice.repository.SupplierRepository;
import kz.olzhas.inventoryservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public void createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }


    @Override
    public void updateSupplier(Supplier supplier) {
        Optional<Supplier> supplier1 = supplierRepository.findById(supplier.getId());
        if (supplier1.isPresent()){
            supplier1.get().setAddress(supplier.getAddress());
            supplier1.get().setName(supplier.getName());
            supplier1.get().setCity(supplier.getCity());
            supplier1.get().setEmail(supplier.getEmail());
            supplier1.get().setPhone(supplier.getPhone());
            supplier1.get().setCountry(supplier.getCountry());
            supplierRepository.saveAndFlush(supplier1.get());
        }

    }

    @Override
    public void deleteSupplier(Long id) {
        Optional<Supplier> supplier1 = supplierRepository.findById(id);
        if (supplier1.isPresent()){
            supplierRepository.deleteById(id);
        }
    }
}
