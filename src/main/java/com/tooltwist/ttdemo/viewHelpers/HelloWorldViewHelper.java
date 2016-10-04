package com.tooltwist.ttdemo.viewHelpers;

import java.util.HashMap;
import java.util.Properties;

import tooltwist.wbd.ViewHelper;

import com.dinaa.ui.UimData;

public class HelloWorldViewHelper extends ViewHelper {
	private HashMap<String, Object> scopes = new HashMap<String, Object>();

	public HelloWorldViewHelper(Properties properties) {
		super(properties);
		scopes.put("name", properties.getProperty("name"));
		scopes.put("navpoint", properties.getProperty("navpoint"));
		scopes.put("yesOrNo", properties.getProperty("yesOrNo"));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void callPreFetch(UimData ud) throws Exception {
		// TODO Auto-generated method stub
		super.callPreFetch(ud);
		scopes.put("placeholder", "placeholder");
	}

	public HashMap<String, Object> getScopes() {
		return scopes;
	}

}
