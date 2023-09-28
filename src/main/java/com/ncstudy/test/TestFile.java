package com.ncstudy.test;

import lombok.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TestFile {
    public static void main(String[] args) {
        try {
            List<String> list = readFile("D:\\Users\\kjs_352\\Desktop\\text.txt");
            List<Employee> listE = list.stream().map(words -> {
                String[] list1 = words.split(",");
                Employee e = new Employee(list1[0].trim(),Integer.parseInt(list1[1].trim()),list1[2].trim(),list1[3].trim());
                return e;
            }).collect(Collectors.toList());
            for (Employee employee : listE) {
                System.out.println(employee.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFile(String filePath) throws IOException {
//        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        File file = new File(filePath);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String readLine = null;
        while ((readLine = br.readLine()) != null){
//            sb.append(readLine);
            list.add(readLine.replace("\uFEFF", ""));
        }
        br.close();
        isr.close();

        //System.out.println(sb.toString());
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return list;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Data
    static class Employee implements Serializable {
        private String name;
        private Integer age;
        private String department;
        private String level;
    }
}
