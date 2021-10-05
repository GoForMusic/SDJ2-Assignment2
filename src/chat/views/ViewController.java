package chat.views;

import chat.core.ViewHandler;
import chat.core.ViewModelFactory;

public interface ViewController {
    public void init(ViewHandler vh, ViewModelFactory vfm);
}
