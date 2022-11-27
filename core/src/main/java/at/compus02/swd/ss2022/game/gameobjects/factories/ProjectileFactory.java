package at.compus02.swd.ss2022.game.gameobjects.factories;

import java.util.ArrayList;
import java.util.List;

import at.compus02.swd.ss2022.game.gameobjects.Projectile;

public class ProjectileFactory implements GameObjectFactory {
    private static ProjectileFactory instance;
    private List<Projectile> objects;

    private ProjectileFactory() {
        initalize();
    }

    public static ProjectileFactory getInstance() {
        if (instance == null) {
            instance = new ProjectileFactory();
        }
        return instance;
    }

    @Override
    public Projectile create(GameObjectType type) {
        Projectile projectile = null;

        switch (type) {
            case PROJECTILE:
                projectile = new Projectile();
                break;
            default:
                System.out.println("Unknown GameObjectType");
                break;
        }

        objects.add(projectile);

        return projectile;
    }

    @Override
    public void initalize() {
        objects = new ArrayList<>();
    }

    @Override
    public Projectile[] getObjects() {
        Projectile[] objectArray = new Projectile[objects.size()];
        return objects.toArray(objectArray);
    }

}
