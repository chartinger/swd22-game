package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends GameObject {
    public Player() {
        Texture texture = new Texture("player.png");
        setSprite(new Sprite(texture));
    }

    @Override
    public void act(float delta) {
        // Just chillin' for now ;)
    }

}
