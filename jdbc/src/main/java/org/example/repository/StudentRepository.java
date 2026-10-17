package org.example.repository;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "root";

    public void createStudent(Student student){

        String sql = """
                    insert into students(name, email, age) values(?, ?, ?)
                    """;

        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected==1) System.out.println("Student created..");
            else System.out.println("Student didn't created..");

        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    public void updateStudent(Student student, Long id){

        String sql = """
                    update students set name=?,
                                        email=?,
                                        age=?
                                        where id=?
                    """;

        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected==1) System.out.println("Student updated..");
            else System.out.println("Student didn't updated..");

        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    public void deleteStudent(Long id){
        String sql = """
                        delete from students where id=?
                    """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();

            if(result==1) System.out.println("Student deleted..");
            else System.out.println("Student didn't deleted..");

        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    public void getStudentById(Long id){
        String sql = """
                select id, name, email, age
                from students where id=?
                """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Student student = mapRow(result);
            System.out.println(student);

        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    public void getStudent(){
        String sql = """
                select id, name, email, age
                from students 
                """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            try(ResultSet result = preparedStatement.executeQuery();) {
                List<Student> studentList = new ArrayList<Student>();
                while(result.next()){
                    Student student = mapRow(result);
                    studentList.add(student);
                }
                for(Student list : studentList){
                    System.out.println(list);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    public void completeCRUD(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String sql = "select id, name, email, age from students where id=2";
            Boolean result = statement.execute(sql);

            if(result){
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                Student student = mapRow(resultSet);
                System.out.println(student);
            }else{
                int rowAffected = statement.getUpdateCount();
                System.out.println(rowAffected);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Database connection failed..");
            e.printStackTrace();;
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}
