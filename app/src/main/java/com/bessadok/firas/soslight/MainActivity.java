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


public class MainActivity extends ActionBarActivity {

    private Camera camera;
    private Camera.Parameters cameraParameters;
    private Button sosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "This device doesn't have a camera");
            return;
        }

        camera = Camera.open();
        cameraParameters = camera.getParameters();
        camera.startPreview();

        sosButton = (Button) findViewById(R.id.button);
        sosButton.setSelected(Camera.Parameters.FLASH_MODE_TORCH.equals(camera.getParameters().getFlashMode()));
        sosButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Camera.Parameters.FLASH_MODE_OFF.equals(camera.getParameters().getFlashMode())) {
                    cameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(cameraParameters);
                    camera.startPreview();
                } else {
                    cameraParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(cameraParameters);
                    camera.stopPreview();
                }
            }
        });
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
