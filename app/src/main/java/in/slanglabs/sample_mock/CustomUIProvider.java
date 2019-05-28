package in.slanglabs.sample_mock;

import android.app.Activity;
import android.util.Log;

import java.util.Locale;
import java.util.Set;

import in.slanglabs.platform.SlangException;
import in.slanglabs.platform.ui.SlangUIDelegate;
import in.slanglabs.platform.ui.SlangUIProvider;

public class CustomUIProvider implements SlangUIProvider {
    private static final String TAG = CustomUIProvider.class.getSimpleName();
    private static final CustomUIProvider sInstance = new CustomUIProvider();

    private SlangUIDelegate mUIDelegate;
    private TextListener mTextListener;

    private CustomUIProvider() {}

    public static CustomUIProvider getInstance() {
        return sInstance;
    }

    @Override
    public void onDisabled(SlangException e) {
        Log.d(TAG, "In onDisabled");
    }

    @Override
    public void onCreate(Activity activity, SlangUIDelegate slangUIDelegate) {
        Log.d(TAG, "In onCreate");
        mUIDelegate = slangUIDelegate;
    }

    @Override
    public void onUserSessionStarted() {
        Log.d(TAG, "In onUserSessionStarted");
    }

    @Override
    public void onListeningStarted() {
        Log.d(TAG, "In onListeningStarted");
    }

    @Override
    public void onUserTextAvailable(String s, Locale locale) {
        Log.d(TAG, "In onUserTextAvailable");
        if (mTextListener != null) mTextListener.onUserTextAvailable(s);
    }

    @Override
    public void onListeningEnded() {
        Log.d(TAG, "In onUserTextAvailable");
    }

    @Override
    public void onListeningTimedOut() {
        Log.d(TAG, "In onListeningTimedOut");
    }

    @Override
    public void onListeningError(String s, Locale locale) {
        Log.d(TAG, "In onListeningError");
    }

    @Override
    public void onSlangProcessingStarted() {
        Log.d(TAG, "In onSlangProcessingStarted");
    }

    @Override
    public void onSlangProcessingEnded() {
        Log.d(TAG, "In onSlangProcessingEnded");
    }

    @Override
    public void onSlangProcessingError(String s, Locale locale) {
        Log.d(TAG, "In onSlangProcessingError");
    }

    @Override
    public void onSlangTextAvailable(String s, Locale locale) {
        Log.d(TAG, "In onSlangTextAvailable");
        if (mTextListener != null) mTextListener.onSlangTextAvailable(s);
    }

    @Override
    public void onUserSessionEnded() {
        Log.d(TAG, "In onUserSessionEnded");
    }

    @Override
    public void onDismissed() {
        Log.d(TAG, "In onDismissed");
    }

    @Override
    public void onHelpRequested() {
        Log.d(TAG, "In onHelpRequested");
    }

    @Override
    public void onHelpRequested(Set<String> set) {
        Log.d(TAG, "In onHelpRequested");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "In onDestroy");
    }

    public SlangUIDelegate getUIDelegate() {
        return mUIDelegate;
    }

    public void setTextListener(TextListener listener) {
        mTextListener = listener;
    }

    public interface TextListener {
        void onSlangTextAvailable(String text);
        void onUserTextAvailable(String text);
    }
}
