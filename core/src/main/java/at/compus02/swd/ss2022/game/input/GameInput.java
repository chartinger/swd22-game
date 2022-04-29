package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    @Override
    public boolean keyDown(int keycode) {
        System.out.println(keycode);
        return true;
    }
}
