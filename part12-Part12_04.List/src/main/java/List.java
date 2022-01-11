
public class List<Type> {

	private Type[] values;
	private int index;

	public List() {
		this.values = (Type[]) new Object[10];
		this.index = 0;
	}

	public void add(Type value) {
		if (this.values.length == this.index) {
			grow();
		}
		this.values[this.index] = value;
		this.index++;
	}

	private void grow() {
		int newSize = this.values.length + this.values.length / 2;
		Type[] newValues = (Type[]) new Object[newSize];
		for (int i = 0; i < this.values.length; i++) {
			newValues[i] = this.values[i];
		}
		this.values = newValues;
	}

	public Type value(int index) {
		if (index < 0 || index >= this.index) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.index + "]");
		}
		return this.values[index];
	}

	public boolean contains(Type value) {
		return indexOfValue(value) >= 0;
	}

	public void remove(Type value) {
		int num = indexOfValue(value);
		if (num < 0) {
			return;
		}
		this.moveToTheLeft(num);
		this.index++;
	}

	public int size() {
		return this.index;
	}

	public int indexOfValue(Type value) {
		for (int i = 0; i < this.index; i++) {
			if (this.values[i].equals(value)) {
				return i;
			}
		}
		return -1;

	}

	private void moveToTheLeft(int fromIndex) {
		for (int i = fromIndex; i < this.index - 1; i++) {
			this.values[i] = this.values[i + 1];
		}
	}
}
