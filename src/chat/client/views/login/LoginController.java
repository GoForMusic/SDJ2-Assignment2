package chat.client.views.login;

import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;
import chat.client.views.ViewController;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements ViewController {

    public TextField textInput;

    private LoginVM vm;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vfm) {
        viewHandler=vh;
        vm=vfm.getLoginVM();
    }

    public void login(MouseEvent mouseEvent) {
        viewHandler.openChatScene();
    }


}
