package com.hv.statfscompatsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hivedi.statfscompat.StatFsCompat;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.i("tests", "Total: " + StatFsCompat.getStatFsTotal(getCacheDir()));
		Log.i("tests", "Free: " + StatFsCompat.getStatFsFree(getCacheDir()));
	}
}
