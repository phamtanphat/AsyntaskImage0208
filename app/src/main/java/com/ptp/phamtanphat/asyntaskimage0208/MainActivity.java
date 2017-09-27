package com.ptp.phamtanphat.asyntaskimage0208;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imginternet;
    Button btnshowimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imginternet = (ImageView) findViewById(R.id.imageviewInternet);
        btnshowimage = (Button) findViewById(R.id.buttonxuly);

        btnshowimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetImage().execute("https://orig04.deviantart.net/67cd/f/2012/309/8/c/android_icon_by_gabrydesign-d4m7he9.png");
            }
        });
    }
    private class GetImage extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(strings[0]);

                InputStream inputStream = url.openConnection().getInputStream();
                 bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imginternet.setImageBitmap(bitmap);
            super.onPostExecute(bitmap);
        }
    }
}
