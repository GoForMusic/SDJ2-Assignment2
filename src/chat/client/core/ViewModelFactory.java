package chat.client.core;

import chat.client.views.login.LoginVM;

public class ViewModelFactory {

    private final ModelFactory modelFactory;

    //add vm
    private LoginVM loginVM;

    public ViewModelFactory(ModelFactory mf){
        modelFactory=mf;
    }
    //return the specific view model


    public LoginVM getLoginVM() {
        if(loginVM ==null){
            loginVM=new LoginVM();
        }
        return loginVM;
    }
}