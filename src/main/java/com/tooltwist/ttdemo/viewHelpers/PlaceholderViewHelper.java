package com.tooltwist.ttdemo.viewHelpers;

import java.util.HashMap;
import java.util.Properties;

import tooltwist.wbd.ViewHelper;

import com.dinaa.ui.UimData;

public class PlaceholderViewHelper extends ViewHelper {
	private HashMap<String, Object> scopes = new HashMap<String, Object>();

	public PlaceholderViewHelper(Properties properties) {
		super(properties);
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
