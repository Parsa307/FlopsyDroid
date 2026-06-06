package at.maui.flopsydroid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

import at.maui.flopsydroid.game.FlopsyScreen;
import at.maui.flopsydroid.game.OnGlobalListener;

public class FlopsyDroidGame extends Game {

    private final AssetManager mAssetManager = new AssetManager();

    private final OnGlobalListener mListener;

    public FlopsyDroidGame(OnGlobalListener listener) {
        mListener = listener;
    }

	@Override
	public void create () {
        setScreen(new FlopsyScreen(this, mListener));
	}

    @Override
    public void dispose() {
        mAssetManager.dispose();
        super.dispose();
    }

    public AssetManager getAssetManager() {
        return mAssetManager;
    }
}
