package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class searchDynasty {
    public String searchInforTrieuDai(String wantSearch) {
        String inforTextOut = null;
        wantSearch = wantSearch.toUpperCase();
        File f = new File("./Data/Dynasty.json");
        JsonObject dynasty = new JsonObject();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"))) {
            JsonParser parser = new JsonParser();
            JsonArray a = (JsonArray) parser.parse(reader);
            for (Object o : a) {
                dynasty = (JsonObject) o;
                String name = String.valueOf(dynasty.get("tenTrieuDai")).toUpperCase();
                if (name.indexOf(wantSearch) != -1) {
                    inforTextOut = "Tên triều đại: " + dynasty.get("tenTrieuDai") + "\n";
                    inforTextOut += "Thời gian tồn tại: " + dynasty.get("thoiGian") + "\n";
                    inforTextOut += "Vị thế: " + dynasty.get("viThe") + "\n";
                    inforTextOut += "Tôn giáo chính: " + dynasty.get("tonGiaoChinh") + "\n";
                    inforTextOut += "Chính Phủ: " + dynasty.get("chinhPhu") + "\n";
                    inforTextOut += "Thủ đô: " + dynasty.get("thuDo") + "\n";
                    inforTextOut += "Tên nước: " + dynasty.get("tenNuoc") + "\n";
                    inforTextOut += "\n";

                    inforTextOut += "Nhân vật liên quan: " ;
                    JsonArray nvs = (JsonArray) dynasty.get("listNhanVat");
                    if (nvs != null) {
                        for (Object nv : nvs) {
                            JsonObject nhanVat = (JsonObject) nv;
                            inforTextOut += nhanVat.get("TenHuy") + " ,";
                        }
                    }
                    inforTextOut += "\n";

                    inforTextOut += "Di tích liên quan: " ;
                    JsonArray dts = (JsonArray) dynasty.get("listDiTich");
                    if (dts != null) {
                        for (Object dt : dts) {
                            JsonObject diTich = (JsonObject) dt;
                            inforTextOut += diTich.get("tenDiTich") + " ,";
                        }
                    }

                    inforTextOut += "\n";

                    inforTextOut += "Sự kiện liên quan: " ;
                    JsonArray sks = (JsonArray) dynasty.get("listSuKien");
                    if (sks != null) {
                        for (Object sk : sks) {
                            JsonObject suKien = (JsonObject) sk;
                            inforTextOut += suKien.get("noiDungSuKien") + " ,";
                        }
                    }
                    inforTextOut += "\n";
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inforTextOut;
    }

}