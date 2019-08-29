/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.aspects;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author TheHumbleFool
 */
@Configuration
@Aspect
public class ServicesAspect {

    private static final Logger LOGGER = Logger.getLogger(ServicesAspect.class.getName());

    @Pointcut(value = "execution(* com.thehumblefool.pokégoapi2.services.*.*(..))")
    public void serviceMethods() {
    }

    @AfterThrowing(value = "serviceMethods()", throwing = "ex")
    public void logAfterThrowingExceptions(JoinPoint joinPoint, RuntimeException ex) {
        LOGGER.log(Level.SEVERE, "Exception thrown at join point: {0}", new Object[]{joinPoint.toLongString()});
        LOGGER.log(Level.SEVERE, "Exception: {0}", ex.getMessage());
    }
}
