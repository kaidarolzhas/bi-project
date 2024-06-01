package kz.olzhas.restaurantservice.service.impl;

import kz.olzhas.restaurantservice.dto.*;
import kz.olzhas.restaurantservice.feign.EmployeeClient;
import kz.olzhas.restaurantservice.feign.UserClient;
import kz.olzhas.restaurantservice.mapper.RestaurantRequestMapper;
import kz.olzhas.restaurantservice.mapper.RestaurantResponseMapper;
import kz.olzhas.restaurantservice.model.Expenses;
import kz.olzhas.restaurantservice.model.Restaurant;
import kz.olzhas.restaurantservice.model.Salary;
import kz.olzhas.restaurantservice.repository.ExpensesRepository;
import kz.olzhas.restaurantservice.repository.RestaurantRepository;
import kz.olzhas.restaurantservice.service.RestaurantService;
import kz.olzhas.restaurantservice.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantRequestMapper restaurantRequestMapper;
    private final RestaurantResponseMapper restaurantResponseMapper;
    private final UserClient userClient;
    private final EmployeeClient employeeClient;
    private final ExpensesRepository expensesRepository;
    private final SalaryService salaryService;

    @Override
    public RestaurantResponce findById(Long id, String token) {
        UserDto user = userClient.getUserByToken(token).getBody();
        Long userId = user != null ? user.getId() : null;

        RestaurantResponce restaurantResponce = restaurantResponseMapper.toDto(restaurantRepository.findById(id).orElse(null));

        return restaurantResponce;
    }

    @Override
    @Transactional
    public void save(String token, RestaurantRequest restaurantRequest) {
        UserDto user = userClient.getUserByToken(token).getBody();
        Long userId = user != null ? user.getId() : null;

        Restaurant restaurant = restaurantRequestMapper.toEntity(restaurantRequest);
        restaurant.setOwnerId(userId);
        restaurant = restaurantRepository.save(restaurant);
        LocalDate startDate = LocalDate.now();
        // End date: one month after today's date
        LocalDate endDate = startDate.plusMonths(1);

        Expenses expenses = Expenses.builder()
                .startDate(startDate)
                .endDate(endDate)
                .restaurant(restaurant)
                .build();

        expenses = expensesRepository.save(expenses);
        List<Salary> salaryList = salaryService.getSalary(restaurant.getId(), expenses);
        expenses.setSalaryList(salaryList);
        expensesRepository.save(expenses);
    }

    @Override
    public void update(Long id, RestaurantRequest restaurantRequest) {

    }

    @Override
    public void deleteById(Long id) {

    }

}
