package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class searchRelics {
	public String searchInforRelics(String wantSearch){
        String inforTextOut = null;
        wantSearch = wantSearch.toUpperCase();
        File f = new File("./Data/DiTichLichSu.json");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))){

        	JsonParser parser = new JsonParser();
            JsonArray a = (JsonArray) parser.parse(reader);

            for(Object o: a){
                JsonObject dt = (JsonObject) o;
                String name = String.valueOf(dt.get("tenDiTich")).toUpperCase();
                if(name.indexOf(wantSearch) != -1){
                    inforTextOut = "Tên di Tích: " + dt.get("tenDiTich") + "\n";
                    inforTextOut += "Vị Trị: " + dt.get("viTri") + "\n";
                    inforTextOut += "Vị thế: " + dt.get("viThe") + "\n";
                    inforTextOut += "Loại di tích: " + dt.get("loaiDiTich") + "\n";
                    inforTextOut += "Năm công nhận: " + dt.get("namCN") + "\n";
                    inforTextOut += "Ghi Chú: " + dt.get("ghiChu") + "\n";
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return inforTextOut;
    }
}
