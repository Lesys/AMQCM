package com.example.projetembarque.controler;

import com.example.projetembarque.modele.Player;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PlayerHelper {
    private static final String COLLECTION_NAME = "users";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getUsersCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createUser(String uid, String login) {
        Player userToCreate = new Player(uid, login, "");
        return PlayerHelper.getUsersCollection().document(uid).set(userToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getPlayer(String uid){
        return PlayerHelper.getUsersCollection().document(uid).get();
    }

    // --- GET ---

    public static String getUserLoginMAL(String uid){
        return getPlayer(uid).getResult().getString("loginMAL");
    }

    public static String getUserLogin(String uid){
        return getPlayer(uid).getResult().getString("login");
    }

    // --- UPDATE ---

    public static Task<Void> updateUsername(String username, String uid) {
        return PlayerHelper.getUsersCollection().document(uid).update("login", username);
    }

    public static Task<Void> updateLoginMAL(String loginMAL, String uid) {
        return PlayerHelper.getUsersCollection().document(uid).update("loginMAL", loginMAL);
    }

    // --- DELETE ---

    public static Task<Void> deleteUser(String uid) {
        return PlayerHelper.getUsersCollection().document(uid).delete();
    }
}
