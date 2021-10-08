package chat.client.views.chat;

import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;
import chat.client.views.ViewController;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ChatController implements ViewController {


    public ListView textRead;
    public TextField textInput;


    private ChatVM vm;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vfm) {
            viewHandler=vh;
            vm=vfm.getChatVM();
    }

    public void sendMessage(MouseEvent mouseEvent) {

    }
}
