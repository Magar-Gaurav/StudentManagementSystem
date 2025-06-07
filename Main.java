package StudentManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main extends MakeConnection{
    // Create operation
    public void saveRecord(Work students){
        try{
            Connection conn = getDBConnection();
            String sql = "INSERT INTO students(name, address, phonenumber, faculty) VALUES (?, ?, ?, ?)";
            PreparedStatement state = conn.prepareStatement(sql);
            state.setString(1, students.getName());
            state.setString(2, students.getAddress());
            state.setLong(3, students.getPhoneNumber());
            state.setString(4, students.getFaculty());

            state.executeUpdate();
            state.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //Read Operation
    public List<Work> getAllStudents() throws Exception{
        List<Work> studentList = new ArrayList<>();
        Connection conn = getDBConnection();
        Statement state = conn.createStatement();

        ResultSet rs = state.executeQuery("SELECT * FROM students");

        while(rs.next()){
            Work students  = new Work();
            students.setId(rs.getLong("id"));
            students.setName(rs.getString("name"));
            students.setAddress(rs.getString("address"));
            students.setPhoneNumber(rs.getLong("phonenumber"));
            students.setFaculty(rs.getString("faculty"));

            studentList.add(students);
        }
        rs.close();
        state.close();
        conn.close();
        return studentList;
    }
    //Update Operation
    public void updateStudent(Work students) throws Exception{
        Connection conn = getDBConnection();
        String sql = "UPDATE students SET name=?, address=?, phonenumber=?,faculty=? where id=?";
        PreparedStatement state = conn.prepareStatement(sql);

        state.setString(1, students.getName());
        state.setString(2, students.getAddress());
        state.setLong(3, students.getPhoneNumber());
        state.setString(4, students.getFaculty());
        state.setLong(5, students.getId());

        state.executeUpdate();
        state.close();
        conn.close();
    }
    //Delete operation
    public void delete(Long id) throws Exception{
        Connection conn = getDBConnection();
        PreparedStatement state = conn.prepareStatement("DELETE FROM students where id= ?");
        state.setLong(1, id);
        state.executeUpdate();
        state.close();
        conn.close();
    }
    //Read but only one at once
    public Work getStudent(long id) throws Exception{
        Work students = null;
        String sql = "SELECT * FROM students WHERE id= ?";
        Connection conn = getDBConnection();

        PreparedStatement state = conn.prepareStatement(sql);
        state.setLong(1, id);

        ResultSet resultSet = state.executeQuery();
        if(resultSet.next()){
            students = new Work();
            students.setId(resultSet.getLong("id"));
            students.setName(resultSet.getString("name"));
            students.setAddress(resultSet.getString("address"));
            students.setPhoneNumber(resultSet.getLong("phonenumber"));
            students.setFaculty(resultSet.getString("faculty"));
        }
        resultSet.close();
        state.close();
        conn.close();
        return students;
    }
}
