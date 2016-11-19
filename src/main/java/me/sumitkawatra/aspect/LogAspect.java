package me.sumitkawatra.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private static final Logger logger = Logger.getLogger(LogAspect.class);

	@Pointcut("within(me.sumitkawatra.*.*)")
	public void logable() {
	}

	@Around("logable()")
	public Object logAdvive(ProceedingJoinPoint proceedingJoinPoint) {
		long start = System.currentTimeMillis();
		Object result = null;

		try {
			result = proceedingJoinPoint.proceed();
			logger.info(proceedingJoinPoint.getSignature() + " took " + (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;

	}

}
