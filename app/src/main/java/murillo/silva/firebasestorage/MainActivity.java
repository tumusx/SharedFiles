package murillo.silva.firebasestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import murillo.silva.firebasestorage.storage.StorageShareActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textNextDownload);

        textView.setOnClickListener(this);
        //todo TESTE

      //todo  aaaaa----- --teste fodaaaa

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getBaseContext(), StorageShareActivity.class);
        startActivity(intent);


    }

  /*  private void permissaoW(){
        String permissoes [] = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        };
    }*/

}