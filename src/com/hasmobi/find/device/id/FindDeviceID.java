package com.hasmobi.find.device.id;

import android.os.Bundle;
import android.provider.Settings.Secure;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class FindDeviceID extends Activity {

	String deviceId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_find_device_id);
		deviceId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
		TextView tv = (TextView) findViewById(R.id.idholder);
		tv.setText(deviceId);

	}

	public void emailHandler(View v) {
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				getResources().getString(R.string.emailSubject));
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, deviceId);
		startActivity(emailIntent);
	}
}
