package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.employee.EmployeeResponse;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class EmployeeResponseMapper implements Mappable<Employee, EmployeeResponse> {
    @Override
    public Employee toEntity(EmployeeResponse dto) {
        return Employee.builder()
                .email(dto.getEmail())
                .restaurantId(dto.getRestaurantId())
                .jobRole(dto.getJobRole())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .kpiMonth(dto.getKpiMonth())
                .build();
    }

    @Override
    public EmployeeResponse toDto(Employee entity) {
        return EmployeeResponse.builder()
                .email(entity.getEmail())
                .restaurantId(entity.getRestaurantId())
                .jobRole(entity.getJobRole())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .kpiMonth(entity.getKpiMonth())
                .build();
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeResponse> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Employee> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while(var3.hasNext()) {
                EmployeeResponse employeeRequest = (EmployeeResponse)var3.next();
                list.add(this.toEntity(employeeRequest));
            }

            return list;
        }
    }

    @Override
    public List<EmployeeResponse> toDtoList(List<Employee> entity) {
        if (entity == null) {
            return null;
        } else {
            List<EmployeeResponse> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while(var3.hasNext()) {
                Employee restaurant = (Employee)var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
