package chat.Client.core;

import chat.Client.model.Chat;
import chat.Client.model.ChatManager;

public class ModelFactory {
    private final ClientFactory cf;

    //Add model interface
    private Chat chat;

    public ModelFactory(ClientFactory cf)
    {
        this.cf=cf;
    }

    //return model manager
    public Chat getChat()
    {
        if(chat==null)
        {
            chat=new ChatManager(cf.getClient());
        }
        return chat;
    }
}
