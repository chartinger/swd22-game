package at.compus02.swd.ss2022.game.gameobjects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import at.compus02.swd.ss2022.game.gameobjects.MovingGameObject.MoveDirection;
import at.compus02.swd.ss2022.game.observers.position.PositionObserver;
import at.compus02.swd.ss2022.game.observers.position.PositionSubject;

public abstract class GameObject implements PositionSubject {
    private Sprite sprite;

    // Observers
    protected final List<PositionObserver> positionObservers = new ArrayList<>();

    public abstract void act(float delta);

    public void setPosition(float x, float y) {
        if (sprite != null) {
            sprite.setPosition(x, y);
            this.notifyObservers();
        } else {
            System.out.println("GameObject Sprite is not set");
        }
    }

    public void draw(SpriteBatch batch) {
        if (sprite != null) {
            sprite.draw(batch);
        } else {
            System.out.println("GameObject Sprite is not set");
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void registerObserver(PositionObserver observer) {
        positionObservers.add(observer);
    }

    @Override
    public void unregisterObserver(PositionObserver observer) {
        positionObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PositionObserver observer : positionObservers) {
            observer.update(getSprite().getX(), getSprite().getY(), MoveDirection.NONE);
        }
    }
}
