package com.qlsv.moduls;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import android.provider.OpenableColumns;

import com.qlsv.interfaces.IDataProvider;

public class DataProvider implements IDataProvider {

	@Override
	public boolean Insert(SinhVien sv,OutputStreamWriter osw) {
		try {
			
			/*PrintWriter pw = new PrintWriter(fos);
			Writer w = null;
			pw.append(sv.getTen() + " " + sv.getNgaysinh() + " " + sv.getDiachi());*/
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(sv.getTen() + " " + sv.getNgaysinh() + " " + sv.getDiachi());
			bw.newLine();
			//pw.close();
			bw.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public ArrayList<SinhVien> getAll() {
		return null;
		// TODO Auto-generated method stub
		
	}

}
