package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import at.compus02.swd.ss2022.repository.AssetRepository;
import at.compus02.swd.ss2022.repository.AssetRepository.TextureType;

public class Projectile extends MovingGameObject {
    public Projectile() {
        super();
        Texture texture = AssetRepository.getInstance().getTexture(TextureType.PROJECTILE);
        setSprite(new Sprite(texture));
        setMovementSpeedMultiplier(150);
    }
}
