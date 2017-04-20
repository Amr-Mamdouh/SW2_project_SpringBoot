package Model;

public class Course {
	private String name;
	private int T_id;
	Teacher teacher=new Teacher();
	public Course()
	{
		name="";
		T_id=-1;
	}
	public Course(String name, int t_id) {
		super();
		this.name = name;
		T_id = t_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getT_id() {
		return T_id;
	}
	public void setT_id(int t_id) {
		T_id = t_id;
	}
	
	
public int addCourse(int T_ID)
	{
		return teacher.createCourse(name, T_ID);
	}
}
