package dump.r00we.leak;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HandlerLeakActivity extends AppCompatActivity {
    private byte[] mBigMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        mBigMemory = new byte[8000000];

    }

    private Handler mUpdateHandler = new Handler();
    private static final int updateTime = 1000;

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
                mUpdateHandler.postDelayed(this, updateTime);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mUpdateHandler.post(mUpdateTimeTask);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Забудете про следующую строчку и получите серьёзную утечку памяти
        mUpdateHandler.removeCallbacks(mUpdateTimeTask);
    }

}
