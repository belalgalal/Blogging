package com.ithinkisink;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Belal
 *
 */
@Singleton
@ApplicationPath("rest")
public class ApplicationConfiguration extends Application {
}
