package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.Tile;
import at.compus02.swd.ss2022.game.gameobjects.factories.Factory;
import at.compus02.swd.ss2022.game.gameobjects.factories.PlayerFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.ProjectileFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.Factory.GameObjectType;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.repository.AssetRepository;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private float worldHeight = 480.0f;
	private float worldWidth = 480.0f;
	private ExtendViewport viewport = new ExtendViewport(worldWidth, worldHeight, worldWidth, worldHeight);
	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		initTextures();
		initGameObjectsAndInput();
	}

	private void initTextures() {
		AssetRepository.getInstance().preloadAssets();
	}

	private void initGameObjectsAndInput() {
		float maxHeight = worldHeight / 2;
		float minHeight = maxHeight * (-1);
		float maxWidth = worldWidth / 2;
		float minWidth = maxWidth * (-1);

		for (float x = minWidth; x < maxWidth; x += Tile.WIDTH) {
			for (float y = minHeight; y < maxHeight; y += Tile.HEIGHT) {
				GameObjectType type = Factory.GameObjectType.TILE_GRASS;
				if (x == minWidth || x == maxWidth - Tile.WIDTH || y == minHeight || y == maxHeight - Tile.HEIGHT) {
					type = Factory.GameObjectType.TILE_WALL;
				} else if (y < minHeight + Tile.HEIGHT * 4) {
					type = Factory.GameObjectType.TILE_WATER;
				} else if (y < minHeight + Tile.HEIGHT * 5 || y > maxHeight - Tile.HEIGHT * 3
						|| x <= minWidth + Tile.WIDTH || x >= maxWidth - Tile.WIDTH * 2) {
					type = Factory.GameObjectType.TILE_GRAVEL;
				}
				GameObject tile = TileFactory.getInstance().create(type);
				tile.setPosition(x, y);
			}
		}

		Player player = PlayerFactory.getInstance().create(Factory.GameObjectType.PLAYER);
		player.setPosition(0, 0);

		Gdx.input.setInputProcessor(new GameInput(player));
	}

	private Array<GameObject> getGameObjects() {
		Array<GameObject> gameObjects = new Array<>();
		gameObjects.addAll(TileFactory.getInstance().getObjects());
		gameObjects.addAll(PlayerFactory.getInstance().getObjects());
		gameObjects.addAll(ProjectileFactory.getInstance().getObjects());
		return gameObjects;
	}

	private void act(float delta) {
		for (GameObject gameObject : getGameObjects()) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for (GameObject gameObject : getGameObjects()) {
			gameObject.draw(batch);
		}
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while (deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
		AssetRepository.getInstance().dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}