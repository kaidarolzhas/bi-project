package kz.olzhas.inventoryservice.mapper.SupplierMapper;


import kz.olzhas.inventoryservice.dto.SupplierDTO;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierResponseMapper extends Mappable<Supplier, SupplierDTO> {
}
