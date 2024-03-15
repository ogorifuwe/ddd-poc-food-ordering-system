package com.food.ordering.system.order.service.domain.utility;

import com.food.ordering.system.domain.event.EmptyEvent;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.domain.service.OrderDomainService;
import com.food.ordering.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderApprovalSaga implements SagaStep<RestaurantApprovalResponse, EmptyEvent, OrderCancelledEvent> {

  private final OrderDomainService orderDomainService;
  private final OrderRepository orderRepository;
  private final OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher;

  public OrderApprovalSaga(OrderDomainService orderDomainService,
                           OrderRepository orderRepository,
                           OrderCancelledPaymentRequestMessagePublisher
                                   orderCancelledPaymentRequestMessagePublisher) {
    this.orderDomainService = orderDomainService;
    this.orderRepository = orderRepository;
    this.orderCancelledPaymentRequestMessagePublisher = orderCancelledPaymentRequestMessagePublisher;
  }

  @Override
  @Transactional
  public EmptyEvent process(RestaurantApprovalResponse restaurantApprovalResponse) {
    log.info("Approving order with id: {}", restaurantApprovalResponse.getOrderId());
    return null;
  }

  @Override
  @Transactional
  public OrderCancelledEvent rollback(RestaurantApprovalResponse restaurantApprovalResponse) {
    return null;
  }
}
