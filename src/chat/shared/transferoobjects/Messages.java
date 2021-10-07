package chat.shared.transferoobjects;

import java.io.Serializable;

public class Messages implements Serializable {
    private String input, output;

    public Messages(String input, String output)
    {
        this.input=input;
        this.output=output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}
