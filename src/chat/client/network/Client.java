package chat.Client.network;

import chat.Share.transferobjects.Message;
import chat.Share.util.Subject;

import java.util.List;

public interface Client extends Subject {
    String message(String username,String str);
    List<Message> getMessages();

    void startClient();

    void unRegisterClient();
}
