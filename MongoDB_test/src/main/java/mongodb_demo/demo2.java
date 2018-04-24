package mongodb_demo;

public class demo2 {
	public static void main(String[] args) {
		int myNum = 10;
		user xc = new user();
		xc.name="dj";
		xc.age=10;
		demo1.addNum(myNum);
		demo1.changeName(xc);
		System.out.println(xc.name);
	}
}

class user
{
	String name;
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
	int age;
	
}
