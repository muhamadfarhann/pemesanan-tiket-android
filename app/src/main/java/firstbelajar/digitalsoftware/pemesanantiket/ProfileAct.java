package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProfileAct extends AppCompatActivity {

    LinearLayout item_my_ticket;
    Button btn_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        item_my_ticket = findViewById(R.id.item_my_ticket);
        btn_edit_profile = findViewById(R.id.btn_edit_profile);

        item_my_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyticket = new Intent(ProfileAct.this, MyTiketDetail.class);
                startActivity(gotomyticket);
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoeditprofile = new Intent(ProfileAct.this, EditProfil.class);
                startActivity(gotoeditprofile);
            }
        });
    }
}
