package com.duowan.faceit.login

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.duowan.faceit.router.annotation.Router

/**
 * Created by liuxun on 2019/8/30.
 */
class LoginVM : ViewModel() {
    @Router("loginModel")
    fun loginModel(context: Context, bundle: Bundle){
        Toast.makeText(context,"loginModel", Toast.LENGTH_LONG).show()
    }
}