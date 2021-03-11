package com.example.projetembarque;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;

/**
 * This class is extending the button class with an integer and a string added to it.
 * This integer make us able to link the Response class with this class and know if this button contains the right answer, while the String will display the answer of this button
 */
public class ButtonResponse extends androidx.appcompat.widget.AppCompatButton {
    private int responseInt;
    private String responseString;

    public ButtonResponse(Context context) {
        super(context);
    }

    public void setResponseInt(int responseInt) {
        this.responseInt = responseInt;
    }

    public int getResponseInt() {
        return this.responseInt;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
        this.setText(this.responseString);
    }

    public String getResponseString() {
        return this.responseString;
    }
}
