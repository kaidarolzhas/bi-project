package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.SupplierProductDtoMapper;
import kz.olzhas.inventoryservice.model.Product;
import kz.olzhas.inventoryservice.model.Supplier;
import kz.olzhas.inventoryservice.model.SupplierProduct;
import kz.olzhas.inventoryservice.repository.ProductRepository;
import kz.olzhas.inventoryservice.repository.SupplierProductRepository;
import kz.olzhas.inventoryservice.repository.SupplierRepository;
import kz.olzhas.inventoryservice.service.SupplierProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierProductServiceImpl implements SupplierProductService {
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final SupplierProductRepository supplierProductRepository;
    private final SupplierProductDtoMapper supplierProductMapper;

    @Override
    public void save(Long supId, SupplierProductDTO supplierProductDTO) {
        SupplierProduct supplierProduct = supplierProductMapper.toEntity(supplierProductDTO);
            Optional<Supplier> supplier = supplierRepository.findById(supId);
            if (supplier.isPresent()) {
                supplierProduct.setSupplier(supplier.get());
                Optional<Product> product = productRepository.findById(supplierProductDTO.getProduct().getId());
                product.ifPresent(supplierProduct::setProduct);
                supplierProductRepository.saveAndFlush(supplierProduct);
            }
    }

    @Override
    public void update(Long id, SupplierProductDTO supplierProductDTO) {
        Optional<SupplierProduct> supplierProduct = supplierProductRepository.findById(id);
        if (supplierProduct.isPresent()) {
            SupplierProduct updatedSupplierProduct = supplierProduct.get();
            updatedSupplierProduct.setPrice(supplierProductDTO.getPrice());
            updatedSupplierProduct.setCount(supplierProductDTO.getCount());
            updatedSupplierProduct.setSupplier(supplierRepository.findById(supplierProductDTO.getSupplier().getId()).orElse(null));
            updatedSupplierProduct.setProduct(productRepository.findById(supplierProductDTO.getProduct().getId()).orElse(null));
            supplierProductRepository.saveAndFlush(updatedSupplierProduct);
        }
    }

    @Override
    public void deleteById(Long id) {
        supplierProductRepository.deleteById(id);
    }

    @Override
    public List<SupplierProduct> getAll() {
        return supplierProductRepository.findAll();
    }

    @Override
    public SupplierProductDTO getById(Long id) {
        Optional<SupplierProduct> supplierProduct = supplierProductRepository.findById(id);
        return supplierProduct.map(supplierProductMapper::toDto).orElse(null);

    }
}
