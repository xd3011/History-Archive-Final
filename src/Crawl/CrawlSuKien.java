package Crawl;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import Entity.SuKienLichSu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Paths;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlSuKien {
    public CrawlSuKien() throws IOException {
        ArrayList<SuKienLichSu> suKienLichSuList = new ArrayList<>();
        final String url = "https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
        final Document doc = Jsoup.connect(url).get();
        Elements h3Tag = doc.select("h3");
        Elements pTag = doc.select("p");
        Elements ddTag = doc.select("dd");
        int a = 0;

        for(Element p:pTag) {
            Element checkTag = p.nextElementSibling();
            if(pTag.contains(checkTag)){
                ArrayList<String> lstNhanVat = new ArrayList<>();
                ArrayList<String> lstTrieuDai = new ArrayList<>();
                Element check1 = p.previousElementSibling();
                while(!h3Tag.contains(check1)){
                    check1 = check1.previousElementSibling();
                }
                Element timeTag = p.child(0);
                Element contentTag = p.clone();
                contentTag.firstElementChild().remove();
                Elements characterTag = p.select("a");
                for(Element c: characterTag){
                    CheckHref check = new CheckHref(c.attr("href"));
                    if(check.checkNhanVat()){
                        lstNhanVat.add(c.text());
                    }
                    if(check.checkTrieuDai()){
                        lstTrieuDai.add(c.text());
                    }
                }
                try{
                    SuKienLichSu skls = new SuKienLichSu(check1.child(1).text(), timeTag.text(), contentTag.text(),
                            lstNhanVat, lstTrieuDai);
                    suKienLichSuList.add(skls);
                    a++;
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }

        for(Element dd: ddTag){
            ArrayList<String> listNhanVat = new ArrayList<>();
            ArrayList<String> listTrieuDai = new ArrayList<>();
            Element check2 = dd.parent().previousElementSibling();
            while(!h3Tag.contains(check2)){
                check2 = check2.previousElementSibling();
            }
            String empire = check2.child(1).text();
            String time = dd.child(0).text();
            time += " năm " + dd.parent().previousElementSibling().text();
            Element tmp = dd.clone();
            tmp.firstElementChild().remove();
            String content = tmp.text();
            Elements character = dd.select("a");
            for(Element c:character){
                CheckHref check = new CheckHref(c.attr("href"));
                if(check.checkNhanVat()){
                    listNhanVat.add(c.text());
                }
                if(check.checkTrieuDai()){
                    listTrieuDai.add(c.text());
                }
            }
            try{
                SuKienLichSu skls = new SuKienLichSu(empire, time, content, listNhanVat, listTrieuDai);
                suKienLichSuList.add(skls);
                a++;
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println(a);
        try{
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("./Data/SuKienLichSu.json").toFile(),suKienLichSuList);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}




