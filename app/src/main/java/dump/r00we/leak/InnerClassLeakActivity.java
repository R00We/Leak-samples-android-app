package dump.r00we.leak;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by r00we on 22/03/2017.
 *
 */

public class InnerClassLeakActivity extends AppCompatActivity {
    private static Leaky sLeak;
    private byte[] mBigMemory;

    private class Leaky {
        Leaky() {
            Object link = InnerClassLeakActivity.this;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        mBigMemory = new byte[8000000];
        if (sLeak == null) {
            sLeak = new Leaky();
        }
    }
}
