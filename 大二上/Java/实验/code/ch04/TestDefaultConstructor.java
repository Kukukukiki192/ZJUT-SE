package cn.edu.zjut.java.ch04;

class Member {
	int instanceVar;
	Member() {
		instanceVar = 0;
	}
	Member(int i) {
		instanceVar = i;
	}
}
class SubMember extends Member {
	SubMember(int j) {
		//super(j);
		instanceVar = j;
	}
}
public class TestDefaultConstructor {
	public static void main(String args[]) {
		Member m1 = new Member();
		SubMember m2 = new SubMember(2);
	}
}