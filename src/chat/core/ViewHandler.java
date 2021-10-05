package chat.core;

import chat.views.ViewController;
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


    //open the first scene
    public void start()
    {
        openLoginScene();
    }

    public ViewHandler(ViewModelFactory vmf)
    {
        this.vmf = vmf;
        mainStage = new Stage();
    }

    //Add open method for specific scene
    public void openLoginScene()  {

        try {
            loginScene= getScene("../views/login/Login.fxml");

        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.setTitle("Heating Controller");
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
