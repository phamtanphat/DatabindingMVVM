package com.example.mvvmpattern;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

public class LoginViewModel extends BaseObservable {

    private User user;
    private CallbackLogin callbackLogin;
    public LoginViewModel(CallbackLogin callbackLogin) {
        user = new User("","");
        this.callbackLogin = callbackLogin;
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }


    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userEmail);
    }

    public void onLoginClicked(){
        if(isInputDataValid()){

            callbackLogin.onSuccess("Thanh cong");
        }else{
            callbackLogin.onFail("That bai");
        }
    }
    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
