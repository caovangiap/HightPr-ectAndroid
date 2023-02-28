package com.example.project_advanted.viewmodel

import android.app.Activity
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ViewModelLogin : ViewModel() {
    // chuyển màn
    var nextAction = MutableLiveData("LoginFalse")

    var inputName  = MutableLiveData<String>()

    // mật khẩu

    var inputPass = MutableLiveData<String>()
    // đăng nhập
    fun checkLogin(contextLogin: Activity){
        val auth = Firebase.auth
        if (!inputName.value.toString().isEmpty() && !inputPass.value.toString().isEmpty()){
            auth.signInWithEmailAndPassword(inputName.value.toString(), inputPass.value.toString())
                .addOnCompleteListener( contextLogin ) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            contextLogin, "success",
                            Toast.LENGTH_SHORT
                        ).show()
                        // chuyển sang màn chính
                        nextAction.postValue("LoginTrue")
                    } else {

                        Toast.makeText(
                            contextLogin, "sai tên đăng nhập hoặc mật khẩu",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        } else {
            Toast.makeText(contextLogin, "Không được để trống email hoặc password",
                Toast.LENGTH_SHORT).show()
        }
    }
    fun singUp(){
        nextAction.postValue("SingUp")
    }
}