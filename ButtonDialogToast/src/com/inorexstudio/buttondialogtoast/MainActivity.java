package com.inorexstudio.buttondialogtoast;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button toastButton = (Button) findViewById(R.id.toastButton);
		Button notificationButton = (Button) findViewById(R.id.notificationButton);

		toastButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast sampleToast = Toast.makeText(MainActivity.this,
						"Yo, this is a toast!", Toast.LENGTH_LONG);
				sampleToast.show();
			}
		});

		notificationButton.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notification.Builder builder = new Notification.Builder(MainActivity.this);
				Notification notification = builder.setContentTitle("Notification Title")
					.setContentText("Notification text")
					.setSmallIcon(R.drawable.ic_launcher)
					.setWhen(System.currentTimeMillis())
					.setTicker("hello")
				    .setAutoCancel(true)
					.build();
				
				NotificationManager notificationManager =
		                (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
		        notificationManager.notify(0, notification);
				
				
			}
		});
	}

	public void showDialog(View v) {
		AlertDialog.Builder dialogBuilder = new Builder(this);
		AlertDialog dialog = dialogBuilder.setTitle("Dialog title")
				.setMessage("Dialog message here")
				.setPositiveButton("Cool!", null).create();
		dialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
