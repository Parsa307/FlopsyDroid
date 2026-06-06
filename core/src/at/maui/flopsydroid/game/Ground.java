package at.maui.flopsydroid.game;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Ground extends Image implements OnDroidCollisionListener {

    public static final float GROUND_WIDTH = 336f;
    public static final float GROUND_HEIGHT = 36f;

    private final Droid mAndy;

    public Ground(TextureRegion region, Droid andy) {
        super(region);

        mAndy = andy;
        addAction(Actions.forever(Actions.moveBy(-GROUND_WIDTH, 0f, 3f)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (getX() <= -GROUND_WIDTH) {
            setX(0);
        }
        if (checkCollision()) {
            mAndy.hitGround();
        }
    }

    public boolean checkCollision() {
        return mAndy.getY() <= GROUND_HEIGHT;
    }

    @Override
    public void onDroidCollision() {
        clearActions();
    }
}
