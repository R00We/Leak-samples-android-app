package dump.r00we.leak.resultreceiver;


import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by r00we on 04/04/2017.
 */

public class ResultReceiverLeak extends ResultReceiver {

    private Receiver mReceiver;

    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public ResultReceiverLeak(Handler handler) {
        super(handler);
    }

    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }

    public void release(){
        mReceiver = null;

    }
}
