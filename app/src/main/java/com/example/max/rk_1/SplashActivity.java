package com.example.max.rk_1;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SplashActivity extends Activity {
    MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myTask = new MyTask();
        myTask.execute();
    }

    public void openMain(String technologies){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("technologies", technologies);
        startActivity(intent);
    }

    class MyTask extends AsyncTask<Void, Void, String> {

        //выполняется перед doInBackground, имеет доступ к UI
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            tvInfo.setText("Begin");
        }

        //будет выполнен в новом потоке, здесь решаем все свои тяжелые задачи. Т.к. поток не основной - не имеет доступа к UI.
        @Override
        protected String doInBackground(Void... params) {
            String technologies = "";
            try {
                URL url = new URL("http://mobevo.ext.terrhq.ru/shr/j/ru/technology.js");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(2000);
                int sc = con.getResponseCode();
                if (sc == 200) {
                    InputStream is = con.getInputStream();
                    technologies = readResponse(is);
                    is.close();
                } else {
                    System.out.println("все очень плохо");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return technologies;
        }


        /**
         * Reads the response from the input stream and returns it as a string.
         */
        private String readResponse(InputStream is) throws IOException {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] data = new byte[2048];
            int len = 0;
            while ((len = is.read(data, 0, data.length)) >= 0) {
                bos.write(data, 0, len);
            }
            return new String(bos.toByteArray(), "UTF-8");
        }

        //выполняется после doInBackground (не срабатывает в случае, если AsyncTask был отменен), имеет доступ к UI
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            SplashActivity.this.openMain(result);
        }
    }
}
