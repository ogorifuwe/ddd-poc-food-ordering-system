package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
  private final BigDecimal amount;

  public static final Money ZERO = new Money(BigDecimal.ZERO);

  public Money(BigDecimal amount) {
    this.amount = amount;
  }

  public boolean isGreaterThanZero() {
    return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
  }

  public boolean isGreaterThan(Money value) {
    return this.amount != null && this.amount.compareTo(value.getAmount()) > 0;
  }

  public Money add(Money value) {
    return new Money(setScale(this.amount.add(value.getAmount())));
  }

  public Money subtract(Money value) {
    return new Money(setScale(this.amount.subtract(value.getAmount())));
  }

  public Money multiply(int multiplier) {
    return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Money money = (Money) o;
    return amount.equals(money.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  private BigDecimal setScale(BigDecimal input) {
    return input.setScale(2, RoundingMode.HALF_EVEN);
  }
}