package com.solution.tecno.cronomascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.solution.tecno.cronomascotas.Firebase.MyFirebaseInstanceIdService;

public class HomeActivity extends AppCompatActivity {
    TextView not_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MyFirebaseInstanceIdService serv = new MyFirebaseInstanceIdService();
        serv.onTokenRefresh2(this);
        String token = FirebaseInstanceId.getInstance().getToken();
        not_id = findViewById(R.id.txt_notification_id);
        not_id.setText(token);
        System.out.println(token);
    }
}
