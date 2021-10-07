package chat.server.networking;

import chat.server.model.TextManager;
import chat.shared.transferoobjects.Messages;
import chat.shared.transferoobjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable{
    private Socket socket;
    private TextManager messageManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, TextManager messageManager){

        this.socket=socket;
        this.messageManager=messageManager;

        try{
            outToClient=new ObjectOutputStream(socket.getOutputStream());
            inFromClient=new ObjectInputStream(socket.getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            if("Listener".equals(request.getType())) {
                messageManager.addListener("NewTextEntry", this::onNewLogEntry);
            } else if("Uppercase".equals(request.getType())) {
                String result = messageManager.sendMessages((String) request.getArg());
                outToClient.writeObject(new Request("message", result));
            } else if("FetchLog".equals(request.getType())) {
                List<Messages> messages = messageManager.getMessages();
                outToClient.writeObject(new Request("FetchMessages", messages));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        try {
            outToClient.writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
