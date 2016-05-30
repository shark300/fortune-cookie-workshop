package io.github.kicsikrumpli.mocks;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FortuneCookieMockProxy {
	@Value("${MOCK.FORTUNECOOKIE.MESSAGE}")
	private String mockFortuneCookieMessage;

	@Pointcut("bean(fortuneCookieService)")
	public void fortunCookieBeanPointcut() {
	}
	
	@Pointcut("execution(* *.fetchRandomFortuneCookie(..))")
	public void fetchFortuneCookieMethodPointcut() {
	}
	
	@Around("fortunCookieBeanPointcut() && fetchFortuneCookieMethodPointcut()") 
	public Object fetchFortuneCookieAdvice(ProceedingJoinPoint pjp) throws Throwable {
		return mockFortuneCookieMessage;
	}
}
