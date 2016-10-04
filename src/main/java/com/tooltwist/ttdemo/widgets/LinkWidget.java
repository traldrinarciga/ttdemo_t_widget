package com.tooltwist.ttdemo.widgets;

import java.util.Properties;

import com.dinaa.ui.UimData;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.repository.ToolTwist;
import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.CodeInsertionPosition;
import tooltwist.wbd.GenericMustacheWidget;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.JavascriptLinkInserter;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRadioTextProperty;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;

public class LinkWidget extends GenericMustacheWidget {
	
	@Override
	protected void init(WbdWidget instance) throws WbdException{
		super.init(instance);
		instance.defineProperty(new WbdStringProperty("label", null, "Label", ""));
		instance.defineProperty(new WbdStringProperty("url", null, "URL", ""));
		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
		instance.defineProperty(new WbdRadioTextProperty("switcher", null, "Switcher", "URL,Navpoint", "Navpoint"));
		instance.defineProperty(new WbdRadioTextProperty("target", null, "Target", "Same Page,New Page", "Same Page"));
	}
	
	@Override
	public Properties getPropertiesForViewHelper(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
		Properties properties = new Properties();
		properties.setProperty("label", instance.getFinalProperty(generator, "label"));
		properties.setProperty("url", instance.getFinalProperty(generator, "url"));
		properties.setProperty("navpoint", RoutingUIM.navpointUrl(ud, instance.getFinalProperty(generator, "navpoint"), AutomaticUrlParametersMode.NO_AUTOMATIC_URL_PARAMETERS));
		properties.setProperty("switcher", instance.getFinalProperty(generator, "switcher"));
		properties.setProperty("target", instance.getFinalProperty(generator, "target"));
		
		return properties;
	}
	
	public void getCodeInserters(WbdGenerator generator, WbdWidget instance, UimData ud, CodeInserterList codeInserterList) throws WbdException {
		// The normal code inserters are defined here
		super.getCodeInserters(generator, instance, ud, codeInserterList);

		// Other code inserters are defined here
		GenerationMode mode = generator.getMode();
		if (mode == GenerationMode.DESIGN) {

			CodeInserter[] arr = {

			};
			codeInserterList.add(arr);

		} else if (mode == GenerationMode.PRODUCTION || generator.getMode() == GenerationMode.CONTROLLER) {

			CodeInserter[] arr = {
				new StylesheetCodeInserter(generator, instance, "cssHeader.css"), 
				new JavascriptCodeInserter(generator, instance, "jsHeader.js", CodeInsertionPosition.BOTTOM),
				new JavascriptLinkInserter(ToolTwist.getWebapp())
			};
			codeInserterList.add(arr);
		}
	}

}
