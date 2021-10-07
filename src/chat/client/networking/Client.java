package chat.client.networking;

import chat.shared.transferoobjects.Messages;
import chat.shared.util.Subject;

import java.util.ArrayList;

public interface Client extends Subject {
    String sendMessage(String str);
    ArrayList<Messages> getMessages();

    void startClient();
}
