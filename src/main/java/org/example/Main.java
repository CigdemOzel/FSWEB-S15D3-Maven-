package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicatedEmployee;

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Çiğdem", "Özel"));
        employees.add(new Employee(1, "Çiğdem", "Özel"));
        employees.add(new Employee(1, "Çiğdem", "Özel"));
        employees.add(new Employee(2, "Numan", "Öçel"));
        employees.add(new Employee(2, "Numan", "Öçel"));
        employees.add(new Employee(3, "Begüm", "Güney"));
        employees.add(new Employee(4, "Çağla", "Koluaçık"));
        employees.add(new Employee(5, "Ayla", "Avcıl"));

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployee = new LinkedList<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee == null) {
                System.out.println("null record");
                continue;
            }

            if(employeeMap.containsKey(employee.getId())) {
                duplicatedEmployee.add(employee);
            }
            else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployee;

    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee == null) {
                System.out.println("null record");
                continue;
            }

            if(!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;

    }
}