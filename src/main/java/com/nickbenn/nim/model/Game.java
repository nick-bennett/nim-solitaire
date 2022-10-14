package com.nickbenn.nim.model;

import com.nickbenn.nim.strategy.Strategy;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Game {

  public static final int MIN_PILES = 2;
  private static final String BAD_NUM_PILES_FORMAT =
      "Invalid number of piles: %1$d; must be at least %2$d.";
  private static final String GAME_OVER_MESSAGE = "Game is over; further moves are not allowed.";

  private final List<Pile> piles;
  private final List<Move> moves;

  private State state;

  public Game(Strategy strategy, int... pileSizes)
      throws IllegalArgumentException {
    if (pileSizes.length < MIN_PILES) {
      throw new IllegalArgumentException(
          String.format(BAD_NUM_PILES_FORMAT, pileSizes.length, MIN_PILES));
    }
    piles = IntStream.of(pileSizes)
        .mapToObj(Pile::new)
        .collect(Collectors.toList());
    moves = new LinkedList<>();
    state = isFinished() ? State.PLAYER_2_WIN : State.PLAYER_1_MOVE;
  }

  public void play(Pile pile, int quantity) {
    if (state.isTerminal()) {
      throw new IllegalStateException(GAME_OVER_MESSAGE);
    }
    State fromState = state;
    pile.remove(quantity);
    state = isFinished() ? state.nextWinState() : state.nextMoveState();
    moves.add(new Move(fromState, pile, quantity, state));
  }

  public boolean isFinished() {
    return piles.stream()
        .allMatch(Pile::isEmpty);
  }

  public List<Pile> getPiles() {
    return Collections.unmodifiableList(piles);
  }

  public List<Move> getMoves() {
    return Collections.unmodifiableList(moves);
  }

  public State getState() {
    return state;
  }

}
