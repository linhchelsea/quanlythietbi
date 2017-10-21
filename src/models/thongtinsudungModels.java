package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ThongTinBaoDuong;
import library.LibraryConnectDB;

public class thongtinsudungModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public thongtinsudungModels(){
		lcdb = new LibraryConnectDB();
	}
}
