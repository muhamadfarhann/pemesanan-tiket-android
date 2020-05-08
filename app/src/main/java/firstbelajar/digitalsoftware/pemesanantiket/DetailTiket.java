package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailTiket extends AppCompatActivity {

    Button btn_buy_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tiket);

        Bundle bundle = getIntent().getExtras();
        String jenis_tiket_baru = bundle.getString("jenis_tiket");

        Toast.makeText(getApplicationContext(), "Jenis Tiket : " + jenis_tiket_baru, Toast.LENGTH_SHORT).show();

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocheckout = new Intent(DetailTiket.this, TiketCheckout.class);
                startActivity(gotocheckout);
            }
        });
    }
}
