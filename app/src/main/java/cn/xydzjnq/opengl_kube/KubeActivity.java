package cn.xydzjnq.opengl_kube;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class KubeActivity extends Activity {
    private KubeView mKubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mKubeView = new KubeView(this);
        setContentView(mKubeView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mKubeView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mKubeView.onPause();
    }
}
