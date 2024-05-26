package kz.olzhas.inventoryservice.mapper.SupplierMapper;


import kz.olzhas.inventoryservice.dto.SupplierRequest;
import kz.olzhas.inventoryservice.dto.SupplierResponse;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierResponseMapper extends Mappable<Supplier, SupplierResponse> {
}
