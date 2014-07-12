import http.ServerHttpIF;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.xmlpull.v1.XmlPullParserException;

import parse.ZipAddressEntityParse;
import util.IntegerUtil;
import entity.ZipAddressEntity;

public class Main {
	public static void main(String[] args) {

		String url = "http://zip.cgis.biz/xml/zip.php?zn=";

		System.out.println("郵便番号を入れてください");

		try {
			BufferedReader input = 
					new BufferedReader(
							new InputStreamReader(
					System.in));

			String line = input.readLine();
			
			String accessUrl;
			if(IntegerUtil.isNumber(line) &&
					line.length() == 7){
				accessUrl = url + line;
			}else{
				// error 処理
				System.out.println("郵便番号が不正です");
				return;
			}

			ServerHttpIF httpIF = new ServerHttpIF();
			HttpEntity entity = httpIF.httpGet(accessUrl);

			if (entity != null) {
				// success
				// System.out.println(httpIF.responseText());
			}
			ZipAddressEntity zipAddressEntity = new ZipAddressEntity();
			ZipAddressEntityParse zipAddressEntityParse = new ZipAddressEntityParse();

			zipAddressEntity = (ZipAddressEntity) zipAddressEntityParse
					.create(httpIF.responseText());
			System.out.println(
					zipAddressEntity.getState() +
					zipAddressEntity.getCity() +
					zipAddressEntity.getAddress() +
					"(" +
					zipAddressEntity.getStateKana() +
					zipAddressEntity.getCityKana() +
					zipAddressEntity.getAddressKana() +
					")" 
					);
		} catch (XmlPullParserException e) {
			System.out.println("parse miss");
		} catch (Exception e) {
			System.out.println("errorです");
		}

	}
	
	
}
