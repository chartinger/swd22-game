package at.compus02.swd.ss2022.game.gameobjects;

public abstract class MovingGameObject extends GameObject {
    public enum MoveDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NONE,
    }

    private float movementSpeedMultiplier;
    private MoveDirection moveDirection;
    private MoveDirection moveDirectionBefore;

    public MovingGameObject() {
        this.moveDirection = MoveDirection.NONE;
        this.moveDirectionBefore = MoveDirection.NONE;
        this.movementSpeedMultiplier = 100;
    }

    public float getMovementSpeedMultiplier() {
        return this.movementSpeedMultiplier;
    }

    public void setMovementSpeedMultiplier(float movementSpeed) {
        this.movementSpeedMultiplier = movementSpeed;
    }

    public MoveDirection getMoveDirection() {
        return this.moveDirection;
    }

    public MoveDirection getMoveDirectionBefore() {
        return this.moveDirectionBefore;
    }

    public void setMoveDirection(MoveDirection moveDirection) {
        this.moveDirectionBefore = this.moveDirection;
        this.moveDirection = moveDirection;
    }

    @Override
    public void act(float delta) {
        float movement = delta * movementSpeedMultiplier;
        switch (this.moveDirection) {
            case UP:
                this.setPosition(this.getSprite().getX(), this.getSprite().getY() + movement);
                break;
            case DOWN:
                this.setPosition(this.getSprite().getX(), this.getSprite().getY() - movement);
                break;
            case LEFT:
                this.setPosition(this.getSprite().getX() - movement, this.getSprite().getY());
                break;
            case RIGHT:
                this.setPosition(this.getSprite().getX() + movement, this.getSprite().getY());
                break;
            case NONE:
                break;
        }
    }
}
