package chat.client.views;

import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;

public interface ViewController {
    public void init(ViewHandler vh, ViewModelFactory vfm);
}
