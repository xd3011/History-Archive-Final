package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class searchLeHoi {
	public String searchInforLeHoi(String wantSearch) {
        String inforTextOut = null;
        wantSearch = wantSearch.toUpperCase();

        File f = new File("./Data/LeHoiVanHoa.json");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))){
            JsonParser parser = new JsonParser();
            JsonArray a = (JsonArray) parser.parse(reader);
            for(Object o: a){
                JsonObject lh = (JsonObject) o;
                String name = String.valueOf(lh.get("tenLeHoi")).toUpperCase();
                if(name.indexOf(wantSearch) != -1){
                    inforTextOut = "Tên lễ hội: " + lh.get("tenLeHoi") + "\n";
                    inforTextOut += "Thời gian tổ chức: " + lh.get("thoiGianToChuc") + "\n";
                    inforTextOut += "Lần đầu tổ chức: " + lh.get("lanDauToChuc") + "\n";
                    inforTextOut += "Địa điểm: " + lh.get("diaDiem") + "\n";
                    inforTextOut += "Chi chú: " + lh.get("ghiChu") + "\n";

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return inforTextOut;
    }
}
