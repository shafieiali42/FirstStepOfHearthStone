import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
    public static void main(String args[]){
        test tester = new test();
        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = "{\"name\":\"Mahesh\", \"age\":21,\"school\":55}";
//        System.out.println(jsonString);
        //map json to student
        try{
            Student student1 = tester.readJSON();
            System.out.println(student1);
//            Student student = mapper.readValue(jsonString, Student.class);
//
//            System.out.println(student);
//
//            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
//
//            System.out.println(jsonString);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
    private Student readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File("sample.json"), Student.class);
        return student;
    }
}

class Student {
    private int age;
    private String name;
    private String school;
    public Student(){}
    public String getSchool(){
        return school;
    }
    public void setSchool(String school){
        this.school=school;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "Student [ name: "+name+", age: "+ age+ ",school"+school+"]";
    }
}