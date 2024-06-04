package kz.olzhas.employeeserver.util;

public class EntityHelper {
    public static final String ALL_EMPLOYEE_RES_ID =  "SELECT k.employee_id AS emlId, k.kpi AS kpi, k.month AS month, k.year AS year, te.first_name AS username " +
            "FROM employee.t_kpi k " +
            "JOIN employee.t_employee te ON k.employee_id = te.id " +
            "WHERE te.restaurant_id = :res";

    public static final String ALL_EMPLOYEE_RES_ID_ROLE_ID =  "SELECT k.employee_id AS emlId, k.kpi AS kpi, k.month AS month, k.year AS year " +
            "FROM employee.t_kpi k " +
            "JOIN employee.t_employee te ON k.employee_id = te.id " +
            "WHERE te.restaurant_id = :res AND te.role_id = :roleId";

}
