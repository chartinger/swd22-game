package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;

public class MoveDownCommand implements Command {

    private Player player;

    public MoveDownCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.setMoveDirection(MoveDirection.DOWN);
    }

    @Override
    public void stop() {
        if (this.player.getMoveDirection() == MoveDirection.DOWN) {
            this.player.setMoveDirection(MoveDirection.NONE);
        }
    }

}
