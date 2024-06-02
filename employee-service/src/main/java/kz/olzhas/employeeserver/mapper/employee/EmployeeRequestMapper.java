package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class EmployeeRequestMapper implements Mappable<Employee, EmployeeRequest> {
    @Override
    public Employee toEntity(EmployeeRequest dto) {
        return Employee.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .restaurantId(dto.getRestaurantId())
                .jobRole(dto.getJobRole())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .kpiMonth(dto.getKpiMonth())
                .build();
    }

    @Override
    public EmployeeRequest toDto(Employee entity) {
        return EmployeeRequest.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .restaurantId(entity.getRestaurantId())
                .jobRole(entity.getJobRole())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .kpiMonth(entity.getKpiMonth())
                .build();
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeRequest> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Employee> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while(var3.hasNext()) {
                EmployeeRequest employeeRequest = (EmployeeRequest)var3.next();
                list.add(this.toEntity(employeeRequest));
            }

            return list;
        }
    }

    @Override
    public List<EmployeeRequest> toDtoList(List<Employee> entity) {
        if (entity == null) {
            return null;
        } else {
            List<EmployeeRequest> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while(var3.hasNext()) {
                Employee restaurant = (Employee)var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
