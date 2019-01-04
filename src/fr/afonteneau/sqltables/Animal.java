package fr.afonteneau.sqltables;

public class Animal {
	private String id;
	private Species sp;
	private String name;
	private Gender gd;
	private int age;
	private Sale sl;
	private int price;
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Species getSp() {
		return sp;
	}
	public void setSp(Species sp) {
		this.sp = sp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGd() {
		return gd;
	}
	public void setGd(Gender gd) {
		this.gd = gd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sale getSl() {
		return sl;
	}
	public void setSl(Sale sl) {
		this.sl = sl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * CONSTRUCTORS
	 */
	public Animal(String id, Species sp, String name, Gender gd, int age, Sale sl, int price) {
		super();
		this.id = id;
		this.sp = sp;
		this.name = name;
		this.gd = gd;
		this.age = age;
		this.sl = sl;
		this.price = price;
	}
}
