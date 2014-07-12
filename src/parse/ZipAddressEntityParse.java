package parse;

import org.apache.http.util.TextUtils;
import org.xmlpull.v1.XmlPullParser;

import entity.BaseEntity;
import entity.ZipAddressEntity;

public class ZipAddressEntityParse 
extends BaseXmlParse{
	
	ZipAddressEntity _entity;

	@Override
	protected void onStartTag(XmlPullParser parser) {
		
		if(_entity == null){
			_entity = new ZipAddressEntity();
		}
		
		
		String stateKana = 
				parser.getAttributeValue
				(null,"state_kana");
		if(!TextUtils.isEmpty(stateKana))
			_entity.setStateKana(stateKana);
		
		String cityKana = 
				parser.getAttributeValue(null,"city_kana");
		String addressKana = 
				parser.getAttributeValue(null,"address_kana");
		String companyKana = 
				parser.getAttributeValue(null,"company_kana");
		String state = 
				parser.getAttributeValue(null,"state");
		String city = 
				parser.getAttributeValue(null,"city");
		String address = 
				parser.getAttributeValue(null,"address");
		String company = 
				parser.getAttributeValue(null,"company");
	
	}

	@Override
	protected void onEndTag(XmlPullParser parser) {
		// TODO 自動生成されたメソッド・スタブ
		XmlPullParser test = parser;
	}

	@Override
	protected BaseEntity getResponse() {
		return _entity;
	}

}
