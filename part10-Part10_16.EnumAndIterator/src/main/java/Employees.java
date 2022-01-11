import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {

	private ArrayList<Person> list;

	public Employees() {
		this.list = new ArrayList<>();
	}

	public void add(Person personToAdd) {
		this.list.add(personToAdd);
	}

	public void add(List<Person> peopleToAdd) {
		peopleToAdd.stream().forEach(each -> Employees.this.list.add(each));
	}

	public void print() {
		this.list.stream().forEach(each -> System.out.println(each));
	}

	public void print(Education education) {
		Iterator<Person> iterator = this.list.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			if (person.getEducation() == education) {
				System.out.println(person);
			}
		}
	}

	public void fire(Education education) {
		Iterator<Person> iterator = this.list.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			if (person.getEducation() == education) {
				iterator.remove();
			}
		}
	}

}