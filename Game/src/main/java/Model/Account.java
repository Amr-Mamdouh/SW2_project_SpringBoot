package Model;

public class Account {
	private String username;
	private String Password;
	
	Student student=new Student();
	Teacher teacher=new Teacher();
	
	public Account()
	{
		username="";
		Password="";
	}
	public Account(String username, String password, Student student, Teacher teacher) {
		super();
		this.username = username;
		Password = password;
		this.student = student;
		this.teacher = teacher;
	}
	public int Studentlogin()
	{
	return student.login(username, Password);	
	}
	public int Teacherlogin()
	{
	return teacher.login(username, Password);	
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	

}
