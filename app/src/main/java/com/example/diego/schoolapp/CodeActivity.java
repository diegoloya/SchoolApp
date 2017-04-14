package com.example.diego.schoolapp;

import android.*;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
import java.util.Date;

public class CodeActivity extends AppCompatActivity {

    String qrData;
    Date lastCheckedIn;
    int REQUEST_CODE_ASK_PERMISSION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        int hasReadContractsPermission = ContextCompat.checkSelfPermission(CodeActivity.this, android.Manifest.permission.CAMERA);

        if (hasReadContractsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(CodeActivity.this, android.Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(CodeActivity.this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_CODE_ASK_PERMISSION);
                return;
            }
        }
        ActivityCompat.requestPermissions(CodeActivity.this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_CODE_ASK_PERMISSION);

        final SurfaceView cameraView = (SurfaceView) findViewById(R.id.camera_view);

        final Button bConfirm = (Button) findViewById(R.id.button_confirm);
        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Intent goes here
                * */
                //if(CurrentDate< lastCheckedIn){
                Toast.makeText(CodeActivity.this, "confirm works", Toast.LENGTH_LONG).show();
                //}
            }
        });
        bConfirm.setVisibility(View.INVISIBLE);

        final EditText barcodeInfo = (EditText) findViewById(R.id.code_info);
        barcodeInfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg) {
                bConfirm.post(new Runnable() {
                    public void run() {
                        bConfirm.setVisibility(View.VISIBLE);
                    }
                });

                qrData = barcodeInfo.getText().toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();

        CameraSource cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        if (cameraSource != null) {
            final CameraSource finalCameraSource = cameraSource;

            cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    try {

                        finalCameraSource.start(cameraView.getHolder());
                    } catch (IOException ie) {
                        Log.e("CAMERA SOURCE", ie.getMessage());
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    finalCameraSource.stop();
                }
            });
        }
        else{
            Toast.makeText(CodeActivity.this, "no camera source", Toast.LENGTH_LONG).show();
        }

        if(barcodeDetector != null){
            barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<Barcode> detections) {

                    final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                    if (barcodes.size() != 0) {
                        barcodeInfo.post(new Runnable() {    // Use the post method of the TextView
                            public void run() {
                                barcodeInfo.setText(barcodes.valueAt(0).displayValue);
                            }
                        });
                    }
                }
            });
        }
        else{
            Toast.makeText(CodeActivity.this, "barcode reader failed to start", Toast.LENGTH_LONG).show();
        }
    }
}
