/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.exceptions;

/**
 *
 * @author TheHumbleFool
 */
public class ResourceRelativeException extends RuntimeException {

    public ResourceRelativeException() {
    }

    public ResourceRelativeException(String string) {
        super(string);
    }
}
