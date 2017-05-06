package dump.r00we.leak;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * Created by r00we on 10/04/2017.
 */

public class WeakRefActivity extends AppCompatActivity {
    private static WeakRefActivity.Leaky sLeak;

    private static class Leaky {
        private WeakReference<Activity> reference;

        public Leaky(Activity reference) {
            this.reference = new WeakReference<Activity>(reference);
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_leak);
        if (sLeak == null) {
            sLeak = new WeakRefActivity.Leaky(this);
        }
    }
}
