package chat.Client.views;

import chat.Client.core.ViewHandler;
import chat.Client.core.ViewModelFactory;

public interface ViewController {
    void init(ViewHandler vh, ViewModelFactory vmf);
}
