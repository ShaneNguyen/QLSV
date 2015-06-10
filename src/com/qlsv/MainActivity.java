package com.qlsv;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn_them, btn_tim;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btn_them = (Button) findViewById(R.id.btn_Them);
		btn_tim = (Button) findViewById(R.id.btn_Tim);
		OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.btn_Them){
					intent = new Intent(MainActivity.this,ActivityThemSinhVien.class);
					startActivity(intent);
				}
				if(v.getId() == R.id.btn_Tim){
					intent = new Intent(MainActivity.this,ActivityTimSinhVien.class);
					startActivity(intent);
				}
			}
		};
		btn_them.setOnClickListener(clickListener);
		btn_tim.setOnClickListener(clickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
