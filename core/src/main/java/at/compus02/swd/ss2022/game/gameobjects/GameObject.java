package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
    private Sprite sprite;

    public abstract void act(float delta);

    public void setPosition(float x, float y) {
        if (sprite != null) {
            sprite.setPosition(x, y);
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

}
