package dump.r00we.leak.resultreceiver;

import android.content.Intent;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by r00we on 04/04/2017.
 */

public class ResultReceiverLeakService extends android.app.Service {
    public static final String RECEIVER = "receiver";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ResultReceiver leak = intent.getParcelableExtra(RECEIVER);
        stopSelf();

        return super.onStartCommand(intent, flags, startId);

    }
}
