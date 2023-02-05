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

import Entity.TrangNguyenVietNam;

public class CrawlTrangNguyen {
    public CrawlTrangNguyen() throws IOException{
        ArrayList<TrangNguyenVietNam> TList=new ArrayList<>();
        Document doc=Jsoup.connect("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Tr%E1%BA%A1ng_nguy%C3%AAn_Vi%E1%BB%87t_Nam").get();
        Elements body=doc.select("#mw-content-text > div.mw-parser-output > center > table > tbody");//
        for (int i = 1; i < body.select("tr").size(); i++) {
            Element element=body.select("tr").get(i);
            if(element.children().select("td").size()!=7) continue;
            TrangNguyenVietNam tn =new TrangNguyenVietNam(
                    element.select("td").get(1).text(),
                    element.select("td").get(2).text(),
                    element.select("td").get(3).text(),
                    element.select("td").get(4).text(),
                    element.select("td").get(5).text(),
                    element.select("td").get(6).text()
            );
            TList.add(tn);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(TList);
        try{
            FileWriter file = new FileWriter("./Data/Trangnguyen.json");
            file.write(dy);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    }

