package chat.Client.core;

import chat.Client.network.Client;
import chat.Client.network.RMIClient;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client==null){
            client=new RMIClient();
        }
        return client;
    }
}
