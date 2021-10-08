package chat.Client.core;


import chat.Client.views.chat.ChatViewModel;

public class ViewModelFactory {
    private final ModelFactory mf;
    //add VM
    private ChatViewModel chatViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    //return VMS
    public ChatViewModel getChatViewModel(){
        if(chatViewModel == null)
        {
            chatViewModel=new ChatViewModel(mf.getChat());
        }
        return chatViewModel;
    }
}
