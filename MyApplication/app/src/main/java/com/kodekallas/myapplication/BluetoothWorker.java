package com.kodekallas.myapplication;

/**
 * Created by sravisankaran on 6/17/16.
 */


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothClass.Device;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import static android.support.v4.app.ActivityCompat.startActivity;


public class BluetoothWorker {


    public void sendFile() {
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

        if (btAdapter == null) {
            // Device does not support Bluetooth
            // Inform user that we're done.
        }
        // bring up Android chooser
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        File file_to_transfer=null;

        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file_to_transfer) );
//...




    }
}