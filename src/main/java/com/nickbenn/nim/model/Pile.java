package com.nickbenn.nim.model;

public final class Pile {

  public static final int MIN_SIZE = 1;
  private static final String BAD_QUANTITY_FORMAT =
      "Invalid quantity: %1$d; must be between 1 and %2$d (inclusive).";
  private static final String BAD_SIZE_FORMAT =
      "Invalid size: %1$d; must be at least %2$d.";

  private int removed;
  private int remaining;

  public Pile(int size) {
    if (size < MIN_SIZE) {
      throw new IllegalArgumentException(String.format(BAD_SIZE_FORMAT, size, MIN_SIZE));
    }
    remaining = size;
  }

  void remove(int quantity) throws IllegalArgumentException {
    if (quantity <= 0 || quantity > remaining) {
      throw new IllegalArgumentException(String.format(BAD_QUANTITY_FORMAT, quantity, remaining));
    }
    remaining -= quantity;
    removed += quantity;
  }

  public int getRemoved() {
    return removed;
  }

  public int getRemaining() {
    return remaining;
  }

  public boolean isEmpty() {
    return remaining == 0;
  }

}
