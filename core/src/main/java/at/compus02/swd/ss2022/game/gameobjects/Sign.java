package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.repository.AssetRepository;
import at.compus02.swd.ss2022.repository.AssetRepository.TextureType;

public class Sign extends GameObject {
    public Sign() {
        Texture texture = AssetRepository.getInstance().getTexture(TextureType.SIGN);
        setSprite(new Sprite(texture));
    }

    @Override
    public void act(float delta) {

    }

}
