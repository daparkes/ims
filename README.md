# Project Title

This is my week 5 project, which demonstrates the skills I have gained during my time at the QA Academy.
It is an inventory management system written in Java that manages a MySQL database. Users can perform basic
CRUD functionality on database items in four different tables. The system accepts orders, which include item
IDs and quantities, and calculates a total price. This can then be read from the database later.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development
and testing purposes. See deployment for notes on how to deploy the project on a live system.
Ensure that the prerequisites below are installed.

git clone https://github.com/daparkes/ims
cd ims

### Prerequisites

What things you need to install the software and how to install them

- Java 8 JDK
- Maven
- Git for versioning
- IDE for development (e.g. Eclipse)


### Installing

1. Clone the project as described above
2. Install it:
cd ims
mvn java -jar
This will result in an executable .jar file that can be run by the JVM.
3. Open the project in your IDE of choice (the project was developed in Eclipse).

Once built and opened, the application can be used to manipulate the database.
First, select a table to perform operations on.
Then, select the operation.
The application will ask for information and manipulate the database accordingly.

## Running the tests

The unit and integration tests written for the application can either be run manually in Eclipse (by right-clicking on them
and selecting Run As -> JUnit Test or by opening them and pressing Ctrl+F11) or automatically, for example by deploying
to a Jenkins server that builds the project periodically using Maven. Other steps can be built into this pipeline, such as
scripting deployment to an artifact repository like Nexus after building.

### Unit Tests 

These tests are intended to test the functionality of individual methods. For example, tests have been written for each
method inside the Customer, Item, Order and User classes to verify that the getters and setters work, that objects and fields
can be set to null, and many more. These tests must pass to ensure that the application runs correctly. For example, this is
a test for the setters in the Item class:
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItemName(null);
		assertNull(item.getItemName());
		item.setPrice(null);
		assertNull(item.getPrice());	
	}
	
To run these tests, follow the instructions above.

### Integration Tests 
Several integration tests have been written for the application using Mockito. Mockito is used to stub the methods called
by the method being tested so that the method itself does not have to be called. This allows more complex methods to be
tested and simulates application functionality more effectively.
Here is a test that tests the readAll() method in the Customer controller.

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P"));
		customers.add(new Customer("Rhys", "T"));
		customers.add(new Customer("Nic", "J"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

This works by returning a list of customers when the customerController calls the readAll() method in the customerServices
class.


### Coding style tests

Coding style tests can be performed by uploading the project to SonarQube. This server will analyse the project and produce
many useful metrics, such as code coverage. It will also find bugs, security vulnerabilities and 'code smells'
(maintainability issues) in the code and suggest fixes for them.

## Deployment

mvn deploy

This can be configured to deploy the compiled project to an artifact repository such as Nexus.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Dan Parkes** - *Initial work* - [daparkes](https://github.com/daparkes)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
