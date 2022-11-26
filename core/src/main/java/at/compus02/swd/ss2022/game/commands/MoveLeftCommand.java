package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;

public class MoveLeftCommand implements Command {

    private Player player;

    public MoveLeftCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.setMoveDirection(MoveDirection.LEFT);
    }

    @Override
    public void stop() {
        if (this.player.getMoveDirection() == MoveDirection.LEFT) {
            this.player.setMoveDirection(MoveDirection.NONE);
        }
    }

}
