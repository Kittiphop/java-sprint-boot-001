package SPB.SPB01;

import SPB.SPB01.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spb01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spb01Application.class, args);
		System.out.println("Start On Port: 8000");
//		Person person1 = new Person("001", "A", 11, "1", "a");
//		Person person2 = new Person("002", "B", 12, "2", "b");
//
//		Person person22 = Person.builder()
//			.id("002")
//				.name("B")
//				.age(12)
//				.abc("a")
//				.build();
//
//		Person person3 = Person.builder()
//				.id("003")
//				.name("C")
//				.abc("a")
//				.build();
//
//
//		System.out.println("1: "+person1.toString());
//		System.out.println("2: "+person2.toString());
//		System.out.println("22: "+person22.toString());
//		System.out.println("3: "+person3.toString());
//		System.out.println("compare: "+person2.equals(person22));
//		System.out.println("compare hash code: "+(person2.hashCode() == person22.hashCode()));
	}

}
