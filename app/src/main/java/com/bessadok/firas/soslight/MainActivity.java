package com.bessadok.firas.soslight;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bessadok.firas.soslight.morseutils.MorseCode;
import com.bessadok.firas.soslight.morseutils.MorseCodeUtils;
import com.bessadok.firas.soslight.morseutils.MorseLetter;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Button sosButton;

    private Camera camera;
    private Camera.Parameters cameraON;
    private Camera.Parameters cameraOFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        sosButton = (Button) findViewById(R.id.button);
        sosButton.setSelected(Camera.Parameters.FLASH_MODE_TORCH.equals(camera.getParameters().getFlashMode()));
        sosButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    lightWritting("SOS");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void lightWritting(String message) throws InterruptedException {
        for (MorseLetter morseLettre : MorseCodeUtils.INSTANCE.toMorseCode(message)) {
            for (MorseCode morseCode : morseLettre.getMorseSequence()) {
                camera.setParameters(cameraON);
                if ( MorseCode.POINT.equals(morseCode) ) {
                    Thread.sleep(MorseCodeUtils.POINT_DELAY);
                } else if ( MorseCode.LINE.equals(morseCode) ) {
                    Thread.sleep(MorseCodeUtils.LINE_DELAY);
                }
                camera.setParameters(cameraOFF);
                Thread.sleep(MorseCodeUtils.POINT_DELAY);
            }
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
