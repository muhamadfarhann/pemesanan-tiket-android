package firstbelajar.digitalsoftware.pemesanantiket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAct extends AppCompatActivity {

    TextView btn_buat_akun;
    Button btn_login;
    EditText xusername, xpassword;

    DatabaseReference reference;

    String USERNAME_KEY = "username_key";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_buat_akun = findViewById(R.id.btn_buat_akun);
        btn_login = findViewById(R.id.btn_login);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);

        btn_buat_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterone = new Intent(LoginAct.this, RegistSatuAct.class);
                startActivity(gotoregisterone);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ubah state menjadi loading
                btn_login.setEnabled(false);
                btn_login.setText("Loading..");

                final String username = xusername.getText().toString();
                final String password = xpassword.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            // Mengambil data password dari firebase
                            String passwordDariFirebase = dataSnapshot.child("password").getValue().toString();

                            // Validasi password dengan password yang terdapat pada firebase
                            if(password.equals(passwordDariFirebase)){

                                // Menyimpan username key kepada local
                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(username_key, xusername.getText().toString());
                                editor.apply();

                                // Pindah Activity
                                Intent gotohome = new Intent(LoginAct.this, HomeAct.class);
                                startActivity(gotohome);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Username tidak ada bosku", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Database error cuy", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
