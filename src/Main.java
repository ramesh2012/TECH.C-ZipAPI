import http.ServerHttpIF;

import org.apache.http.HttpEntity;

public class Main {
	public static void main(String[] args) {
		
		String url = 
				"http://zip.cgis.biz/xml/zip.php?zn=";
		String accessUrl = url + "1520022";
		
		ServerHttpIF httpIF = new ServerHttpIF();
		HttpEntity entity = 
				httpIF.httpGet(accessUrl);
		
		System.out.println(httpIF.responseText());
		
	}
}
