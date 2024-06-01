package kz.olzhas.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponce {
    Long id;

    String name;

    String address;

    String city;

    String phoneNumber;
}
