package com.insat.springconnectionmysql.demo.exceptionhandler;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could Not Find employee "+ id);
    }
}
