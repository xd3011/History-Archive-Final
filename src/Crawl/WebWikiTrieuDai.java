package Crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Entity.DiTichLichSu;
import Entity.NhanVatLichSu;
import Entity.SuKienLichSu;
import Entity.TrieuDai;

import java.io.IOException;

public class WebWikiTrieuDai {

	public WebWikiTrieuDai(String url, TrieuDai trieuDai) {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements firstTable = doc.select("#mw-content-text > div.mw-parser-output > table.infobox > tbody >tr");
			Elements name = doc.select(
					"#mw-content-text > div.mw-parser-output > table.infobox > tbody > tr:nth-child(1) > th > div > span");
			Elements table = doc.select("#mw-content-text > div.mw-parser-output > div > table");
			Elements lastTable = doc.select("#mw-content-text > div.mw-parser-output > div.navbox > table > tr");
			for (Element t : table) {
				if (t.text().indexOf("x t s") != -1) {
					lastTable = t.select("tbody > tr");
					for (Element tr : lastTable) {
						String title = tr.select("th").text();
						if (title.indexOf("Vua") != -1 || title.indexOf("Quân") != -1) {
							crawlNhanVat(tr, trieuDai);
							continue;
						}
						if (title.indexOf("Sự kiện") != -1) {
							crawlSuKien(tr, trieuDai);
							continue;
						}
						if (title.indexOf("Di tích") != -1) {
							crawlDiTich(tr, trieuDai);
						}
					}
				}
			}

			crawltenNuoc(name.text(), trieuDai);

			for (Element i : firstTable) {
				String title = i.select("th").text();
				String td = i.select("td").text();
				String a = i.select("td>  a:nth-child(1)").text();

				if (title.indexOf("Thủ") != -1) {
					if (!a.equals(""))
						crawlThuDo(a, trieuDai);
					else
						crawlThuDo(td, trieuDai);
					continue;
				}
				if (title.indexOf("Vị") != -1) {
					crawlViThe(td, trieuDai);
					continue;
				}
				if (title.indexOf("Tôn") != -1) {
					crawlTonGiao(td, trieuDai);
					continue;
				}
				if (title.indexOf("Chính") != -1) {
					if (!a.equals(""))
						crawlChinhPhu(a, trieuDai);
					else
						crawlChinhPhu(td, trieuDai);
				}
			}

		} catch (IOException e) {
			System.out.println("Error connect");
		}

	}

	private void crawltenNuoc(String tenNuoc, TrieuDai trieuDai) {
		if (!tenNuoc.equals(""))
			trieuDai.setTenNuoc(tenNuoc);
	}

	private void crawlThuDo(String a, TrieuDai trieuDai) {
		trieuDai.setThuDo(a);
	}

	private void crawlViThe(String a, TrieuDai trieuDai) {
		trieuDai.setViThe(a);
	}

	private void crawlTonGiao(String a, TrieuDai trieuDai) {
		trieuDai.setTonGiaoChinh(a);
	}

	private void crawlChinhPhu(String a, TrieuDai trieuDai) {
		trieuDai.setChinhPhu(a);
	}

	private void crawlNhanVat(Element e, TrieuDai trieuDai) {

		Elements td = e.select("td> div > span > a");
		for (Element a : td) {
			if (!a.text().equals("")) {
				NhanVatLichSu nhanVatLichSu = new NhanVatLichSu();
				nhanVatLichSu.setTenHuy(a.text());
				trieuDai.addNhanVat(nhanVatLichSu);
			}
		}
	}

	private void crawlSuKien(Element e, TrieuDai trieuDai) {
		Elements td = e.select("td> div > span ");
		String content = td.text();
		String t = "";
		Boolean n = true;
		int index = content.indexOf("•");
		if (index > 0) {
			String[] name = (content.split("•"));
			for (String i : name) {
				if (i.indexOf("(") != -1)
					n = false;
				if (i.indexOf(")") != -1)
					n = true;
				t = t.concat(i);
				if (n) {
					SuKienLichSu sk = new SuKienLichSu();
					sk.setTenSuKien(t);
					t = "";
					trieuDai.addSuKien(sk);
				}
			}
		}

	}

	private void crawlDiTich(Element e, TrieuDai trieuDai) {
		Elements td = e.select("td > div > span > a");
		for (Element a : td) {
			DiTichLichSu dt = new DiTichLichSu();
			dt.setTenDiTich(a.text());
			trieuDai.addDiTich(dt);
		}
	}

}
