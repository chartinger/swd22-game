package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sign extends GameObject {
    public Sign() {
        Texture texture = new Texture("sign.png");
        setSprite(new Sprite(texture));
    }

    @Override
    public void act(float delta) {

    }

}
