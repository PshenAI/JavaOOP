package uni;

import java.util.Scanner;

import uni.Person.Gender;
import uni.exceptions.GenderChoiceException;
import uni.exceptions.GroupOverflowException;

public class StudentScanner {

	private Group gr;

	public StudentScanner() {
		super();
	}

	public StudentScanner(Group gr) {
		super();
		this.gr = gr;
	}

	public Group getGr() {
		return gr;
	}

	public void setGr(Group gr) {
		this.gr = gr;
	}

	private Student studentCreator() throws GenderChoiceException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter students id: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter the name of group student is in: : ");
		String group = sc.nextLine();

		System.out.println("Enter students name: ");
		String name = sc.nextLine();

		System.out.println("Enter students surname: ");
		String surname = sc.nextLine();

		System.out.println("Enter students age: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter students sex (Male/Female): ");
		String gender = sc.nextLine();

		if (gender.equals("Male")) {
			Student st = new Student(id, group, name, surname, age, Gender.Male);
			return st;
		} else if (gender.equals("Female")) {
			Student st = new Student(id, group, name, surname, age, Gender.Female);
			return st;
		} else {
			throw new GenderChoiceException();

		}
	}

	public void studentAssembler() {
		try {
			try {
				gr.addStudent(studentCreator());
			} catch (GenderChoiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
