/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author The_Humble_Fool
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestParamFormatException extends RuntimeException
{

    public RequestParamFormatException()
    {
    }

    public RequestParamFormatException(String string)
    {
        super(string);
    }
    
}
