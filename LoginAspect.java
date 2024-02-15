package com.example.POSS;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    @Pointcut("execution(* com.example.POSS.Login.login(..))")
    public void loginMethod() {}

    @AfterReturning("loginMethod()")
    public void afterSuccessfulLogin() {
        System.out.println("Login successful.");
    }

    @AfterThrowing(pointcut = "loginMethod()", throwing = "ex")
    public void afterFailedLogin(Exception ex) {
        System.out.println("Login failed: " + ex.getMessage());
    }
}
