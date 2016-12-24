package me.sumitkawatra.aspect;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
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
	
	@Pointcut("@annotation(org.springframework.stereotype.Controller)")
	public void controllerBean() {
	}

	@Pointcut("@annotation(org.springframework.stereotype.Service)")
	public void serviceBean() {
	}

	@Pointcut("@annotation(org.springframework.stereotype.Repository)")
	public void repositoryBean() {
	}

	@Pointcut("within(me.sumitkawatra.*.*)")
	public void methodPointcut() {
	}

	@Around("serviceBean() && methodPointcut()")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug(">>>>>>>> invoking " + joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		logger.debug(">>>>>>>> return of "+joinPoint.getSignature()+" with "+ BeanUtils.describe(result));
		logger.debug(">>>>>>>> end of "+joinPoint.getSignature()+" take "+ (end.getTime() - start.getTime())+" millisec");
		return result;
	}
	
	//Old Code
	
//	@Pointcut("within(me.sumitkawatra.*.*)")
//	public void logable() {
//	}

//	@Around("logable()")
//	public Object logAdvive(ProceedingJoinPoint proceedingJoinPoint) {
//		long start = System.currentTimeMillis();
//		Object result = null;
//
//		try {
//			result = proceedingJoinPoint.proceed();
//			logger.info(proceedingJoinPoint.getSignature() + " took " + (System.currentTimeMillis() - start) + "ms");
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		return result;
//
//	}

}
