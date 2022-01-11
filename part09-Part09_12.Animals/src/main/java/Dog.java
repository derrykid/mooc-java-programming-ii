
public class Dog extends Animal implements NoiseCapable {

	public Dog() {
		super("Dog");
	}

	public Dog(String name) {
		super(name);
	}

	public void bark() {
		System.out.println(super.getName() + " barks");
	}

	public void eats() {
		System.out.println(super.getName() + " eats");
	}

	public void makeNoise() {
		this.bark();
	}

}
