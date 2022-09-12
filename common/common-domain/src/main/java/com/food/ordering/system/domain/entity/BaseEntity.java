package com.food.ordering.system.domain.entity;

import java.util.Objects;

public abstract class BaseEntity<ID> {
  private ID orderId;

  public ID getId() {
    return orderId;
  }

  public void setId(ID id) {
    this.orderId = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BaseEntity<?> that = (BaseEntity<?>) o;
    return orderId.equals(that.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }
}
