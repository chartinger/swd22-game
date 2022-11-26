package at.compus02.swd.ss2022.repository;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

public class AssetRepository {
    public enum TextureType {
        PLAYER,
        TILE_GRASS,
        TILE_GRAVEL,
        TILE_WALL,
        TILE_WATER,
        SIGN,
        PROJECTILE,
    }

    private static AssetRepository instance = null;
    private Map<TextureType, Texture> textureByType = null;

    private AssetRepository() {
        textureByType = new HashMap<>();
    }

    public static AssetRepository getInstance() {
        if (instance == null) {
            instance = new AssetRepository();
        }

        return instance;
    }

    public void preloadAssets() {
        textureByType.put(TextureType.PLAYER, new Texture("player.png"));
        textureByType.put(TextureType.TILE_GRASS, new Texture("tile_grass.png"));
        textureByType.put(TextureType.TILE_GRAVEL, new Texture("tile_gravel.png"));
        textureByType.put(TextureType.TILE_WALL, new Texture("tile_wall.png"));
        textureByType.put(TextureType.TILE_WATER, new Texture("tile_water.png"));
        textureByType.put(TextureType.SIGN, new Texture("sign.png"));
        textureByType.put(TextureType.PROJECTILE, new Texture("projectile.png"));
    }

    public Texture getTexture(TextureType textureType) {
        Texture texture = textureByType.get(textureType);

        if (texture == null) {
            System.out.println("Unknown TextureType");
        }

        return texture;
    }

    public void dispose() {
        for (Texture texture : textureByType.values()) {
            texture.dispose();
        }
    }
}
