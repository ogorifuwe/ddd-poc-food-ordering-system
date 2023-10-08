package com.foodl.ordering.system.restaurant.service.domain;

import com.food.ordering.system.restaurant.service.domain.service.RestaurantDomainService;
import com.food.ordering.system.restaurant.service.domain.service.RestaurantDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public RestaurantDomainService restaurantDomainService() {
    return new RestaurantDomainServiceImpl();
  }
}