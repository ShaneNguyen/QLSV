package com.qlsv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qlsv.R.id;
import com.qlsv.interfaces.IDataProvider;
import com.qlsv.moduls.DataProvider;
import com.qlsv.moduls.SinhVien;

public class ActivityThemSinhVien extends Activity {

	EditText ten, ngaysinh, diachi;
	Button xoa, luu;
	TextView textview_ten, textview_ngaysinh, textview_diachi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_them_sinh_vien);

		textview_ten = (TextView) findViewById(id.textView_Ten);
		textview_ngaysinh = (TextView) findViewById(id.textView_NgaySinh);
		textview_diachi = (TextView) findViewById(id.textView_DiaChi);
		ten = (EditText) findViewById(id.editText_Ten);
		ngaysinh = (EditText) findViewById(id.editText_NgaySinh);
		diachi = (EditText) findViewById(id.editText_DiaChi);
		luu = (Button) findViewById(id.button_Luu);
		xoa = (Button) findViewById(id.button_Xoa);

		luu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String msg = "Không được rỗng";
				if (isEmpty(ten)) {
					showMessage(textview_ten.getText() + msg);
					ten.requestFocus();
				} else if (isEmpty(ngaysinh)) {
					showMessage(textview_ngaysinh.getText() + msg);
					ngaysinh.requestFocus();
				} else if (isEmpty(diachi)) {
					showMessage(textview_diachi.getText() + msg);
					diachi.requestFocus();
				} else {
					InsertStudent();
				}
			}
		});
		xoa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ten.setText("");
				ten.requestFocus();
				ngaysinh.setText("");
				diachi.setText("");
			}
		});

	}

	public void showMessage(String s) {
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
	}

	protected boolean isEmpty(EditText editText) {
		return editText.getText().toString().trim().isEmpty();
	}

	protected void InsertStudent() {

		OutputStreamWriter fos = null;
		SinhVien sv = new SinhVien();
		sv.setTen(ten.getText().toString());
		sv.setNgaysinh(ngaysinh.getText().toString());
		sv.setDiachi(diachi.getText().toString());
		try {
			fos = new OutputStreamWriter(openFileOutput("dssv.txt", MODE_APPEND));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IDataProvider data = new DataProvider();
		boolean result = data.Insert(sv, fos);
		if (result) {
			Toast.makeText(this, "Them sinh vien thanh cong",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Khong thanh cong", Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_them_sinh_vien, menu);
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
