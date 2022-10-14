package com.nickbenn.nim.strategy;

import com.nickbenn.nim.model.Game;

@FunctionalInterface
public interface Strategy {

  void play(Game game);

}
