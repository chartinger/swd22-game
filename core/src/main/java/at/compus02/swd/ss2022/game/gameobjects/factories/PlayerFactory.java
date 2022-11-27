package at.compus02.swd.ss2022.game.gameobjects.factories;

import java.util.ArrayList;
import java.util.List;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class PlayerFactory implements GameObjectFactory {
    private static PlayerFactory instance;
    private List<Player> objects;

    private PlayerFactory() {
        initalize();
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    @Override
    public Player create(GameObjectType type) {
        Player player = null;

        switch (type) {
            case PLAYER:
                player = new Player();
                break;
            default:
                System.out.println("Unknown GameObjectType");
                break;
        }

        objects.add(player);

        return player;
    }

    @Override
    public void initalize() {
        objects = new ArrayList<>();
    }

    @Override
    public Player[] getObjects() {
        Player[] objectArray = new Player[objects.size()];
        return objects.toArray(objectArray);
    }

}
