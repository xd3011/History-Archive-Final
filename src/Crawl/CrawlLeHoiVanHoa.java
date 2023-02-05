package Crawl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entity.LeHoiVanHoa;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlLeHoiVanHoa {
    public CrawlLeHoiVanHoa() throws IOException {

        ArrayList<LeHoiVanHoa> Llist =new ArrayList<>();
        Document document = Jsoup.connect("https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam")
                .timeout(1000).get();
        Elements body = document.select("table.prettytable.wikitable tbody");
        int a = 0;
        for (int i = 1; i < body.select("tr").size(); i++) {
            Element element=body.select("tr").get(i);
            if (element.children().select("td").size() != 6) continue;
            LeHoiVanHoa lhvh=new LeHoiVanHoa(element.select("td").get(0).text(),
                    element.select("td").get(1).text(),
                    element.select("td").get(2).text(),
                    element.select("td").get(3).text(),
                    element.select("td").get(4).text(),
                    element.select("td").get(5).text());
            Llist.add(lhvh);
            a++;
        }
        System.out.println(a);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(Llist);
        try{
            FileWriter file = new FileWriter("./Data/LeHoiVanHoa.json");
            file.write(dy);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
