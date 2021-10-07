package chat.client.core;

import chat.client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory vmf;
    private Stage mainStage;

    //specific scenes
    private Scene loginScene;
    private Scene chatScene;
    private Scene friendListScene;

    //open the first scene
    public void start()
    {
        mainStage = new Stage();
        openLoginScene();
    }

    public ViewHandler(ViewModelFactory vmf)
    {
        this.vmf = vmf;

    }

    //Add open method for specific scene
    public void openLoginScene()  {

        try {
            loginScene= getScene("../views/login/Login.fxml");

        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.setTitle("Login");
        mainStage.setScene(loginScene);
        mainStage.show();

    }
    public void openChatScene()  {

        try {
            loginScene= getScene("../views/chat/Chat.fxml");

        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.setTitle("Chat");
        mainStage.setScene(loginScene);
        mainStage.show();

    }
    public void openFriendListScene()  {

        try {
            loginScene= getScene("../views/friendlist/FriendList.fxml");

        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.setTitle("Friend List");
        mainStage.setScene(loginScene);
        mainStage.show();

    }
//===

    private Scene getScene(String path) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController view = loader.getController();
        view.init(this, vmf);
        return new Scene(root);
    }
}
