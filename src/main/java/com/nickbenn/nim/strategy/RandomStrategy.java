package com.nickbenn.nim.strategy;

import com.nickbenn.nim.model.Game;
import com.nickbenn.nim.model.Move;
import com.nickbenn.nim.model.Pile;
import java.util.Random;
import java.util.function.Predicate;

public class RandomStrategy implements Strategy {

  private final Random rng = new Random();

  @Override
  public void play(Game game) {
    Pile pile = game
        .getPiles()
        .stream()
        .filter(Predicate.not(Pile::isEmpty))
        .findAny()
        .orElseThrow();
    int quantity = 1 + rng.nextInt(pile.getRemaining());
    game.play(pile, quantity);
  }

}
