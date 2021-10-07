package chat.client.core;

import chat.client.networking.Client;
import chat.client.networking.SocketClient;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client == null)
        {
            client=new SocketClient();
        }
        return client;
    }
}
