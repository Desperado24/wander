package com.duowan.faceit;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.duowan.faceit.router.RouterCallback;
import com.duowan.faceit.router.RouterCallbackProvider;
import com.duowan.faceit.router.Routers;


/**
 * Created by CaoDongping on 4/6/16.
 */
public class RouterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RouterCallback callback = getRouterCallback();

        Uri uri = getIntent().getData();
        if (uri != null) {
            Routers.open(this, uri, callback);
        }
        finish();
    }

    private RouterCallback getRouterCallback() {
        if (getApplication() instanceof RouterCallbackProvider) {
            return ((RouterCallbackProvider) getApplication()).provideRouterCallback();
        }
        return null;
    }
}
