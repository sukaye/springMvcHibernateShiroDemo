package me.sk.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import ch.qos.logback.classic.Level;

/**
 * 封装Logger
 * 不用在每个类中声明 Logger 变量
 * 直接调用 Log 的静态方法，如 Log.debug("message")
 * 
 */
public final class Log {
	private static Logger logger;

	private static ch.qos.logback.classic.Logger innerLogger;

	private static final String FQCN = Log.class.getName();

	private static Method innerMethod;
	
	static boolean check() {
		if (logger == null) {
			logger = getLogger();
			load((ch.qos.logback.classic.Logger) logger);
		} else {
			Logger lg = getLogger();
			if (!lg.equals(logger)) {
				logger = getLogger();
				load((ch.qos.logback.classic.Logger) logger);
			}
		}
		
		return false;
	}
	
	public static void get() {
		load((ch.qos.logback.classic.Logger) getLogger());
	}

	public static Logger getLogger() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return LoggerFactory.getLogger(stackTrace[4].getClassName());
	}
	
	public static int load(ch.qos.logback.classic.Logger logger) {
		innerLogger = logger;
		try {
			innerMethod = innerLogger.getClass().getDeclaredMethod("filterAndLog_0_Or3Plus", String.class, Marker.class,
					Level.class, String.class, Object[].class, Throwable.class);
			innerMethod.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			innerLogger.error("load failed, Exception:" + e);
			return -1;
		}
		return 0;
	}

	public static void debug(String msg) {
		check();
		innerLogMethod(FQCN, null, Level.DEBUG, msg, null, null);
	}

	public static void error(String msg) {
		check();
		innerLogMethod(FQCN, null, Level.ERROR, msg, null, null);
	}

	public static void info(String msg) {
		check();
		innerLogMethod(FQCN, null, Level.INFO, msg, null, null);
	}

	public static void warn(String msg) {
		check();
		innerLogMethod(FQCN, null, Level.WARN, msg, null, null);
	}

	private static void innerLogMethod(String localFQCN, Marker marker, Level level, String msg, Object[] params,
			Throwable t) {
		try {
			innerMethod.invoke(innerLogger, localFQCN, marker, level, msg, params, t);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			innerLogger.error("execute innerMethod failed, Exception:" + e);
		}
	}
}