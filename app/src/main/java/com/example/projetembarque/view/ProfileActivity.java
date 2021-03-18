package com.example.projetembarque.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.projetembarque.R;
import com.example.projetembarque.controler.PlayerHelper;
import com.example.projetembarque.modele.Player;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends BaseActivity {

    TextInputEditText textInputEditTextUsername;
    TextInputEditText textInputEditTextLoginMAL;
    TextView textViewEmail;

    private static final int SIGN_OUT_TASK = 10;
    private static final int DELETE_USER_TASK = 20;
    private static final int UPDATE_USERNAME = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //this.configureToolbar();
        textInputEditTextUsername = (TextInputEditText)findViewById(R.id.profile_activity_edit_text_username);
        textInputEditTextLoginMAL = (TextInputEditText)findViewById(R.id.profile_activity_edit_text_loginMAL);
        textViewEmail = (TextView)findViewById(R.id.profile_activity_text_view_email);
        this.updateUIWhenCreating(); // 2 - Update UI
    }


    //@Override
    public int getFragmentLayout() { return R.layout.activity_profile; }

    // --------------------
    // ACTIONS
    // --------------------

    public void onClickUpdateButton(View view) {
        this.updateUsernameInFirebase();
        if (!this.textInputEditTextLoginMAL.getText().toString().equals(""))
            this.updateLoginMALInFirebase();
    }

    private void updateUsernameInFirebase(){

        String username = this.textInputEditTextUsername.getText().toString();

        if (this.getCurrentUser() != null){
            if (!username.isEmpty() &&  !username.equals(getString(R.string.info_no_username_found))){
                PlayerHelper.updateUsername(username, this.getCurrentUser().getUid()).addOnFailureListener(this.onFailureListener()).addOnSuccessListener(this.updateUIAfterRESTRequestsCompleted(UPDATE_USERNAME));
            }
        }
    }

    private void updateLoginMALInFirebase(){

        String username = this.textInputEditTextLoginMAL.getText().toString();

        if (this.getCurrentUser() != null){
            if (!username.isEmpty() &&  !username.equals(getString(R.string.info_no_username_found))){
                PlayerHelper.updateLoginMAL(username, this.getCurrentUser().getUid()).addOnFailureListener(this.onFailureListener()).addOnSuccessListener(this.updateUIAfterRESTRequestsCompleted(UPDATE_USERNAME));
            }
        }
    }

    public void onClickSignOutButton(View view) {this.signOutUserFromFirebase(); }

    // --------------------
    // UI
    // --------------------

    // 1 - Update UI when activity is creating
    private void updateUIWhenCreating(){

        if (this.getCurrentUser() != null){

            //Get email & username from Firebase
            String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
            String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();
            //Update views with data
            this.textInputEditTextUsername.setText(username);
            this.textViewEmail.setText(email);
        }
    }

    private void signOutUserFromFirebase(){
        AuthUI.getInstance()
                .signOut(this)
                .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_TASK));
    }

    private void deleteUserFromFirebase(){
        if (this.getCurrentUser() != null) {
            AuthUI.getInstance()
                    .delete(this)
                    .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(DELETE_USER_TASK));
        }
    }

    private OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted(final int origin){
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                switch (origin){
                    case SIGN_OUT_TASK:
                        finish();
                        break;
                    case DELETE_USER_TASK:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
    }
}