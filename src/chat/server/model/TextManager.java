package chat.server.model;

import chat.shared.transferoobjects.Messages;
import chat.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {
    String sendMessages(String str);
    List<Messages> getMessages();
}
