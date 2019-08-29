/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.aspects;

import com.thehumblefool.pokégoapi2.exceptions.InvalidJobInvocationException;
import com.thehumblefool.pokégoapi2.exceptions.ResourceRelativeException;
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
public class ResourceControllersAspect {

    private static final Logger LOGGER = Logger.getLogger(ResourceControllersAspect.class.getName());

    @Pointcut(value = "execution(* com.thehumblefool.pokégoapi2.controllers.*.*(..))")
    public void controllerMethods() {
    }

    @AfterThrowing(value = "controllerMethods()", throwing = "ex")
    public void logAfterThrowingResourceRelativeExceptions(JoinPoint joinPoint, ResourceRelativeException ex) {
        LOGGER.log(Level.WARNING, "Resource relative exception thrown at join point: {0}", new Object[]{joinPoint.toLongString()});
        LOGGER.log(Level.WARNING, "Resource relative exception: {0}", ex.getMessage());
    }

    @AfterThrowing(value = "controllerMethods()", throwing = "ex")
    public void logAfterThrowingInvalidJobExceptions(JoinPoint joinPoint, InvalidJobInvocationException ex) {
        LOGGER.log(Level.WARNING, "Batch processing exception thrown at join point: {0}", new Object[]{joinPoint.toLongString()});
        LOGGER.log(Level.WARNING, "Batch processing exception: {0}", ex.getMessage());
    }

    @AfterThrowing(value = "controllerMethods()", throwing = "ex")
    public void logAfterThrowingNonResourceRelativeExceptions(JoinPoint joinPoint, RuntimeException ex) {
        if (!(ex instanceof ResourceRelativeException) && !(ex instanceof InvalidJobInvocationException)) {
            LOGGER.log(Level.SEVERE, "Exception thrown at join point: {0}", new Object[]{joinPoint.toLongString()});
            LOGGER.log(Level.SEVERE, "Exception: {0}", ex.getMessage());
        }
    }
}
