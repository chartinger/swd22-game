package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;

public class MoveRightCommand implements Command {

    private Player player;

    public MoveRightCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.setMoveDirection(MoveDirection.RIGHT);
    }

    @Override
    public void stop() {
        if (this.player.getMoveDirection() == MoveDirection.RIGHT) {
            this.player.setMoveDirection(MoveDirection.NONE);
        }
    }

}
