package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class searchEvent {
	public String searchInforEvent(String wantSearch) {
        String inforTextOut = null;
        wantSearch = wantSearch.toUpperCase();
        File f = new File("./Data/SuKienLichSu.json");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))){
        	
        	JsonParser parser = new JsonParser();
            JsonArray a = (JsonArray) parser.parse(reader);
            for(Object o: a){
                JsonObject sk = (JsonObject) o;
                String name = String.valueOf(sk.get("noiDungSuKien")).toUpperCase();
                if(name.indexOf(wantSearch) != -1){
                    inforTextOut = "Thời đại: " + sk.get("thoiDai") + "\n";
                    inforTextOut += "Thời gian xảy ra: " + sk.get("thoiGian") + "\n";
                    inforTextOut += "Nội dung sự kiện: " + sk.get("noiDungSuKien") + "\n";
                    inforTextOut += "Nhân vật lịch sử liên quan: " + sk.get("nhanVat") + "\n";
                    inforTextOut += "Triều đại liên quan: " + sk.get("trieuDai") + "\n";


                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return inforTextOut;
    }
}
