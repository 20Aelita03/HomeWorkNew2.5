package com.aelita.listwork.Service;

import com.aelita.listwork.Employee;
import com.aelita.listwork.Exsception.EmployeeAlreadyAddedException;

import java.util.Collection;

public interface ServiceN {
    Employee add(String firstName, String secondName) throws EmployeeAlreadyAddedException;
    Employee delete(String firstName, String secondName);



    Employee find(String firstName, String secondName);
    Collection<Employee> showAll();
}
