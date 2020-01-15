package com.duowan.faceit;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.duowan.faceit.router.RouterCallback;
import com.duowan.faceit.router.RouterCallbackProvider;
import com.duowan.faceit.router.SimpleRouterCallback;
import com.duowan.faceit.router.annotation.Modules;

/**
 * Created by CaoDongping on 4/6/16.
 */
@Modules({"app", "login", "im"})
public class App extends Application implements RouterCallbackProvider {
    @Override
    public RouterCallback provideRouterCallback() {
        return new SimpleRouterCallback() {
            @Override
            public boolean beforeOpen(Context context, Uri uri) {
                if (uri.toString().startsWith("factit://")) {
                    context.startActivity(new Intent(context, RouterActivity.class));
                    return true;
                }
                return false;
            }

            @Override
            public void notFound(Context context, Uri uri) {
                // context.startActivity(new Intent(context, NotFoundActivity.class));
            }

            @Override
            public void error(Context context, Uri uri, Throwable e) {
                // context.startActivity(ErrorStackActivity.makeIntent(context, uri, e));
            }
        };
    }
}
