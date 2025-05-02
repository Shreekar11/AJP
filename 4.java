package exp4;
import java.sql.*;
import java.util.*;

public class InputHandler {
    public Scanner scanner;
    InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String[] getStudentDetails() {
        System.out.println("Enter Roll No:");
        String roll_no = scanner.nextLine();

        System.out.println("Enter Full Name:");
        String full_name = scanner.nextLine();

        System.out.println("Enter department:");
        String department = scanner.nextLine();

        return new String[]{
            roll_no,
            full_name,
            department,
        }
    }

    public String getRollNo() {
        System.out.println("Enter Roll No:");
        return scanner.nextLine();
    }
}

public class JdbcNew {
    private Connection con;
    private InputHandler inputHandler;

    public JdbcNew() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "password";

        con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established successfully");

        inputHandler = new InputHandler();
    }

    public static void main(String args[]) {
        JdbcNew jdbcNew = new JdbcNew();
        jdbcNew.showMenu();
    }

    public void showMenu() {
        Scanner scanner - new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Create Table");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Fetch Data");
            System.out.println("6. Search Data");
            System.out.println("7. Close Connection");
            System.out.println("0. Exit");

            System.out.println("Enter your choice:");
            choice = scanner.nextInt();

            System.out.println("");
            switch (choice) {
                case 1:
                    createTable();
                break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    fetchData();
                    break;
                case 6:
                    searchData();
                    break;
                case 7:
                    closeConnection();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            } 
        } while (choice != 0);
    }

    public void createTable() {
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student (roll_no VARCHAR(20), full_name VARCHAR(50), department VARCHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    public void addStudent() {
        try {
            String[] studentDetails = inputHandler.getStudentDetails();
            String sql = "INSERT INTO student (roll_no, full_name, department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(studentDetails[0]));
            pstmt.setString(2, studentDetails[1]);
            pstmt.setString(3, studentDetails[2]);
            pstmt.executeUpdate();
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void updateStudent() {
        try {
            String roll_no = inputHandler.getRollNo();
            String sql = "UPDATE student SET full_name = ?, department = ? WHERE roll_no = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, inputHandler.getStudentDetails()[1]);
            pstmt.setString(2, inputHandler.getStudentDetails()[2]);
            pstmt.setInt(3, Integer.parseInt(roll_no));
            pstmt.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            String roll_no = inputHandler.getRollNo();
            String sql = "DELETE FROM student WHERE roll_no = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(roll_no));
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public void fetchData() {
        try {
            String sql = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%-10d %-20s %-20s%n", rs.getInt("roll_no"),
                rs.getString("full_name"), rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }
}