package com.cjava.mvc.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
	private Long tx;

	@Around("execution(* com.cjava.mvc.services.*ServiceImpl.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result =  null;
		Long currTime = System.currentTimeMillis();
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		String metodo = "tx[" + tx + "] - " + joinPoint.getSignature().getName();
		//logger.info(metodo + "()");
		if(joinPoint.getArgs().length > 0)
			logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
		try {
			result = joinPoint.proceed();
        } catch (Throwable e) {
        	logger.error(e.getMessage());
        }
		logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
		return result;
	}

}
