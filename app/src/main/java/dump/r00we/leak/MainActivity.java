package dump.r00we.leak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dump.r00we.leak.resultreceiver.ResultReceiverLeak;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.innerClassLeak:
                intent = new Intent(this, InnerClassLeakActivity.class);
                break;
            case R.id.handlerLeak:
                intent = new Intent(this, HandlerLeakActivity.class);
                break;
            case R.id.weakRefCrash:
                intent = new Intent(this, WeakRefCrashActivity.class);
                break;
            case R.id.resultReceiverLeak:
                intent = new Intent(this, ResultReceiverLeakActivity.class);
                break;
            case R.id.weakRef:
                intent = new Intent(this, WeakRefActivity.class);
                break;
            default:
                intent = new Intent(this, InnerClassLeakActivity.class);
                break;
        }
        startActivity(intent);
    }
}
