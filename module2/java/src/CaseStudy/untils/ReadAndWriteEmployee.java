package CaseStudy.untils;

import CaseStudy.models.Employee;
import CaseStudy.validate.Validator;
import ss16_IO_text_file.BaiTap.DocfileCsv.Country;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadAndWriteEmployee {
    private static final String FILE_PATH="E:\\Codegym\\6 module\\module2\\java\\src\\CaseStudy\\data\\Employee.csv";

    public static List<Employee> readCSV() throws IOException {
        List<Employee> employees = new ArrayList<>();
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader buff = new BufferedReader(fileReader);

        String line;
        String[] temp;
        Employee emp;

        while ((line = buff.readLine()) != null){
            temp = line.split(",");
            String id = temp[0];
            String name = temp[1];
            LocalDate age = Validator.dateInputDOB(temp[2]);
            String sex = temp[3];
            String address = temp[4];
            String idCard = temp[5];
            String email = temp[6];
            String level = temp[7];
            double salary = Double.parseDouble(temp[6]);
            String position = temp[9];

            emp = new Employee(id,name,age,sex,address,idCard,email,level,salary,position);
            employees.add(emp);
        }
        buff.close();
        return employees;
    }
    public static void writeCSV(List<Employee> employeeList) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Employee employee: employeeList){
            bufferedWriter.write(employee.getId()+","+employee.getName()+","+employee.getAge()+","+employee.getSex()+
                    ","+employee.getAddress()+","+employee.getIdCard()+","+employee.getEmail()+","+employee.getLevel()+","+employee.getSalary()+","+
                    employee.getPosition()+"\n");
        }

        bufferedWriter.close();
    }
}
