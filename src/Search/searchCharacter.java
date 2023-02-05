package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class searchCharacter {
	public String searchInforCharacter(String wantSearch) {
		String inforTextOut = "";
		wantSearch = wantSearch.toUpperCase();
		File f = new File("./Data/ChuaNguyen.json");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))) {
			JsonParser parser = new JsonParser();
			JsonArray a = (JsonArray) parser.parse(reader);
			for (Object o : a) {
				JsonObject nv = (JsonObject) o;
				String vuongHieu = String.valueOf(nv.get("vuongHieu")).toUpperCase();
				if (vuongHieu.indexOf(wantSearch) != -1) {
					inforTextOut = "Vương Hiệu: " + nv.get("vuongHieu") + "\n";
					inforTextOut += "Miến Hiệu: " + nv.get("mieuHieu") + "\n";
					inforTextOut += "Thụy Hiệu: " + nv.get("thuyHieu") + "\n";
					inforTextOut += "Tên Húy: " + nv.get("tenHuy") + "\n";
					inforTextOut += "Thời gian sống: " + nv.get("thoiGianSong") + "\n";
					inforTextOut += "Ghi chú: " + nv.get("ghiChu") + "\n";

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (inforTextOut.equals("")) {
			f = new File("./Data/Trangnguyen.json");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))) {
				JsonParser parser = new JsonParser();
				JsonArray a = (JsonArray) parser.parse(reader);
				for (Object o : a) {
					JsonObject nv = (JsonObject) o;
					String name = String.valueOf(nv.get("ten")).toUpperCase();
					if (name.indexOf(wantSearch) != -1) {
						inforTextOut = "Tên: " + nv.get("ten") + "\n";
						inforTextOut += "Năm sinh năm mất: " + nv.get("namSinh") + "\n";
						inforTextOut += "Quê: " + nv.get("que") + "\n";
						inforTextOut += "Năm đỗ Trạng nguyên: " + nv.get("namDo") + "\n";
						inforTextOut += "Đời vua " + nv.get("doiVua") + "\n";
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (inforTextOut.equals("")) {
			f = new File("./Data/VuaVietNam.json");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))) {
				JsonParser parser = new JsonParser();
				JsonArray a = (JsonArray) parser.parse(reader);
				for (Object o : a) {
					JsonObject nv = (JsonObject) o;
					String name = String.valueOf(nv.get("Vua")).toUpperCase();
					if (name.indexOf(wantSearch) != -1) {
						inforTextOut = "Vua: " + nv.get("Vua") + "\n";
						inforTextOut += "Miếu Hiệu: " + nv.get("MieuHieu") + "\n";
						inforTextOut += "Thụy Hiệu: " + nv.get("ThuyHieu") + "\n";
						inforTextOut += "Niên Hiệu: " + nv.get("NienHieu") + "\n";
						inforTextOut += "Tên Húy: " + nv.get("TenHuy") + "\n";
						inforTextOut += "Thế Thứ: " + nv.get("TheThu") + "\n";
						inforTextOut += "Trị Vì: " + nv.get("TriVi") + "\n";

						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (inforTextOut.equals(""))
			return null;
		return inforTextOut;
	}
}
