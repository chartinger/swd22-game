package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;

public class MoveUpCommand implements Command {

    private Player player;

    public MoveUpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.setMoveDirection(MoveDirection.UP);
    }

    @Override
    public void stop() {
        if (this.player.getMoveDirection() == MoveDirection.UP) {
            this.player.setMoveDirection(MoveDirection.NONE);
        }
    }

}
