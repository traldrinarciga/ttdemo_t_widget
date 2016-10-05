package com.tooltwist.ttdemo.widgets;

import java.util.ArrayList;
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
import tooltwist.wbd.WbdProperty;
import tooltwist.wbd.WbdRadioTextProperty;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;

public class LinkWidget extends GenericMustacheWidget {
	
	private WbdWidget mInstance;
	private ArrayList<WbdProperty> mProps;
	
	@Override
	protected void init(WbdWidget instance) throws WbdException{
		super.init(instance);
		mInstance = instance;
		mProps = new ArrayList<>();
		addProp(new WbdStringProperty("label", null, "Label", ""));
		addProp(new WbdStringProperty("url", null, "URL", ""));
		addProp(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
		addProp(new WbdRadioTextProperty("switcher", null, "Switcher", "URL,Navpoint", "Navpoint"));
		addProp(new WbdRadioTextProperty("target", null, "Target", "Same Page,New Page", "Same Page"));
	}
	
	@Override
	public Properties getPropertiesForViewHelper(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
		return generateProps(generator, ud);
	}
	
	private void addProp(WbdProperty property){
		try {
			mInstance.defineProperty(property);
			mProps.add(property);
		} catch (WbdException e) {
			e.printStackTrace();
		}
	}
	
	private Properties generateProps(WbdGenerator generator, UimData ud){
		Properties props = new Properties();
		for(WbdProperty prop : mProps){
			try{
				if(prop instanceof WbdNavPointProperty){
					props.setProperty(prop.getName(), RoutingUIM.navpointUrl(ud, mInstance.getFinalProperty(generator, prop.getName()), AutomaticUrlParametersMode.NO_AUTOMATIC_URL_PARAMETERS));
				}else{
					props.setProperty(prop.getName(), mInstance.getFinalProperty(generator, prop.getName()));
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return props;
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
