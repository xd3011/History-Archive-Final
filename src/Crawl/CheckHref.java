package Crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

    public class CheckHref {
        private String hrefLink;

        public CheckHref() {
        }

        public CheckHref(String s) {
            this.hrefLink = "https://vi.wikipedia.org" + s;
        }

        public String getHrefLink() {
            return this.hrefLink;
        }

        public Document connectLink() throws IOException {
            Document doc = Jsoup.connect(this.hrefLink).get();
            return doc;
        }

        public boolean checkNhanVat() throws IOException {
            Document doc = this.connectLink();
            Elements pTag = doc.select("p");
            String text = ((Element)pTag.get(1)).text();
            return text.contains("vị vua") || text.contains("thủ lĩnh") || text.contains("hoàng đế") || text.contains("người đứng đầu");
        }

        public boolean checkTrieuDai() throws IOException {
            Document doc = this.connectLink();
            Elements pTag = doc.select("p");
            String text = ((Element)pTag.get(1)).text();
            return text.contains("triều đại") || text.contains("nhà nước");
        }
}
