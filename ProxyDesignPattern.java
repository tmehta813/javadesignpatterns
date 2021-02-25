package oopsdesign;

public class ProxyDesignPattern {
	
	public static void main(String[] args) {
		
		News news = new ProxyNews("india tv");
		news.loadNews();
		news = new ProxyNews("xyzs");
		news.loadNews();
		
	}

}

interface News {
	void loadNews();
}

class RealNews implements News {

	String url;
	
	public RealNews(String url) {
		this.url = url;
	}
	
	@Override
	public void loadNews() {
		System.out.println("loading news: "+url);
	}
	
}


class ProxyNews implements News {
	
	String newsUrl;
	News realNews; 
	
	public ProxyNews(String newsUrl) {
		this.newsUrl = newsUrl;
	}
	

	@Override
	public void loadNews() {
		//if this type of news url comes we'll navigate it to different url
		if(newsUrl.contains("xyz")) {
			newsUrl = "abc";
		}
		
		if(realNews==null) {
			realNews = new RealNews(newsUrl);
		}
		realNews.loadNews();
		
	}
	
}
