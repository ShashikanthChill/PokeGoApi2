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
public class InvalidRequestParamException extends RuntimeException
{

    public InvalidRequestParamException()
    {
    }

    public InvalidRequestParamException(String string)
    {
        super(string);
    }
    
}
