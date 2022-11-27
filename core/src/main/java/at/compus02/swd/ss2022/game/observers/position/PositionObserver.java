package at.compus02.swd.ss2022.game.observers.position;

import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;;

public interface PositionObserver {
    public void update(float x, float y, MoveDirection direction);
}