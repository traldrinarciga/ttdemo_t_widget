package com.tooltwist.ttdemo.widgets;

import java.util.Properties;

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
import tooltwist.wbd.WbdWidget;

import com.dinaa.ui.UimData;

public class PlaceholderWidget extends GenericMustacheWidget {
	
	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		super.init(instance);
//		instance.defineProperty(new WbdStringProperty(name, index, label, value)
//		instance.defineProperty(new WbdNavPointProperty(name, index, label, value)
//		instance.defineProperty(new WbdRadioTextProperty(name, index, label, options, initialValue)
	}
	
	@Override
	public Properties getPropertiesForViewHelper(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
//		String value = instance.getFinalProperty(generator, "value");
		Properties properties = new Properties();
//		properties.setProperty("value", value);
		
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
