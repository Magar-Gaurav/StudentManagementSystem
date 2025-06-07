package StudentManagementSystem;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Main db = new Main();

        while(true){
            System.out.println("\n Student Management System: ");
            System.out.println("Enter the number on the basis of which operation to perform ");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students info");
            System.out.println("3. View Student by their id");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            try{
                switch(choice){
                    case 1:
                        Work addWork = new Work();
                        System.out.print("Enter the name of student: ");
                        addWork.setName(scan.nextLine());
                        System.out.print("Enter the address of student: ");
                        addWork.setAddress(scan.nextLine());
                        System.out.print("Enter the phonenumber of student: ");
                        addWork.setPhoneNumber(scan.nextLong());
                        scan.nextLine();
                        System.out.print("Enter the faculty of student: ");
                        addWork.setFaculty(scan.nextLine());
                        db.saveRecord(addWork);
                        System.out.println("***Student data added successfully***");
                        break;

                    case 2:
                        List<Work> students=  db.getAllStudents();
                        if(students.isEmpty()){
                            System.out.println("No data of students to show here");
                        }
                        else{
                            for(Work std:students){
                                printStudents(std);
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter Student id: ");
                        long idtoView = scan.nextLong();
                        Work student = db.getStudent(idtoView);
                        if(student != null){
                            printStudents(student);
                        }
                        else{
                            System.out.println("Student not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the id of student whose data you want to upgrade: ");
                        long updateId = scan.nextLong();
                        scan.nextLine();
                        Work updateWork = db.getStudent(updateId);

                        if(updateWork != null){
                            System.out.print("Enter the new name of student: ");
                            updateWork.setName(scan.nextLine());
                            System.out.print("Enter the new address of student: ");
                            updateWork.setAddress(scan.nextLine());
                            System.out.print("Enter the new phonenumber of student: ");
                            updateWork.setPhoneNumber(scan.nextLong());
                            scan.nextLine();
                            System.out.print("Enter the new faculty of student: ");
                            updateWork.setFaculty(scan.nextLine());
                            db.updateStudent(updateWork);
                        }
                        else{
                            System.out.println("Student not found!!!");
                        }
                        break;
                    case 5:
                        System.out.print("Enter the id to delete: ");
                        long idtoDel = scan.nextLong();
                        db.delete(idtoDel);
                        System.out.println("Successfully deleted the student with id "+idtoDel);
                        break;
                    case 6:
                        System.out.println("Exiting.....");
                        scan.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private static void printStudents(Work std){
        System.out.println("\n------Students Data------");
        System.out.println("Id              : "+std.getId());
        System.out.println("Name            : "+std.getName());
        System.out.println("Address         : "+std.getAddress());
        System.out.println("Phone Number    : "+std.getPhoneNumber());
        System.out.println("Faculty         : "+std.getFaculty());
        System.out.println("***************************************");
    }
}
