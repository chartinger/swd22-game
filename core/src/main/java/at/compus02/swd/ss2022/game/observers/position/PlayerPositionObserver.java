package at.compus02.swd.ss2022.game.observers.position;

import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;
import at.compus02.swd.ss2022.logger.Logger;;

public class PlayerPositionObserver implements PositionObserver {
    private final Logger logger;

    public PlayerPositionObserver(Logger logger) {
        this.logger = logger;
    }

    public void update(float x, float y, MoveDirection direction) {
        this.logger.log(String.format("[Player]: (x: %.2f, y: %.2f), direction: %s", x, y, direction));
    }
}