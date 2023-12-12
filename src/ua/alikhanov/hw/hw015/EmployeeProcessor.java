package ua.alikhanov.hw.hw015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    String surname;
    int salary;
    int age;

    public Employee(String name, String surname, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getFullName() {
        return name + " " + surname;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setValueFromLine(String line) {
        if (line.startsWith("name")) {
            this.name = extractValue(line);
        } else if (line.startsWith("secondName")) {
            this.surname = extractValue(line);
        } else if (line.startsWith("salary")) {
            this.salary = Integer.parseInt(extractValue(line));
        } else if (line.startsWith("age")) {
            this.age = Integer.parseInt(extractValue(line));
        }
    }

    private String extractValue(String line) {
        if (line.contains(":")) {
            return line.split(":")[1].trim().replaceAll("\"", "");
        } else {
            return null;  // or throw an exception if you prefer
        }
    }
}

public class EmployeeProcessor {
    public static void main(String[] args) {
        String fullPath = "C:/Users/Джавид/Documents/GitHub/A-Level-Homeworks/src/ua/alikhanov/hw/hw015/input.txt";

        List<Employee> employees = readEmployeesFromFile(fullPath);

        findEmployeeWithA(employees);

        sortEmployeesByNameAndSalary(employees);

        printEmployeesWithMinSalary(employees);

        int totalSalary = calculateTotalSalary(employees);
        System.out.println("Общая зарплата: " + totalSalary);

        int salaryDifference = findSalaryDifferenceBetweenOldestAndYoungest(employees);
        System.out.println("Разница в зарплате между самым молодым и самым старым сотрудником: " + salaryDifference);

        writeResultsToFile("output.txt", employees);
    }

    private static List<Employee> readEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Employee currentEmployee = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name")) {
                    currentEmployee = new Employee("", "", 0, 0);
                    currentEmployee.setName(getValueFromLine(line));
                } else if (line.startsWith("secondName")) {
                    currentEmployee.setSurname(getValueFromLine(line));
                } else if (line.startsWith("salary")) {
                    currentEmployee.setSalary(extractValue(line));
                } else if (line.startsWith("age")) {
                    currentEmployee.setAge(extractValue(line));
                    employees.add(currentEmployee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }


    private static String getValueFromLine(String line) {
        return line.split(":")[1].trim().replaceAll("\"", "");
    }

    private static int extractValue(String line) {
        if (line.contains(":")) {
            return Integer.parseInt(line.split(":")[1].trim());
        } else {
            return 0;
        }
    }

    private static void findEmployeeWithA(List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.name.startsWith("А")) {
                System.out.println("Сотрудник с именем на 'А': " + employee.getFullName());
                return;
            }
        }
    }

    private static void sortEmployeesByNameAndSalary(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getFullName).thenComparing(Employee::getSalary));
    }

    private static void printEmployeesWithMinSalary(List<Employee> employees) {
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.salary < minSalary) {
                minSalary = employee.salary;
            }
        }

        System.out.println("Сотрудники с минимальной зарплатой:");
        for (Employee employee : employees) {
            if (employee.salary == minSalary) {
                System.out.println(employee.getFullName());
            }
        }
    }

    private static int calculateTotalSalary(List<Employee> employees) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.salary;
        }
        return totalSalary;
    }

    private static int findSalaryDifferenceBetweenOldestAndYoungest(List<Employee> employees) {
        int maxAge = Integer.MIN_VALUE;
        int minAge = Integer.MAX_VALUE;

        for (Employee employee : employees) {
            if (employee.age > maxAge) {
                maxAge = employee.age;
            }
            if (employee.age < minAge) {
                minAge = employee.age;
            }
        }

        int maxSalary = 0;
        int minSalary = 0;

        for (Employee employee : employees) {
            if (employee.age == maxAge) {
                maxSalary = employee.salary;
            }
            if (employee.age == minAge) {
                minSalary = employee.salary;
            }
        }

        return maxSalary - minSalary;
    }

    private static void writeResultsToFile(String fileName, List<Employee> employees) {
        // Указывайте полный путь к файлу
        String outputPath = "C:/Users/Джавид/Documents/GitHub/A-Level-Homeworks/src/ua/alikhanov/hw/hw015/output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (Employee employee : employees) {
                writer.write("Имя: " + employee.name + "\n");
                writer.write("Фамилия: " + employee.surname + "\n");
                writer.write("Заработная плата: " + employee.salary + "\n");
                writer.write("Возраст: " + employee.age + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}