package at.compus02.swd.ss2022.game.input;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import at.compus02.swd.ss2022.game.commands.FireProjectileCommand;
import at.compus02.swd.ss2022.game.commands.MoveDownCommand;
import at.compus02.swd.ss2022.game.commands.MoveLeftCommand;
import at.compus02.swd.ss2022.game.commands.MoveRightCommand;
import at.compus02.swd.ss2022.game.commands.MoveUpCommand;
import at.compus02.swd.ss2022.game.gameobjects.Player;

public class GameInput extends InputAdapter {
    private MoveUpCommand moveUpCommand;
    private MoveDownCommand moveDownCommand;
    private MoveLeftCommand moveLeftCommand;
    private MoveRightCommand moveRightCommand;
    private FireProjectileCommand fireProjectileCommand;
    private List<Integer> keysPressed;

    public GameInput(Player player) {
        this.moveUpCommand = new MoveUpCommand(player);
        this.moveDownCommand = new MoveDownCommand(player);
        this.moveLeftCommand = new MoveLeftCommand(player);
        this.moveRightCommand = new MoveRightCommand(player);
        this.fireProjectileCommand = new FireProjectileCommand(player);
        this.keysPressed = new ArrayList<>();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!this.keysPressed.contains(keycode)) {
            switch (keycode) {
                case Keys.UP:
                    this.moveUpCommand.execute();
                    break;
                case Keys.DOWN:
                    this.moveDownCommand.execute();
                    break;
                case Keys.LEFT:
                    this.moveLeftCommand.execute();
                    break;
                case Keys.RIGHT:
                    this.moveRightCommand.execute();
                    break;
                case Keys.SPACE:
                    this.fireProjectileCommand.execute();
                    break;
                default:
                    break;
            }
            this.keysPressed.add(keycode);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        int i = this.keysPressed.indexOf(keycode);
        if (i != -1) {
            switch (keycode) {
                case Keys.UP:
                    this.moveUpCommand.stop();
                    break;
                case Keys.DOWN:
                    this.moveDownCommand.stop();
                    break;
                case Keys.LEFT:
                    this.moveLeftCommand.stop();
                    break;
                case Keys.RIGHT:
                    this.moveRightCommand.stop();
                    break;
                default:
                    break;
            }
            this.keysPressed.remove(i);
        }
        return true;
    }
}
