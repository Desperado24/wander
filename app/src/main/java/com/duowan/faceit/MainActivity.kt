package com.duowan.faceit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.duowan.faceit.commomBusiness.RouterUrls
import com.duowan.faceit.router.Routers
import com.duowan.faceit.router.annotation.Module
import com.duowan.faceit.router.annotation.Router
import kotlinx.android.synthetic.main.activity_main.*

@Module("app")
@Router(value = RouterUrls.MAIN)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.setOnClickListener {
            Routers.open(this, "faceit://"+"login/222")
        }
    }
}
