package murillo.silva.firebasestorage.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import murillo.silva.firebasestorage.R;

public class StorageShareActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagemtop;
    private ProgressBar progressBar;
    private ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_share);
        imagemtop = (ImageView) findViewById(R.id.imageView);
        share = (ImageView) findViewById(R.id.shareFile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        share.setOnClickListener(this);

        //todo teste um dous

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shareFile:
                download_imagem();


                break;

        }
    }


    //todo criar menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_storage_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.compImageView:
                compartilhar();
                return true;

            case R.id.item_criar_pdf:

                Toast.makeText(getBaseContext(), "Criar PDF", Toast.LENGTH_LONG).show();
                return true;

                //todo teste aaaaaaaaaaaaaaaaa

        }

        //todo teste um dous

        return super.onOptionsItemSelected(item);
    }

    //todo teste um dous

    private void download_imagem() {
        //String url = "https://firebasestorage.googleapis.com/v0/b/mobile-eab04.appspot.com/o/logo-uber-2048.png?alt=media&token=b577366b-a0fd-44f5-8bd5-1a16542992a4";
        String url = "https://www.istoedinheiro.com.br/wp-content/uploads/sites/17/2021/10/udemy-logo-highres.jpg";
        Picasso.with(getBaseContext()).load(url).into(imagemtop, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {

            }
        });
    }

    private void compartilhar() {
        if (imagemtop.getDrawable() != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpeg");
            BitmapDrawable drawable = (BitmapDrawable) imagemtop.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Imagem ", null);
            Uri uri = Uri.parse(path);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent, "Murillo Android File Provider"));

        } else {
            Toast.makeText(getBaseContext(), "Nao possui imagem", Toast.LENGTH_LONG).show();
        }

        //todo teste um dous

    }
    //todo aqui seria meu projeto que foi alterado por outra pessoa
    // --> projeto que a pessoa subiu para a minha branch

    //todo teste aaaaaaaaaaaaaaaaa

}