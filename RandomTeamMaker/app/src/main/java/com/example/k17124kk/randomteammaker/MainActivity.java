package com.example.k17124kk.randomteammaker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner MemberSpinner;
    private Spinner TeamSpinner;
    private Button StartButton;
    private TextView ResultText;
    private TextView NumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MemberSpinner = (Spinner)findViewById(R.id.MemberSpinner);
        TeamSpinner = (Spinner)findViewById(R.id.TeamSpinner);
        StartButton = (Button)findViewById(R.id.StartButton);
        // ResultText = (TextView)findViewById(R.id.ResultText);
        //NumText = (TextView)findViewById(R.id.NumText);
    }

    @Override
    protected void onResume() {
        super.onResume();



        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Team_S = (String)TeamSpinner.getSelectedItem();
                Log.d("Error","String");
                int Team = Integer.parseInt(Team_S);
                Log.d("Error","int");
                String Member_S = (String)MemberSpinner.getSelectedItem();
                Log.d("Error","String");
                int Member = Integer.parseInt(Member_S);
                Log.d("Error","int");

                Log.d("Error","button");
                Intent intent = new Intent(getApplication(),SubActivity.class);
                Log.d("Error","start");
                intent.putExtra("Member",Member);
                Log.d("Error","ext");
                intent.putExtra("Team",Team);
                Log.d("Error","ext");
                startActivity(intent);



            }
        });

    }
}
