package hello;

import org.springframework.data.annotation.Id;


class Person {
    @Id private String id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    

    public String getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	@Override
    public String toString() {
        return String.format(
                "Person[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
