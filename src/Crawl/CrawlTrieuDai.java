package Crawl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entity.TrieuDai;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlTrieuDai {
	private static ArrayList<TrieuDai> listTrieuDai;

	private void addThucThe(TrieuDai newTrieuDai) {
		if (listTrieuDai == null) {
			listTrieuDai = new ArrayList<TrieuDai>();
			listTrieuDai.add(newTrieuDai);
		} else {
			listTrieuDai.add(newTrieuDai);
		}
	}

	public CrawlTrieuDai() throws IOException {
		listTrieuDai = new ArrayList<>();

		Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam").get();

		Elements table = doc.select("#mw-content-text > div.mw-parser-output > div.navbox > table>tbody>tr");

		for (Element tr : table) {
			String text = tr.select("th").text();
			if (text.indexOf("x") != 0 && text.indexOf("Ch") != 0) {
				String texC = tr.select("th>a").text();

				TrieuDai d = new TrieuDai();
				d.setTen(texC);
				d.setThoiGian(text.substring(text.indexOf("("), text.length()));

				String herf = "https://vi.wikipedia.org" + tr.select("th>a").attr("href");
				new WebWikiTrieuDai(herf, d);
				addThucThe(d);
			}
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String dy = gson.toJson(listTrieuDai);

		try {
			FileWriter file = new FileWriter("./Data/Dynasty.json");
			file.write(dy);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
