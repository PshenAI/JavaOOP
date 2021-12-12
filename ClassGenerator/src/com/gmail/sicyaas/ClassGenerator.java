package com.gmail.sicyaas;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassGenerator {

    private File json;
    private File classFile;

    public ClassGenerator() {
    }

    public ClassGenerator(File json) {
        this.json = json;
    }

    public void classCreator() throws IOException {
        Map<String, String> fields = jsonReader();
        String[] className = json.getName().split("\\.");
        File classFile = new File("C:\\Users\\Velvet X\\Documents\\Java Studies\\Java Pro\\" +
                "ClassGENERATOR\\src\\com\\gmail\\sicyaas\\" + className[0] + ".java");
        classFile.createNewFile();
        this.classFile = classFile;
        headerCreator();
        fieldsCreator(fields);
        try (PrintWriter pw = new PrintWriter(new FileWriter(classFile, true))) {
            pw.println("}");
        }

    }

    private void ctrsCreator(List<String> fieldsList){
        String[] className = classFile.getName().split("\\.");
        try (PrintWriter pw = new PrintWriter(new FileWriter(classFile, true))) {
            pw.println("    public " + className[0] + "() {\n" +
                    "    }\n");
            pw.print("    public " + className[0] + "(");
            int count = fieldsList.size();
            for (String field : fieldsList) {
                if(count - 1 == 0){
                    pw.print(field);
                    continue;
                }
                pw.print(field + ", ");
                count--;
            }
            pw.println(") {");
            for (String field : fieldsList) {
                String[] fieldName = field.split(" ");
                pw.println("        this." + fieldName[1] + " = " + fieldName[1] + ";");
            }
            pw.println("    }");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fieldsCreator(Map<String, String> fields) {
        List<String> fieldsList = new ArrayList<>();
        try (PrintWriter pw = new PrintWriter(new FileWriter(classFile, true))) {
            fields.forEach((a, b) -> {
                b = b.replace(" ", "");
                a = a.replace(" ", "");
                if (b.matches("[-+]?\\d+")) {
                    pw.println("    public Integer " + a.replace("\"", "")+ ";");
                    fieldsList.add("Integer " + a.replace("\"", ""));
                } else if(b.equals("true") || b.equals("false")){
                    pw.println("    public Boolean " + a.replace("\"", "") + ";");
                    fieldsList.add("Boolean " + a.replace("\"", ""));
                } else {
                    pw.println("    public String " + a.replace("\"", "")+ ";");
                    fieldsList.add("String " + a.replace("\"", ""));
                }
            });
            pw.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctrsCreator(fieldsList);
    }

    private void headerCreator() {
        String packageName = ClassGenerator.class.getPackageName();
        String[] className = classFile.getName().split("\\.");
        try (PrintWriter pw = new PrintWriter(new FileWriter(classFile, true))) {
            pw.println("package " + packageName + ";\n");
            pw.println("public class " + className[0] + " {\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> jsonReader() {
        Map<String, String> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(json))) {
            String temp = "";
            for (; (temp = br.readLine()) != null; ) {
                if (!temp.startsWith("{") && !temp.startsWith("}")) {
                    String[] arr = temp.split(":");
                    result.put(arr[0], arr[1].replace(",", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

