package com.aelita.listwork.Service;

import com.aelita.listwork.Employee;
import com.aelita.listwork.Exsception.EmployeeAlreadyAddedException;
import com.aelita.listwork.Exsception.EmployeeNotFoundException;
import com.aelita.listwork.Exsception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements ServiceN {
    Integer maxEmployee = 150;
    List<Employee> nums = new ArrayList<>();

    @Override
    public Employee add(String firstName, String secondName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, secondName);
        if (nums.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        if (nums.size() < maxEmployee) {
            nums.add(employee);
            return employee;
        }else {
            throw new EmployeeStorageIsFullException("Превышенно колличество сотрудников");
        }

    }

    @Override
    public Employee delete(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (nums.contains(employee)) {
            nums.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (nums.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public void showAll(){
        System.out.println(nums);

    }
}
