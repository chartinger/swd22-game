package at.compus02.swd.ss2022.game.gameobjects.factories;

import java.util.ArrayList;
import java.util.List;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;

public class EnemyFactory implements GameObjectFactory<Enemy> {
    private static EnemyFactory instance;
    private List<Enemy> objects;

    private EnemyFactory() {
        initalize();
    }

    public static EnemyFactory getInstance() {
        if (instance == null) {
            instance = new EnemyFactory();
        }
        return instance;
    }

    @Override
    public Enemy create(GameObjectType type) {
        Enemy enemy = null;

        switch (type) {
            case ENEMY:
                enemy = new Enemy();
                break;
            default:
                System.out.println("Unknown GameObjectType");
                break;
        }

        objects.add(enemy);

        return enemy;
    }

    @Override
    public void initalize() {
        objects = new ArrayList<>();
    }

    @Override
    public Enemy[] getObjects() {
        Enemy[] objectArray = new Enemy[objects.size()];
        return objects.toArray(objectArray);
    }

}
