package com.tooltwist.ttdemo.xds;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.dinaa.xpc.XDService;
import com.dinaa.xpc.XpcSecurity;
import com.tooltwist.xdata.XD;
import com.tooltwist.xdata.XDException;

import tooltwist.wbd.WbdCache;

public class GetPlaceholderXDS implements XDService {

	@Override
	public void init(XD config) {
	}

	@Override
	public XD service(XpcSecurity credentials, XD input) throws XDException {
		try {

			String serverName = WbdCache.getProperty("apiServer");
			String url = serverName + "/getPlaceholder";

			String json = Request.Post(url).addHeader("accept", "application/json").bodyString(input.getString(), ContentType.APPLICATION_JSON).connectTimeout(10000).socketTimeout(10000).execute()
					.returnContent().asString();

			XD xd = new XD(json);
			xd.getSelector();
			return xd;

		} catch (UnsupportedEncodingException e) {
			throw new XDException(e);
		} catch (IOException e) {
			throw new XDException(e);
		}
	}

}
