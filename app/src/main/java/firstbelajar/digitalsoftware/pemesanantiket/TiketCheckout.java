package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TiketCheckout extends AppCompatActivity {

    Button btn_buy_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_checkout);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessbuyticket = new Intent(TiketCheckout.this, SuksesBeliTiket.class);
                startActivity(gotosuccessbuyticket);
            }
        });
    }
}
