package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TiketCheckout extends AppCompatActivity {

    TextView nama_wisata, lokasi, ketentuan;
    Button btn_buy_ticket, btnmines, btnpls;
    LinearLayout btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_checkout);

        // Mengambil data dari intent
        Bundle bundle = getIntent().getExtras();
        final String jenis_tiket_baru = bundle.getString("jenis_tiket");

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodetailtiket = new Intent(TiketCheckout.this, DetailTiket.class);
                startActivity(gotodetailtiket);
            }
        });

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessbuyticket = new Intent(TiketCheckout.this, SuksesBeliTiket.class);
                startActivity(gotosuccessbuyticket);
            }
        });
    }
}
