package Crawl;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entity.DiTichLichSu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CrawlDiTichLichSu {
	private static ArrayList<DiTichLichSu> Llist =new ArrayList<>();

    public CrawlDiTichLichSu() throws IOException {
        Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam").timeout(5000).get();
        Elements body = doc.select("#mw-content-text > div.mw-parser-output > table");
        for(int i = 1; i < body.select("tr").size(); ++i) {
            Element element = (Element)body.select("tr").get(i);
            Elements sup = element.select("td sup");
            for(Element e : sup) {
            	e.remove();
            }
            if (element.children().select("td").size() == 5) {
                DiTichLichSu dtls = new DiTichLichSu();
                dtls.setTenDiTich(((Element)element.select("td").get(0)).text());
                dtls.setViTri(((Element)element.select("td").get(1)).text());
                dtls.setLoaiDiTich(((Element)element.select("td").get(2)).text());
                dtls.setNamCN(((Element)element.select("td").get(3)).text());
                dtls.setGhiChu(((Element)element.select("td").get(4)).text());
                Llist.add(dtls);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(Llist);
        try{
            FileWriter file = new FileWriter("./Data/DiTichLichSu.json");
            file.write(dy);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    }

