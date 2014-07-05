package parse;

import org.apache.http.util.TextUtils;
import org.xmlpull.v1.XmlPullParser;

import entity.BaseEntity;

public class ZipAddressEntityParse 
extends BaseXmlParse{

	@Override
	protected void onStartTag(XmlPullParser parser) {
		// TODO 自動生成されたメソッド・スタブ
		String s = parser.getAttributeValue(null,"state_kana");
		if(!TextUtils.isEmpty(s)){
			String sss= "";
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser) {
		// TODO 自動生成されたメソッド・スタブ
		XmlPullParser test = parser;
	}

	@Override
	protected BaseEntity getResponse() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
