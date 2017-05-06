package dump.r00we.leak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class WeakRefCrashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        Object crashObject = new Object();
        WeakReference<Object> ref = new WeakReference<Object>(crashObject);

        crashObject = null;

        if (ref.get() != null) {
            Runtime.getRuntime().gc();
            Log.d("WeakRefCrashActivity", ref.get().toString());
        }

    }
}
