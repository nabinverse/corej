package application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import resource.FirstService;

public class RestApplication extends Application {

	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(FirstService.class);
		classes.add(JacksonJsonProvider.class);
		return classes;
	}
}
