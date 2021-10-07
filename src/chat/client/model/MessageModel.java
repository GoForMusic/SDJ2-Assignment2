package chat.client.model;

import chat.shared.transferoobjects.Messages;
import chat.shared.util.Subject;

import java.util.List;

public interface MessageModel extends Subject {
    String sendMessage(String message);
    List<Messages> getMessages();
}
