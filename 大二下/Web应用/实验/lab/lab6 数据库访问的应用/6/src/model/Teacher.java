package model;

public class Teacher extends User{
	private String Character;
	public Teacher() {
		super();
	}
	public Teacher(String name, String iD, String num, String psw, String institute, String character){
		super(name,iD,num,psw,institute);		
		this.Character = character;
	}
	public String getCharacter() {
		return Character;
	}
	public void setCharacter(String character) {
		this.Character = character;
	}	
}
