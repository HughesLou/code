package com.hughes.lou.lintcode.utils;

import java.io.UncheckedIOException;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author HughesLou
 * Created on 2022-03-17
 */
public class UncheckedJsonProcessingException extends UncheckedIOException {
    public UncheckedJsonProcessingException(JsonProcessingException cause) {
        super(cause.getMessage(), cause);
    }
}
