package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GetStartedAct extends AppCompatActivity {

    Button btn_login, btn_buat_akun_dua;
    Animation ttb, btt;
    ImageView emblem_app;
    TextView intro_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        btn_login = findViewById(R.id.btn_login);
        btn_buat_akun_dua = findViewById(R.id.btn_buat_akun_dua);
        emblem_app = findViewById(R.id.emblem_app);
        intro_app = findViewById(R.id.intro_app);

        // Menjalankan animasi
        emblem_app.startAnimation(ttb);
        intro_app.startAnimation(ttb);
        btn_login.startAnimation(btt);
        btn_buat_akun_dua.startAnimation(btt);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotologin = new Intent(GetStartedAct.this, LoginAct.class);
                startActivity(gotologin);
            }
        });

        btn_buat_akun_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(GetStartedAct.this, RegistSatuAct.class);
                startActivity(gotoregisterone);
            }
        });
    }
}
