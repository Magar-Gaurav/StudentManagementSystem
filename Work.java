package StudentManagementSystem;
public class Work {
    private long id;
    private String name;
    private String address;
    private long phoneNumber;
    private String faculty;

    public Work(){

    }
    public Work(long id, String name, String address, long phoneNumber, String faculty){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getFaculty(){
        return faculty;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", faculty='" + faculty + '\'' +
                '}';
    }

}
