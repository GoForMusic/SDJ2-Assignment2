package chat.client.core;

import chat.client.model.MessageManager;
import chat.client.model.MessageModel;

public class ModelFactory {


    private final ClientFactory cf;
    //ref to the interfaces in model
    private MessageModel messageModel;

    public ModelFactory(ClientFactory cf){
        this.cf=cf;
    }

    //return model interface
    public MessageModel getMessageModel() {
        if(messageModel == null)
        {
            messageModel=new MessageManager(cf.getClient());
        }
        return messageModel;
    }
}
