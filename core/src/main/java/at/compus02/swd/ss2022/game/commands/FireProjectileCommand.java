package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.Projectile;
import at.compus02.swd.ss2022.game.gameobjects.factories.ProjectileFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.GameObjectFactory.GameObjectType;

public class FireProjectileCommand implements Command {

    private Player player;

    private Projectile activeProjectile;

    public FireProjectileCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        MoveDirection direction = this.player.getMoveDirection();
        if (direction == MoveDirection.NONE) {
            direction = this.player.getMoveDirectionBefore();
            if (direction == MoveDirection.NONE) {
                return;
            }
        }
        this.activeProjectile = ProjectileFactory.getInstance().create(GameObjectType.PROJECTILE);
        this.activeProjectile.setPosition(this.player.getSprite().getX(), this.player.getSprite().getY());
        this.activeProjectile.setMoveDirection(direction);
    }

    @Override
    public void stop() {
        //
    }

}
