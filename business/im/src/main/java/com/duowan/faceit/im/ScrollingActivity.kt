package com.duowan.faceit.im

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.duowan.faceit.commomBusiness.RouterUrls
import com.duowan.faceit.router.Routers
import com.duowan.faceit.router.annotation.Module
import com.duowan.faceit.router.annotation.Router
import kotlinx.android.synthetic.main.activity_scrolling.*

@Module("im")
@Router(value = RouterUrls.IM)
class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            Routers.open(this, "faceit://"+"loginModel")
        }
    }
}
