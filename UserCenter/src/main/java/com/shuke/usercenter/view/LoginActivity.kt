package com.shuke.usercenter.view

import android.util.Log
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mvpcore.view.BaseMVPActivity
import com.shuke.usercenter.R

import com.shuke.usercenter.injection.module.ModelModule
import com.shuke.usercenter.injection.module.ViewModule
import com.shuke.usercenter.model.entity.login.LoginReq
import com.shuke.usercenter.model.entity.login.UserInfo
import com.shuke.usercenter.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@Route(path = "/UserCenter/Login")
class LoginActivity : BaseMVPActivity(), View.OnClickListener,LoginView{


    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun injectComponent() {
        DaggerUserCenterComponent.builder().activityComponent(appComponent).modelModule(ModelModule())
            .viewModule(ViewModule(this))
            .build()
            .inject(this)

    }

    override fun initEvent() {

    }

    override fun initData() {

    }

    override fun initView() {
        login_act_goback.setOnClickListener(this)
        login_text_toReg.setOnClickListener(this)
        login_btn_login.setOnClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.login_act_goback -> this.finish()
            R.id.login_text_toReg -> toReg()
            R.id.login_btn_login -> login()
        }
    }

    /**
     * 登录
     */
    private fun login() {
        var usernameIsNull =  login_edit_username.text.toString().trim() == null
        var passwordIsNull =  login_edit_password.text.toString().trim() == null
        if (usernameIsNull or passwordIsNull){
            Toast.makeText(this, "请输入账号密码", Toast.LENGTH_SHORT).show()
            return
        }
        val username = login_edit_username.text.toString().trim()
        val password = login_edit_password.text.toString().trim()
        var user:LoginReq = LoginReq(username,password,"")
        loginPresenter.login(user)
    }

    /**
     * 跳转至注册
     */
    private fun toReg() {
        ARouter.getInstance().build("/UserCenter/Register").navigation()
    }



    override fun success(bean: UserInfo) {
        Log.i("TAG", "success: ")
    }

    override fun failed(e: Throwable) {
        Log.i("TAG", e.message.toString())
    }
}