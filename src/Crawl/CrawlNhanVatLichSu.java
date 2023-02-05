package Crawl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entity.NhanVatLichSu;

public class CrawlNhanVatLichSu {
	public CrawlNhanVatLichSu() throws IOException {
        ArrayList<NhanVatLichSu> List=new ArrayList<>();
        Document doc=Jsoup.connect("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam").get();
        Elements body = doc.select("#mw-content-text > div.mw-parser-output ");
        Elements table = body.select("table.toccolours");
        Elements table1 = body.select("table.wikitable");
        Elements table2 = body.select("table[cellpadding='2']");
        Elements table3 = body.select("table.nowraplinks");
        for(Element e : table) {
        	e.remove();
        }
        for(Element e : table1) {
        	e.remove();
        }
        for(Element e : table2) {
        	e.remove();
        }
        for(Element e : table3) {
        	e.remove();
        }
        for (int i = 1; i < body.select("tr").size(); i++) {
            Element element = body.select("table tr").get(i);
            Elements sup = element.select("td sup.reference");
            for(Element e : sup) {
            	e.remove();
            }
            NhanVatLichSu nv =new NhanVatLichSu(
            		element.select("td:nth-child(2)").text(),
            		element.select("td:nth-child(3)").text(),
            		element.select("td:nth-child(4)").text(),
            		element.select("td:nth-child(5)").text(),
            		element.select("td:nth-child(6)").text(),
            		element.select("td:nth-child(7)").text(),
            		element.select("td:nth-child(8)").text() +
            		element.select("td:nth-child(9)").text() + element.select("td:nth-child(10)").text()
            );
            List.add(nv);
        }
//        Convert add to json.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(List);
        try{
//        	Add json to file
            FileWriter file = new FileWriter("./Data/VuaVietNam.json");
            file.write(dy);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
