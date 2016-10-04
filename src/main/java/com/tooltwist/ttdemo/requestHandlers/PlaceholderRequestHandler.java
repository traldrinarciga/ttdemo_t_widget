package com.tooltwist.ttdemo.requestHandlers;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import tooltwist.wbd.WbdRequestHandler;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;

public class PlaceholderRequestHandler extends WbdRequestHandler {

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, IOException, ServletException {
		HttpServletRequest request = uh.getRequest();
		String op = request.getParameter("subop");
		long requestTime = System.currentTimeMillis();

		try {
			if (!op.equals("") || op != null) {
				Class<?>[] params = new Class[] { UimHelper.class };
				Method method1 = this.getClass().getMethod(op, params);
				method1.invoke(this, uh);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return true;
	}
	
}
