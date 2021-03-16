package com.example.projetembarque.controler;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.projetembarque.modele.Player;
/*import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;*/

import java.io.BufferedReader;
import java.io.InputStream;

import io.netty.handler.codec.http.HttpResponse;
import reactor.netty.http.client.HttpClient;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Registration {

    private API api;
    private Object obj;
    Player player;



    public Registration(Object obj, String login, String password, String loginMAL) throws ClassNotFoundException, SQLException {

       /* // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/

        Connection connection ;

        Statement statement ;

        ResultSet resultSet ;
        ResultSetMetaData metaData ;
        int numberOfColumns = 0;



        player = new Player(login, loginMAL, obj);
        this.obj = obj;

        Class.forName("org.mariadb.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mariadb://alexiswidmerdns.ddns.net:2240/AMQCM" ,"AMQCM_user","AMQCM");
        System.out.println("Connection Established");
        statement = connection.createStatement();



        /* Exécution d'une requête de lecture */
        ResultSet resultat = statement.executeQuery( "SELECT idPlayer  FROM Player;" );

        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            int idUtilisateur = resultat.getInt("idPlayer");
            System.out.println("Un user à comme ID");
            System.out.println(idUtilisateur);

            /* Traiter ici les valeurs récupérées. */

        }

    }

    /*public Registration(Object obj, String login, String password, String loginMAL) {
        player = new Player(login, loginMAL, obj);
        this.obj = obj;


    }*/
}
