package at.maui.flopsydroid.android.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import at.maui.flopsydroid.FlopsyDroidGame;
import at.maui.flopsydroid.android.R;
import at.maui.flopsydroid.game.OnGlobalListener;

public class GameActivity extends AndroidApplication {

    private SharedPreferences mPreferences;

    private final Handler mHandler = new Handler();

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        mPreferences = getSharedPreferences("floppsy_droid", MODE_PRIVATE);

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		initialize(new FlopsyDroidGame(new OnGlobalListener() {
            @Override
            public void onGameOver(final int score) {
                vibrator.vibrate(1000);
            }

            @Override
            public void onScored() {
                vibrator.vibrate(100);
            }
        }), config);
	}
}
