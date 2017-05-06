package dump.r00we.leak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dump.r00we.leak.resultreceiver.ResultReceiverLeak;
import dump.r00we.leak.resultreceiver.ResultReceiverLeakService;

/**
 * Created by r00we on 04/04/2017.
 */

public class ResultReceiverLeakActivity extends AppCompatActivity implements ResultReceiverLeak.Receiver {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        ResultReceiverLeak leak = new ResultReceiverLeak(null);
        leak.setReceiver(this);
        Intent intent = new Intent(this, ResultReceiverLeakService.class);
        // Если передавать ResultReceiver через интент в другой процесс
        // то он подвиснет в памяти на не определенное время.
        intent.putExtra(ResultReceiverLeakService.RECEIVER, leak);

        startService(intent);

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }
}
