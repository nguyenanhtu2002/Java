package connectdb;
import dao.StudentDAO;
import model.Student;

public class ConnectDB {
    public static void main(String[] args) {
        Student st = new Student(1, "Tú", "a", "a");
        Student st1 = new Student(2, "Tú", "a", "a");
        Student st2 = new Student(3, "Tú", "a", "a");
      //  Student stUpdate = new Student(4, "Anh Tú", "b@gmail.com", "0333333");
        //Insert
      //  StudentDAO.getInstance().insert(stUpdate);
        //Delete
      //  StudentDAO.getInstance().delete(st);
      //Update
      	Student stUpdate = new Student(7, "Nguyễn Anh Tú", "b@gmail.com", "0333333444");
	StudentDAO.getInstance().update(stUpdate);
      //Select * 
     StudentDAO.getInstance().selectAll();
      
    }

}
