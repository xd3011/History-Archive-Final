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

import Entity.ChuaNguyen;


public class CrawlChuaNguyen {
    public CrawlChuaNguyen() throws IOException {

        ArrayList<ChuaNguyen> HList=new ArrayList<>();
        Document doc=Jsoup.connect("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_ho%C3%A0ng_%C4%91%E1%BA%BF_nh%C3%A0_Nguy%E1%BB%85n").get();
        Elements body=doc.select("#mw-content-text > div.mw-parser-output > table:nth-child(12) > tbody");
        for (int i = 1; i < body.select("tr").size(); i++) {
            Element element=body.select("tr").get(i);
            if(element.children().select("td").size()!=7) continue;
            ChuaNguyen tn =new ChuaNguyen(
                    element.select("td").get(1).text(),
                    element.select("td").get(2).text(),
                    element.select("td").get(3).text(),
                    element.select("td").get(4).text(),
                    element.select("td").get(5).text(),
                    element.select("td").get(6).text()
            );
            HList.add(tn);
        }
        Elements body1=doc.select("#mw-content-text > div.mw-parser-output > table.sortable");
        for (int i = 1; i < body1.select("tr").size(); i++) {
            Element element = body1.select("tr").get(i);
            ChuaNguyen tn =new ChuaNguyen(
                    element.select("td:nth-child(6)").text(),
                    element.select("td:nth-child(2)").text(),
                    element.select("td:nth-child(3)").text(),
                    element.select("td:nth-child(4)").text(),
                    element.select("td:nth-child(5)").text(),
                    element.select("td:nth-child(7)").text()
            );
            HList.add(tn);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(HList);
        try{
            FileWriter file = new FileWriter("./Data/ChuaNguyen.json");
            file.write(dy);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    }
