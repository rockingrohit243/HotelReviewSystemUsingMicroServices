package com.springboot.ratingservices.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException()
    {
        super("No Resource found");
    }
    public ResourceNotFoundException(String message)
    {
        super("Resource not found: "+message);
    }
}
