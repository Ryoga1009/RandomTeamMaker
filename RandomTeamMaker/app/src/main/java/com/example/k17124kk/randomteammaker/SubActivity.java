package com.example.k17124kk.randomteammaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by k17124kk on 2017/11/24.
 */

public class SubActivity extends AppCompatActivity {


    private int Member;
    private int Team;

    private TextView ResultText;
    private TextView NumText;

    private Button ResultButton;

    private int checker[],Max[];

    private int count;
    private int oneTeam;
    private int n;


    private  Random random = new Random();
    private boolean AllJadger = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        Member = intent.getIntExtra("Member", 0);
        Team = intent.getIntExtra("Team", 0);


        ResultText = (TextView) findViewById(R.id.ResultText);
        NumText = (TextView) findViewById(R.id.NumText);

        ResultButton = (Button)findViewById(R.id.ResultButton);

        n = Member % Team;//端数



        Log.d("Error","%");


        Toast.makeText(this, "人数またはチームのどちらかのみが奇数または偶数の場合、最後の一人はご自分たちでなんとかしてください", Toast.LENGTH_LONG).show();

        Log.d("Error","end if");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Error","res_sub");


        oneTeam = Member/Team;

        checker = new int[Team];
        Max = new int[Team];


        Log.d("Error","init");
        //初期化
        for(int i = 0;i<Team;i++){
            if(i < n) {
                Max[i] = oneTeam + 1;//端数人数分、チームの最大人数を増やす
            }
            else Max[i] = oneTeam;
        }

        Log.d("Error","end init");



        ResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Error","clickButton");

                boolean jadge = true;//ループ用

                int index = random.nextInt(Team);//乱数(配列番号)取得

                if(AllJadger) {
                    while (jadge) {


                        Log.d("Error", "while");


                        if (checker[index] == Max[index]) {//乱数で出た配列番号が埋まっているなら
                            Log.d("Error", "if");
                            jadge = true;

                            index = random.nextInt(Team);

                        } else {//埋まってないなら
                            checker[index]++;
                            jadge = false;//ループ中止
                            Log.d("Error", "else");
                            Log.d("Error", (count + 1) + "人目" + (index + 1) + "班" + "この班は今" + checker[index] + "人");
                        }


                    }


                    NumText.setText((count + 1) +"人目");
                    ResultText.setText("チーム" + (index+1) +"です");



                    int num = 0;

                    //全部入りきってるかの判定
                    for(int i = 0;i < Team;i++){
                        if(checker[i]==Max[i]){
                            num++;
                        }
                    }

                    //全部入りきってるなら終了準備
                    if((num == Team)||(count == Member)){
                        ResultButton.setText("戻る");
                        AllJadger = false;
                    }



                }else{//終了準備状態でボタンが押されたなら終了
                    finish();
                }



                count++;






            }
        });







    }
}
