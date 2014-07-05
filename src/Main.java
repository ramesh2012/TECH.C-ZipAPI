import http.ServerHttpIF;

import org.apache.http.HttpEntity;
import org.xmlpull.v1.XmlPullParserException;

import parse.ZipAddressEntityParse;
import entity.ZipAddressEntity;

public class Main {
	public static void main(String[] args) {
		
		String url = 
				"http://zip.cgis.biz/xml/zip.php?zn=";
		String accessUrl = url + "1520022";
		
		ServerHttpIF httpIF = new ServerHttpIF();
		HttpEntity entity = 
				httpIF.httpGet(accessUrl);
		
		if(entity != null){
			// success
			//System.out.println(httpIF.responseText());
		}
		ZipAddressEntity zipAddressEntity = 
				new ZipAddressEntity();
		ZipAddressEntityParse zipAddressEntityParse =
				new ZipAddressEntityParse();
		try {
			zipAddressEntity = 
					(ZipAddressEntity) 
					zipAddressEntityParse.
					create(httpIF.responseText());
		} catch (XmlPullParserException e) {
			System.out.println("parse miss");
		}
		
		
		
	}
}
