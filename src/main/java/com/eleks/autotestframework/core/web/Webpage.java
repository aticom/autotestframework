package com.eleks.autotestframework.core.web;

import static com.eleks.autotestframework.core.Configuration.getConfig;

import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Configuration;
import com.eleks.autotestframework.core.Environment;

public abstract class Webpage<T extends Webpage<T>> extends Component<T> {
	
	
	public static final Configuration CONFIG = getConfig();
	private static final Environment ENVIRONMENT = CONFIG.getEnvironmentSettings();
	protected final static String BASE_URL= ENVIRONMENT.scheme + "://" + ENVIRONMENT.host + ":" + ENVIRONMENT.port;

	public Webpage(WebDriver driver){
		super(driver);
	}
	
	public abstract T load();
	
	public T loadAndWaitUntilAvailable(){
		load();
		return waitUntilAvailable();
		
	}
}
