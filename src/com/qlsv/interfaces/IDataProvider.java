package com.qlsv.interfaces;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.qlsv.moduls.SinhVien;

public interface IDataProvider {
	public ArrayList<SinhVien> getAll();
	public boolean Insert(SinhVien sv,OutputStreamWriter usw);
	
}
