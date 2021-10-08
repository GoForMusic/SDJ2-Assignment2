package chat.Client;

import chat.Client.core.ClientFactory;
import chat.Client.core.ModelFactory;
import chat.Client.core.ViewHandler;
import chat.Client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private ClientFactory cf;


    @Override
    public void start(Stage stage) throws Exception {
        cf= new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop client");
        cf.getClient().unRegisterClient();
    }
}
