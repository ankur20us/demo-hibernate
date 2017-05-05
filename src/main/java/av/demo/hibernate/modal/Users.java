package av.demo.hibernate.modal;

public class Users {

	private int userId;
	private String uname;
	private int age;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", uname=" + uname + ", age=" + age + "]";
	}
	
}
