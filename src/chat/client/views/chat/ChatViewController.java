package chat.Client.views.chat;

import chat.Client.core.ViewHandler;
import chat.Client.core.ViewModelFactory;
import chat.Client.views.ViewController;
import chat.Share.transferobjects.Message;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ChatViewController implements ViewController {
    public ListView<Message> chatView;
    public TextField textInputMessage;

    private ChatViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh=vh;
        vm=vmf.getChatViewModel();
        vm.loadMessages();
        chatView.setItems(vm.getMessages());
    }

    public void sendMessage(MouseEvent mouseEvent) {
        vm.sendMessage(textInputMessage.getText());
        textInputMessage.clear();
    }
}
