package com.example.projetembarque.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * This class is extending the button class with an integer and a string added to it.
 * This integer make us able to link the Response class with this class and know if this button contains the right answer, while the String will display the answer of this button
 */
public class ButtonResponse extends Button {
    private int responseInt;
    private String responseString;

    public ButtonResponse(Context context) {
        super(context);
    }

    public ButtonResponse(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonResponse(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ButtonResponse(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
