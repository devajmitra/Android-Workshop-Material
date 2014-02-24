package com.inorexstudio.proximitysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mSensor;
	//PowerManager pm;
	//WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		
		//pm =(PowerManager) getSystemService(POWER_SERVICE);
		//wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		//mSensorManager.unregisterListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.values[0] == 0) {
			Toast.makeText(this, "object detected", Toast.LENGTH_SHORT).show();
		} else {
			Log.e("e", "in");
			//wl.acquire(4000);
		}
	}

}
