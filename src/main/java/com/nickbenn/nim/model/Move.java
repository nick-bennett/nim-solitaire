package com.nickbenn.nim.model;

public final class Move {

  private final State fromState;
  private final Pile pile;
  private final int quantity;
  private final State toState;

  public Move(State fromState, Pile pile, int quantity, State toState) {
    this.fromState = fromState;
    this.pile = pile;
    this.quantity = quantity;
    this.toState = toState;
  }

  public State getFromState() {
    return fromState;
  }

  public Pile getPile() {
    return pile;
  }

  public int getQuantity() {
    return quantity;
  }

  public State getToState() {
    return toState;
  }

}
