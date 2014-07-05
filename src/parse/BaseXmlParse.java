package parse;

import java.io.StringReader;

import org.apache.http.util.TextUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import entity.BaseEntity;

public abstract class BaseXmlParse {
	
	protected String _text;
	
	protected abstract void 
		onStartTag(XmlPullParser parser);
	
	protected abstract void 
	onEndTag(XmlPullParser parser);
	
	protected abstract BaseEntity getResponse();

	public BaseXmlParse() {

	}

	public BaseEntity create() {

		return null;
	}

	public void parse(String str) throws XmlPullParserException {
		if (TextUtils.isBlank(str))
			return;

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		// パーサーのインスタンス生成
		XmlPullParser parse = factory.newPullParser();

		try {
			// xml文字列の取り込み
			parse.setInput(new StringReader(str));

			int parseType = 0;
			
			// xmlドキュメントの最後になるまでループ
			while ((parseType = parse.next())
					!= XmlPullParser.END_DOCUMENT) {
				switch(parseType){
				case XmlPullParser.START_TAG:
					onStartTag(parse);
					break;
				case XmlPullParser.TEXT:
					_text = parse.getText();
					break;
				case XmlPullParser.END_TAG:
					onEndTag(parse);
					break;
				}
			}
		} catch (Exception e) {
			// no operation
		}
	}

}
