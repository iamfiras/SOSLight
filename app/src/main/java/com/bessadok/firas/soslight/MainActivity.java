package com.bessadok.firas.soslight;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cengalabs.flatui.FlatUI;


public class MainActivity extends ActionBarActivity {

    private static final int STANDARD_DELAY = 250;
    private static final int POINT_DELAY = STANDARD_DELAY;
    private static final int LINE_DELAY = STANDARD_DELAY * 3;
    private static final int BETWEEN_LETTERS_DELAY = LINE_DELAY;

    private Button sosButton;

    private TextView sosText1;
    private TextView sosText2;
    private TextView sosText3;

    private Camera camera;
    private Camera.Parameters cameraON;
    private Camera.Parameters cameraOFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlatUI.initDefaultValues(this);
        FlatUI.setDefaultTheme(FlatUI.BLOOD);

        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(FlatUI.getActionBarDrawable(this, FlatUI.BLOOD, false, 2));

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "This device doesn't have a camera");
            return;
        }

        camera = Camera.open();
        camera.startPreview();

        cameraON = camera.getParameters();
        cameraON.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cameraOFF = camera.getParameters();
        cameraOFF.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

        sosText1 = (TextView) findViewById(R.id.sosText1);
        sosText2 = (TextView) findViewById(R.id.sosText2);
        sosText3 = (TextView) findViewById(R.id.sosText3);

        sosButton = (Button) findViewById(R.id.button);
        sosButton.setSelected(Camera.Parameters.FLASH_MODE_TORCH.equals(camera.getParameters().getFlashMode()));
        sosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SOSWriting().execute();
            }
        });
    }

    private class SOSWriting extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                sosLightWriting();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPreExecute () {
            sosButton.setEnabled(false);
        }

        protected void onProgressUpdate (String... values) {
            sosText1.setText(Html.fromHtml(values[0]));
            sosText2.setText(Html.fromHtml(values[1]));
            sosText3.setText(Html.fromHtml(values[2]));
        }

        protected void onPostExecute(Void result) {
            sosButton.setEnabled(true);
        }

        private void sosLightWriting() throws InterruptedException {
            publishProgress("<font color='#000000'>S</font>", "<font color='#DDDDDD'>O</font>", "<font color='#DDDDDD'>S</font>");

            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(BETWEEN_LETTERS_DELAY);

            publishProgress("<font color='#000000'>S</font>", "<font color='#000000'>O</font>", "<font color='#DDDDDD'>S</font>");

            camera.setParameters(cameraON);
            Thread.sleep(LINE_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(LINE_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(LINE_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(BETWEEN_LETTERS_DELAY);

            publishProgress("<font color='#000000'>S</font>", "<font color='#000000'>O</font>", "<font color='#000000'>S</font>");

            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraON);
            Thread.sleep(POINT_DELAY);
            camera.setParameters(cameraOFF);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
