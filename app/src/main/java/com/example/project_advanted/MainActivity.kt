package com.example.project_advanted

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project_advanted.databinding.ActivityMainBinding
import com.example.project_advanted.view.login.FragmentLogin
import com.example.project_advanted.view.login.FragmentSingUp
import com.example.project_advanted.view.manager.FragmentManager
import com.example.project_advanted.viewmodel.ViewModelLogin

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mView : View

    companion object{
        lateinit var ApplicationContext : Context
        lateinit var vMlLogin : ViewModelLogin
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mView = binding.root
        ApplicationContext = this
        setContentView(mView)
        // modelview đăng nhập
        vMlLogin = ViewModelLogin()


        // chức năng đăng nhâp
        CheckLogin()
    }


    // login
    private fun CheckLogin(){


        val fragment = FragmentLogin()
        val managerActivity = supportFragmentManager.beginTransaction()
        managerActivity.replace(R.id.view,fragment)
        managerActivity.addToBackStack(null)
        managerActivity.commit()

        vMlLogin.nextAction.observe(this){
            when(it){
                "LoginFalse"->{
                    val fragment = FragmentLogin()
                    val managerActivity = supportFragmentManager.beginTransaction()
                    managerActivity.replace(R.id.view,fragment)
                    managerActivity.addToBackStack(null)
                    managerActivity.commit()
                }
                "LoginTrue"->{
                    val fragment = FragmentManager()
                    val managerActivity = supportFragmentManager.beginTransaction()
                    managerActivity.replace(R.id.view,fragment)
                    managerActivity.addToBackStack(null)
                    managerActivity.commit()
                }
                "SingUp"->{
                    val fragment = FragmentSingUp()
                    val managerActivity = supportFragmentManager.beginTransaction()
                    managerActivity.replace(R.id.view,fragment)
                    managerActivity.addToBackStack(null)
                    managerActivity.commit()
                }
            }
        }
    }


}