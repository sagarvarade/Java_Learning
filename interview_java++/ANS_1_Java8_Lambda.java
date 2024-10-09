package com.learn.corejava.Lambda;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.learn.corejava.DataProvider.Data;
import com.learn.corejava.DataProvider.Employee;
@SuppressWarnings("unused")
public class Java8_Lambda {

	public static void main(String[] args) {
		//EmployeeAllLambdas();
		// extracted();
		//problemsLambda();
		ConsumerLambda();
	}

	@SuppressWarnings("unused")
	private static void ConsumerLambda() {
		//Questions on Consumers and Producers
		List<Integer> listOfRandomIntegers = Data.getRandomeNumbers(10);
		List<String> listOfRandomStrings = Data.getRandomName(10);
		List<Employee> listOfEmployess = Data.getEmployeeRecords(20);
		Consumer<String> prt=System.out::println;
		DoubleConsumer prt2=System.out::println;
		listOfRandomStrings.stream().forEach(prt);

		//Supplier<Long> intSupplier=()->Math.round(Math.random()/100);
		//DoubleStream.generate((DoubleSupplier) intSupplier).limit(10)intSupplier;
		
		
 		
	}
	@SuppressWarnings("unused")
	private static void problemsLambda() {
		List<Integer> listOfRandomIntegers = Data.getRandomeNumbers(10);
		List<String> listOfRandomStrings = Data.getRandomName(10);
		List<Employee> listOfEmployess = Data.getEmployeeRecords(20);
		
		//1- Given a list of integers, filter out the odd numbers and collect the even numbers into a new list.
		Predicate<Integer> checkOdd=e->e%2!=0;
		List<Integer> oddList = listOfRandomIntegers.stream().filter(checkOdd).collect(Collectors.toList());
		System.out.println("OddList :  "+oddList);
		//- Given a list of strings, convert each string to its uppercase form and collect the results into a set.
		Set<String> toUpperString = listOfRandomStrings.stream().map(String::toUpperCase).collect(Collectors.toSet());
		System.out.println("To upper String : "+toUpperString);
		//- Given a list of employees, sort them by their salary in descending order and collect the top 5 employees into a list.
		List<Employee> sorted5Emp = listOfEmployess.stream().sorted(Comparator.comparingInt(Employee::salary)).limit(5).collect(Collectors.toList());
//		System.out.println("Sorted 5 emp : "+sorted5Emp);
		//Given a list of integers, find the sum of all the integers using the `reduce` method.
		Optional<Integer> reduceToSum = listOfRandomIntegers.stream().reduce((e,j)->e+j);
		System.out.println("Reduce Sum :"+reduceToSum.get());
		
		//- Given a list of students with their grades, filter out the students who scored above 90 and count them.
		long countSalGT500 = listOfEmployess.stream().filter(e->e.salary()>500).count();
		System.out.println("Salary gt 500 > "+countSalGT500);
		//- Given a list of strings, convert them to uppercase and join them into a single string separated by commas.
		String JoinedString = listOfRandomStrings.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		System.out.println("Joined String : "+JoinedString);
		//- Given a list of transactions with their types, group the transactions by type and count the number of transactions in each group.
		
		Map<String, Long> deptCollect = listOfEmployess.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.counting()));
		System.out.println("Dept collect count "+deptCollect);
		
		//- Given a list of products with their prices, calculate the total price of all products using the `map` and `reduce` methods.
		Map<Integer, DoubleSummaryStatistics> collectSum = listOfEmployess.stream().collect(Collectors.groupingBy(Employee::salary,Collectors.summarizingDouble(e->e.salary())));
		//System.out.println("Collect sum : "+collectSum);
		Optional<Employee> maxInteger = listOfEmployess.parallelStream().sorted(Comparator.comparing(Employee::salary).reversed()).findFirst();
		
		Integer maxInt=listOfRandomIntegers.parallelStream().mapToInt(e->e).max().getAsInt();
	
		System.out.println("Max Int : "+maxInt);
		//Given a list of strings, filter out strings that are shorter than 5 characters and collect the remaining strings into a list.
		List<Employee> listOfEmpWithNameGt5 = listOfEmployess.stream().filter(e->e.name().length()>5).collect(Collectors.toList());
		//System.out.println("List of emp len get 5 "+listOfEmpWithNameGt5);
		
		Map<Object, Long> mapNameGT5 = listOfEmployess.stream().filter(e->e.name().length()>5).collect(Collectors.groupingBy(e->e.name().length(),Collectors.counting()));
		System.out.println("Map Name GT 5 "+mapNameGT5);
		
		//- Given a list of strings, group them by their first character and collect the results into a map.
		Map<Character, List<Employee>> collectByFirstChar = listOfEmployess.stream().collect(Collectors.groupingBy(e->e.name().charAt(0)));
		//System.out.println("Collect by first char : "+collectByFirstChar);
		
		//Given a list of numbers, find the average of these numbers using the `Collectors.averagingDouble` method.
		Double avaerageDouble = listOfRandomIntegers.stream().collect(Collectors.averagingDouble(e->e));
		
		System.out.println("Average Double : "+avaerageDouble);
		
		Map<Boolean, List<Integer>> partitionaByEvenOdd = listOfRandomIntegers.stream().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println("PartitionaByEvenOdd:  "+partitionaByEvenOdd);
		
		IntStream intStream=IntStream.of(4,5,6,78,33);
		IntSummaryStatistics statcis=intStream.summaryStatistics();
		System.out.println("statcds : "+statcis+"  "+statcis.getMax());
		Set<Integer> distinctSet = listOfRandomIntegers.parallelStream().distinct().sorted().collect(Collectors.toSet());
		System.out.println("Distinct set : "+distinctSet);
	}

	

	private static void EmployeeAllLambdas() {
		List<Employee> empList = Data.getEmployeeRecords(20);
		// 1 Group the Employees by city.
		Map<String, List<Employee>> empByCity = empList.stream().collect(Collectors.groupingBy(Employee::city));
		System.out.println("Employees grouped by city :: \n" + empByCity);
		// 2. Group the Employees by age.
		Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.groupingBy(Employee::age));
		System.out.println("Employees grouped by age :: \n" + empByAge);

		// 3. Find the count of male and female employees present in the organization.
		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
				.collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
		System.out.println(
				"Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);
		// 4. Print the names of all departments in the organization.
		System.out.println("Names of all departments in the organization ");
		empList.stream().map(Employee::dept).distinct().forEach(System.out::println);

		// 5. Print employee details whose age is greater than 28.
		System.out.println("Employee details whose age is greater than 28");
		empList.stream().filter(e -> e.age() > 28).collect(Collectors.toList()).forEach(System.out::println);

		// 6. Find maximum age of employee.
		OptionalInt max = empList.stream().mapToInt(Employee::age).max();
		
		
		if (max.isPresent())
			System.out.println("Maximum age of Employee: " + max.getAsInt()+"  ");

		// 7. Print Average age of Male and Female Employees.
		Map<String, Double> avgAge = empList.stream()
				.collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));
		System.out.println("Average age of Male and Female Employees:: " + avgAge);

		// 8. Print the number of employees in each department.

		Map<String, Long> countByDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
		System.out.println("No of employees in each department");
		for (Map.Entry<String, Long> entry : countByDept.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// 9 . Find oldest employee.
		Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::age));
		Employee oldestEmployee = oldestEmp.get();
		System.out.println("Oldest employee details:: \n" + oldestEmployee);

		// 10 .Find youngest female employee.
		// can use anyMatch also
		Optional<Employee> youngestEmp = empList.stream().filter(e -> e.gender() == "F")
				.min(Comparator.comparingInt(Employee::age));
		Employee youngestEmployee = youngestEmp.orElse(new Employee(null, null, null, null, null, null, null, null));
		System.out.println("Youngest Female employee details:: \n" + youngestEmployee);

		// 11. Find employees whose age is greater than 30 and less than 30.

		System.out.println("Employees whose age is greater than 25 and less than 25");
		Map<Boolean, List<Employee>> partitionEmployeesByAge = empList.stream()
				.collect(Collectors.partitioningBy(e -> e.age() > 30));

		Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();

		for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
			if (Boolean.TRUE.equals(entry.getKey())) {
				System.out.println("Employees greater than 30 years ::" + entry.getValue());
			} else {
				System.out.println("Employees less than 30 years ::" + entry.getValue());
			}
		}

		// 12. Find the department name which has the highest number of employees.

		Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());

		// 13. Find if there any employees from HR Department.
		Optional<Employee> emp = empList.stream().filter(e -> e.dept().equalsIgnoreCase("HR")).findAny();
		emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));

		// 14. Find the department names that these employees work for, where the number
		// of employees in the department is over 3.
		System.out.println("Department names where the number of employees in the department is over 3 :: ");
		empList.stream().collect(Collectors.groupingBy(Employee::dept, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 3).forEach(System.out::println);

		// 15. Find distinct department names that employees work for.
		System.out.println("Distinct department names that employees work for:: ");
		empList.stream().map(Employee::dept).distinct().forEach(System.out::println);

		// 16. Find all employees who lives in ‘Blore’ city, sort them by their name and
		// print the names of employees.
		empList.stream().filter(e -> e.city().equalsIgnoreCase("Blore")).sorted(Comparator.comparing(Employee::name))
				.forEach(e -> System.out.println("Employees staying in Blore:: " + e.name()));

		// 17. No of employees in the organization.
		System.out.println("No of employees in the organization :: " + empList.stream().count());

		// 18. Find employee count in every department
		Map<String, Long> employeeCountInDepartmentMap = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
		System.out.print("Employee department and its count :- \n" + employeeCountInDepartmentMap);

		// 19. Find the department which has the highest number of employees.
		Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream()
				.max(Map.Entry.comparingByValue());
		if (deptNameWithHighestEmp.isPresent()) {
			System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
		}

		// 20. Sorting a Stream by age and name fields.
		System.out.println("Sorting based on name and age:: ");
		Comparator<Employee> comparator1 = Comparator.comparing(Employee::name);
		Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::age);
		empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

		// 21. Highest experienced employees in the organization.
		/*
		 * Optional<Employee> seniorEmp = empList.stream().sorted(Comparator
		 * .comparingInt(e->e.joiningDate())).findFirst();
		 * System.out.println("Senior Employee Details :" + seniorEmp.get());
		 */

		// 22. Print average and total salary of the organization.
		DoubleSummaryStatistics empSalary = empList.stream().collect(Collectors.summarizingDouble(Employee::salary));

		System.out.println("Average Salary in the organization = " + empSalary.getAverage());
		System.out.println("Total Salary in the organization  = " + empSalary.getSum());

		// 23. Print Average salary of each department.
		System.out.println("Print Average salary of each department");
		Map<String, Double> avgSalary = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)));
		Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
		for (Map.Entry<String, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// 24. Find Highest salary in the organization.
		Optional<Employee> empHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::salary).reversed())
				.findFirst();

		System.out.println("Highest Salary in the organization : " + empHighest.get().salary());

		// 25. Find Second Highest salary in the organization.
		Optional<Employee> emp2 = empList.stream().sorted(Comparator.comparingDouble(Employee::salary).reversed())
				.skip(1).findFirst();
		System.out.println("Second Highest Salary in the organization : " + emp2.get().salary());

		// 26. Nth Highest salary.
		int n = 10;// this can be any nth number highest salary
		Optional<Employee> emp3 = empList.stream().sorted(Comparator.comparingDouble(Employee::salary).reversed())
				.skip(n - 1).findFirst();
		System.out.println("Second Highest Salary in the organization : " + emp3.get().salary());

		// 27. Find highest paid salary in the organization based on gender.
		Map<String, Optional<Employee>> highestPaidMFEmployee = empList.stream().collect(Collectors
				.groupingBy(Employee::gender, Collectors.maxBy((t1, t2) -> (int) (t1.salary() - t2.salary()))));
		System.out.println("Highest paid male and female employee : " + highestPaidMFEmployee);

		// 28. Find lowest paid salary in the organization based in the organization.
		Map<String, Optional<Employee>> lowestPaidMFEmployee = empList.stream().collect(Collectors
				.groupingBy(Employee::gender, Collectors.minBy((t1, t2) -> (int) (t1.salary() - t2.salary()))));

		System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);

		// 29. Sort the employees salary in the organization in ascending order
		System.out.println("Sorting the organization's employee salary in ascending order ");
		empList.stream().sorted(Comparator.comparingLong(Employee::salary)).toList().forEach(System.out::println);

		// 30. Sort the employees salary in the organization in descending order.
		System.out.println("Sorting the organization's employee salary in descending order ");
		empList.stream().sorted(Comparator.comparingLong(Employee::salary).reversed()).toList()
				.forEach(System.out::println);

		// 31. Highest salary based on department.
		System.out.println("Highest salary dept wise:: \n" + empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.collectingAndThen(Collectors.toList(),
						list -> list.stream().max(Comparator.comparingDouble(Employee::salary))))));

		// 32. Print list of employee’s second highest record based on department
		System.out
				.println(
						"Highest second salary dept wise:: \n"
								+ empList.stream()
										.collect(Collectors.groupingBy(Employee::dept,
												Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
														.sorted(Comparator.comparingDouble(Employee::salary).reversed())
														.skip(1).findFirst()))));

		// 33. Sort the employees salary in each department in ascending order
		System.out.println("Sorting the department wise employee salary in ascending order:: ");
		Map<String, Stream<Employee>> sortedEmployeeAsc = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.collectingAndThen(Collectors.toList(),
						list -> list.stream().sorted(Comparator.comparingDouble(Employee::salary)))));

		sortedEmployeeAsc.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v.collect(Collectors.toList()));
		});
		
		// 34. Sort the employees salary in each department in descending order
		System.out.println("Sorting the department wise employee salary in descending order ");
		Map<String, Stream<Employee>> sortedEmployeeDesc = empList.stream()
				.collect(Collectors.groupingBy(Employee::dept, Collectors.collectingAndThen(Collectors.toList(),
						list -> list.stream().sorted(Comparator.comparingDouble(Employee::salary).reversed()))));
		sortedEmployeeDesc.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v.collect(Collectors.toList()));
		});

	}
	private static void extracted() {
		List<Integer> listOfRandomIntegers = Data.getRandomeNumbers(10);
		List<String> listOfRandomStrings = Data.getRandomName(10);
		List<Employee> listOfEmployess = Data.getEmployeeRecords(20);

		// 1. Given a list of integers, filter out the odd numbers and collect the even
		// numbers into a new list.
		List<Integer> evenList = listOfRandomIntegers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println("even Int List " + evenList);

		// 2. Given a list of strings, convert each string to its uppercase form and
		// collect the results into a set.
		Set<String> toUpperSet = listOfRandomStrings.stream().map(String::toUpperCase).collect(Collectors.toSet());
		System.out.println(toUpperSet);

		// 3. System.out.println(listOfEmployess);
		// Given a list of employees, sort them by their salary in descending order and
		// collect the top 5 employees into a list.
		List<Employee> sortedEmployees = listOfEmployess.stream().sorted((e, j) -> e.salary().compareTo(j.salary()))
				.limit(5).collect(Collectors.toList());
		
		List<Employee> sortedEmployees2 = listOfEmployess.stream().sorted(Comparator.comparingInt(Employee::salary)).limit(5).collect(Collectors.toList());
		
		System.out.println("Sorted employees ");
		//sortedEmployees.stream().forEach(e -> System.out.println(e.name() + "   " + e.salary()));
		//sortedEmployees2.stream().forEach(e -> System.out.println(e.name() + " 2   " + e.salary()));

		// Given a list of integers, find the sum of all the integers using the `reduce` method.
		BinaryOperator<Integer> sumBin = (e, j) -> e + j;
		Supplier<Integer> supplyZero = () -> 0;
		System.out.println("Sum Bin " + sumBin.apply(10, 20));

		Optional<Integer> reduce = listOfRandomIntegers.stream().reduce(sumBin);
		System.out.println("Sum Of Ints :  " + reduce.orElseGet(supplyZero));
		System.out.println("Sum Of Ints :  " + reduce.orElseGet(() -> 0));

		// 5. Given a list of students with their grades, filter out the students who
		// scored above 90 and count them.
		// 5. Given employee find the who has salary more than 1000 and count them
		long countOf1000 = listOfEmployess.stream().filter(e -> e.salary() > 1000).count();
		System.out.println("Salary More that 1000 count : " + countOf1000);

		// 6. Given a list of strings, convert them to upper case and join them into a
		// single string separated by commas.
		String joinedString = listOfRandomStrings.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		System.out.println("Joined String  : " + joinedString);

		// 7. Given a list of transactions with their types, group the transactions by
		// type and count the number of transactions in each group.
		// 7. Given a list of employees with there dept , group them by dept and count
		// them in each group
		Map<String, Long> groupDeptAndCount = listOfEmployess.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.counting()));
		System.out.println("Group by dept and counting : "+groupDeptAndCount);
		
		//8. Given a list of products with their prices, calculate the total price of all products using the `map` and `reduce` methods.
		Map<String, DoubleSummaryStatistics> DeptAllSalary = listOfEmployess.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.summarizingDouble(e->e.salary())));
		// System.out.println("Group by dept and sumarising All Salry : "+DeptAllSalary);
		
		listOfEmployess.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.summarizingDouble(e->e.salary())));
		
		
		//9. Given a list of employees, filter the employees who have a salary above 5000 and collect them into a map with employee id as key and employee name as value
		
		Map<String, List<Employee>> ls2 = listOfEmployess.stream().filter(e->e.salary()>5000).collect(Collectors.groupingBy(Employee::dept));
		// System.out.println(ls2);
		
		
		Map<String, Set<Employee>> test23 = listOfEmployess.stream().filter(e->e.salary()>5000).collect(Collectors.groupingBy(Employee::dept,Collectors.filtering(e->e.salary()>6000, Collectors.toSet())));
		// System.out.println("test 23  "+test23);
		
		// 10 Paralle stream find Max
		
		Optional<Employee> maxInteger = listOfEmployess.parallelStream().sorted(Comparator.comparing(Employee::salary).reversed()).findFirst();
		maxInteger.ifPresent(e->System.out.println("Max salary "+e));
		OptionalInt firstMax = Data.getRandomeNumbers(677).parallelStream().mapToInt(e->e).max();
		firstMax.ifPresent(e->System.out.println("Max int "+e));
		
		IntStream.rangeClosed(1, 10).filter(e->e%2==0).dropWhile(e->e==4).forEach(System.out::println);
		
		OptionalLong max1=IntStream.rangeClosed(1, 1000).mapToLong(e->e).max();
		System.out.println(" Optional Max "+max1.orElse(-1));
		
		// Given a list of strings, filter out strings that are shorter than 5 characters and collect the remaining strings into a list.
		List<String> strLen5 = listOfRandomStrings.stream().filter(e->e.length()<=5).collect(Collectors.toList());
		System.out.println(" 5 Char String "+strLen5);
		
		//Given a list of strings, group them by their first character and collect the results into a map.
		Map<String, List<String>> stringLL = listOfRandomStrings.stream().collect(Collectors.groupingBy(e->String.valueOf(e.charAt(0))));
		System.out.println(" List str  "+stringLL);
		
		// Given a list of numbers, find the average of these numbers using the `Collectors.averagingDouble` method.
		Double avgDouble = listOfRandomIntegers.stream().collect(Collectors.averagingDouble(e->e));
		System.out.println(" average double : "+avgDouble);
		
		//Given a list of employees, find the employee with the minimum salary and the employee with the maximum salary.
		Optional<Employee> minSalary = listOfEmployess.stream().min(Comparator.comparingInt(Employee::salary));
		Optional<Employee> maxSalary = listOfEmployess.stream().max(Comparator.comparingInt(Employee::salary));
		
		System.out.println("min salary "+minSalary.get());
		System.out.println("max salary "+maxSalary.get());
		
		Map<Integer, List<Employee>> salaryCollect = listOfEmployess.stream().collect(Collectors.groupingBy(e->e.salary()));
		
		Map<Boolean, List<Integer>> partitionEven = listOfRandomIntegers.stream().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println("Part "+partitionEven);
		
		Predicate<Integer> isPrimePredicate=(e)->LLambda.isPrime(e);
		
		isPrimePredicate.test(100);
		
		Map<Boolean, List<Integer>> primeNums = listOfRandomIntegers.stream().collect(Collectors.partitioningBy(isPrimePredicate));
		System.out.println("Map of primes  "+primeNums);
	}
	public static boolean isPrime(int num) {
		boolean isPrime=true;
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
				return false;
		}
		return isPrime;
	}
	
}
