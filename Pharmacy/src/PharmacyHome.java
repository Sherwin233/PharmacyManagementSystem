import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class PharmacyHome {
	public static List<Medicines> medicines = new ArrayList<>();
	public static List<Employees> employees = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sc1 = new Scanner(System.in);
	public static boolean status = true;
	public static String cusName, drugName, adUser, empPass;
	public static double totalprice,total,pay, price;
	public static int attempt = 3,itemCode, empID,casUser, quantitys, Itemstock, mquantity;
	public static String mName, empName, empGender, empPos;
	public static int empAge;
	public static double mPrice;
	public static char choose;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		PharmacyHome home = new PharmacyHome();
		home.PharmaOutput();
	}
	private void addMedicines(Medicines medicine) {
		System.out.println("Medicine has been created.");
		medicines.add(medicine);
	}
	private void addEmployees(Employees employee) {
		System.out.println("Employee has been added.");
		employees.add(employee);
	}
	private Employees inputEmployees() {
		System.out.println("------------------------------------------------------------------");
		System.out.println(" \t\t\t\tINPUT EMPLOYEES");
		System.out.println("------------------------------------------------------------------");
		Employees employee = new Employees(empID, empName, empPass, empAge, empGender, empPos);
		System.out.println("Enter Employee ID: ");
		empID = sc.nextInt();
		if(employee.getEmpID() != empID) {
			
		}else{
			System.out.println("Employee ID has been existed.");
			System.out.println();
			addEmployees(inputEmployees());
			status = true;
		}
		System.out.println("Enter Employee Name: ");
		empName = sc1.next();
		System.out.println("Enter password: ");
		empPass = sc.next();
		System.out.println("Enter Employee Age: ");
		empAge = sc.nextInt();
		System.out.println("Enter Employee Gender: ");
		System.out.println(" [1] - Male");
		System.out.println(" [2] - Female");
		empGender = sc.next();
		switch(empGender) {
		case "1":
			empGender = "Male";
			break;
		case "2":
			empGender = "Female";
			break;
			
		}
		
		System.out.println("Enter Employee Position: ");
		System.out.println("[1] - Cashier");
		System.out.println("[2] - Staff");
		System.out.print("Enter here:");
		empPos = sc1.next();
		switch(empPos){
		case "1":
			empPos = "Cashier";
			break;
		case "2":
			empPos= "staff";
			break;
		
		}
		Employees employes = new Employees(empID, empName, empPass, empAge, empGender, empPos);
		return employes;
	}
		
private void PharmaOutput() {
		while(status) {
		System.out.println("------------------------------------------------------------------");
		System.out.println(" \t\t\tPHARMACY MANAGEMENT SYSTEM");
		System.out.println("------------------------------------------------------------------");
		System.out.println(" [1] - ADMIN LOGIN");
		System.out.println(" [2] - CASHIER LOGIN");
		System.out.println(" [3] - Exit");
		System.out.println("------------------------------------------------------------------");
		System.out.print("Select operation: ");
		choose = sc.next().charAt(0);
		
		switch(choose) {
		case '1':
			Admin_Account();
			status = true;
			break;
		case '2':
			Cashier_Account();
			status = true;
			break;
		case '3':
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input please try again!!");	
			status=true;
		    break;
		}
	 }
	}
	private void Admin_Account() {
		status = true;
		while(attempt < 4) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(" \t\t\t\tADMIN LOGIN SYSTEM");
			System.out.println("------------------------------------------------------------------");
			if(attempt != 0) {
				System.out.println("Username: ");
				adUser = sc.next();
				System.out.println("Password: ");
				String adPass = sc.next();
				if(adUser.equals("admin") && adPass.equals("1234")) {
					Admin_DASHBOARD();
					status = true;
				}else {
					System.out.println("Incorrect username or password.");
					System.out.println("Login attempt: " + attempt);
					attempt--;
				}
			}else{
				System.out.println("Maxmimum reached numbers of exceeded.");
				System.exit(0);
			}
		}
	}
	private void Cashier_Account() {
		status = true;
		while(attempt < 4) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(" \t\t\t\tCASHIER LOGIN SYSTEM");
			System.out.println("------------------------------------------------------------------");
			if(attempt != 0) {
				System.out.println("Employee ID: ");
				casUser = sc.nextInt();
				System.out.println("Password: ");
				String casPass = sc.next();
				if(casUser == empID && casPass.equals(empPass)) {
					Cashier_DASHBOARD();
					status = true;
				}else {
					System.out.println("Incorrect username or password.");
					System.out.println("Login attempt: " + attempt);
					attempt--;
				}
			}else{
				System.out.println("Maxmimum reached numbers of exceeded.");
				System.exit(0);
			}
		}
	}
	private void Admin_DASHBOARD() {
		status = true;
		while(status) {
			System.out.println();
			System.out.println();
			System.out.println("You're logged in as: " + adUser);
			System.out.println("------------------------------------------------------------------");
			System.out.println(" \t\t\t\tADMIN DASHBOARD");
			System.out.println("------------------------------------------------------------------");
			System.out.println(" [1] - Add Medicine");
			System.out.println(" [2] - Add Employee");
			System.out.println(" [3] - Show All Medicine");
			System.out.println(" [4] - Show All Employee");
			System.out.println(" [5] - Edit Medicine");
			System.out.println(" [6] - Edit Employee");
			System.out.println(" [7] - Remove Medicine");
			System.out.println(" [8] - Remove Employee");
			System.out.println(" [9] - Logout");
			System.out.println("------------------------------------------------------------------");
			System.out.print("Select operation: ");
			choose = sc.next().charAt(0);
			
			switch(choose) {
			case '1':
				addMedicines(inputMedicine());
				status = true;
				break;
			case '2':
				addEmployees(inputEmployees());
				status = true;
				break;
			case '3':
				ShowAllMedicine();
				status = true;
				break;
			case '4':
				ShowAllEmployee();
				status = true;
				break;
			case '5':
				UpdateMedicine();
				status = true;
				break;
			case '6':
				UpdateEmployee();
				status = true;
				break;
			case '7':
				RemoveMedicineID(itemCode);
				status = true;
				break;
			case '8':
				RemoveEmployee(empID);
				status = true;
				break;
			case '9':
				PharmaOutput();
				status = true;
				break;
		   default:
				System.out.println("Invalid input please try again!!");	
			    break;
			}
		}
	}
	private void Cashier_DASHBOARD() {
		status = true;
		while(status) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("Welcome: " + empName + " \t\t\t\tCASHIER DASHBOARD");
			System.out.println("------------------------------------------------------------------");
			System.out.println(" [1] - Menu Medicines");
			System.out.println(" [2] - Bill/Sale Meidicines");
			System.out.println(" [3] - Receipt");
			System.out.println(" [4] - Logout");
			System.out.println("------------------------------------------------------------------");
			System.out.print("Select operation: ");
			choose = sc.next().charAt(0);
			
			switch(choose) {
			case '1':
				MenuMedicine();
				status = true;
				break;
			case '2':
				Bill_Sale();
				status = true;
				break;
			case '3':
				Receipt();
				status = true;
				break;
			case '4':
				PharmaOutput();
				status = true;
				break;
		   default:
				System.out.println("Invalid input please try again!!");	
			    break;
			}
		}
	}
	private Medicines inputMedicine() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println(" \t\t\t\t\t\tINPUT MEDICINES");
		System.out.println("---------------------------------------------------------------------------------------------------");
		Medicines medicine = new Medicines(itemCode, mName, mPrice,Itemstock);
		System.out.println("Enter Medicine Code: ");
		itemCode = sc.nextInt();
		if(itemCode != medicine.getItemCode()) {
			
			
		}else{
			System.out.println("Medicine ID has been existed.");
			System.out.println();
			addMedicines(inputMedicine());
			status = true;
		}
		System.out.println("Enter Medicine Name: ");
		mName = sc.next();
		System.out.println("Enter Medicine Price: ");
		mPrice = sc.nextDouble();
		System.out.println("Enter Medicine Quantity Stock: ");
		Itemstock = sc.nextInt();
		
		Medicines medicines = new Medicines(itemCode, mName, mPrice,Itemstock);
		return medicines;
	}
	private void ShowAllMedicine() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\tALL MEDICINES DETAILS");
		System.out.println("Medicine ID: \t\tMedicine Name: \t\tMedicine Price: \t\tMedicine Quantity");
		System.out.println("---------------------------------------------------------------------------------------------------");
		for(Medicines medicine : medicines) {
			System.out.println(medicine.getItemCode() + "\t\t\t" + medicine.getItemName() + "\t\t\t" + medicine.getItemPrice() + "\t\t\t\t" +medicine.getItemStock());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
		}
	}
	private void ShowAllEmployee() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\tALL EMPLOYEE DETAILS");
		System.out.println("Employee ID: \t\tEmployee Name: \t\tEmployee Age: \t\tEmployee Gender: \t\tEmployee Position:");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for(Employees employee : employees) {
			System.out.println(employee.getEmpID() + "\t\t\t" + employee.getEmpName() + "\t\t\t" + employee.getEmpAge() + "\t\t\t" + employee.getEmpGender() + "\t\t\t" + employee.getEmpPos());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
		}
	}
	private void UpdateMedicine() {
		status = false;
		System.out.println("Enter Meidicine ID to update: ");
		itemCode = sc.nextInt();
		System.out.println("-----------------------------");
		ListIterator<Medicines> medicine = medicines.listIterator();
		
		while(medicine.hasNext()) {
			Medicines e = medicine.next();
			if(e.getItemCode() == itemCode) {
				
				System.out.println("Enter Medicine ID: ");
				itemCode = sc.nextInt();
				
				System.out.println("Enter Medicine Name: ");
				String medName = sc.next();
				
				System.out.println("Enter Medicine Price: ");
				double medPrice = sc.nextDouble();
				
				System.out.println("Enter Medicine Quantity: ");
				Itemstock = sc.nextInt();
				
				medicine.set(new Medicines(itemCode, medName, medPrice, Itemstock));
				
				status = true;
			}
		}
		if(!status) {
			System.out.println("Record not found");
		}else {
			System.out.println("Record has been updated");
		}
	}
	private void UpdateEmployee() {
		status = false;
		System.out.println("Enter Employee ID to update: ");
		empID = sc.nextInt();
		System.out.println("-----------------------------");
		ListIterator<Employees> employee = employees.listIterator();
		
		while(employee.hasNext()) {
			Employees e = employee.next();
			if(e.getEmpID() == empID) {
				
				System.out.println("Enter Employee Name: ");
				String name = sc.next();
				
				System.out.println("Do you want to change your password? [Y]-[N]");
				String change = sc.next();
				if(change.equals("Y")) {
					System.out.println("Enter password: ");
					empPass = sc.next();
				}else {
					
				}
				
				System.out.println("Enter Employee Age: ");
				int age = sc.nextInt();
				
				System.out.println("Enter Employee Gender: ");
			     String empGender = sc.next();
				switch(empGender) {
				case "1":
					empGender = "Male";
					break;
				case "2":
					empGender = "Female";
					break;
					default:
						System.out.println("Wrong Input");
						status=true;
						break;
				}
				System.out.println("Enter Employee Position: ");
				System.out.println("[1] - Cashier");
				System.out.println("[2] - Staff");
				System.out.print("Enter here:");
				String empPos = sc1.next();
				switch(empPos) {
				case "1":
					empPos = "Cashier";
					break;
				case "2":
					empPos= "staff";
					break;
				 }
				employee.set(new Employees(itemCode, name, empPass, age, empGender, empPos));
				
				status = true;
			}
		}
		if(!status){
			System.out.println("Record not found");
		}else {
			System.out.println("Record has been updated");
		}
	}
	private void RemoveMedicineID(int id) {
		System.out.println("Enter Medicine ID: ");
		id = sc.nextInt();
		
		ListIterator<Medicines> medicine = medicines.listIterator();
		while(medicine.hasNext()) {
			Medicines m = medicine.next();
			if(m.getItemCode() == id){
				medicine.remove();
				status = true;
			}
		}
		if(!status) {
			System.out.println("Record has not been found");
		}else {
			System.out.println("Record has been deleted.");
		}
	}
	private void RemoveEmployee(int empID) {
		System.out.println("Enter Employee ID: ");
		empID = sc.nextInt();
		
		ListIterator<Employees> employee = employees.listIterator();
		while(employee.hasNext()) {
			Employees e = employee.next();
			if(e.getEmpID() == empID) {
				employee.remove();
				status = true;
			}
		}
		if(!status) {
			System.out.println("Record has not been found");
		}else {
			System.out.println("Record has been deleted.");
		}
	}
	private void MenuMedicine() {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\tALL MEDICINES DETAILS");
		System.out.println("Medicine ID: \t\tMedicine Name: \t\tMedicine Price: \t\tMedicine Quantity");
		System.out.println("------------------------------------------------------------------------------");
		for(Medicines medicine : medicines){
        System.out.println(medicine.getItemCode() + "\t\t" + medicine.getItemName() + "\t\t" + medicine.getItemPrice() + "\t\t" + medicine.getItemStock());
		}
	}
	private void Bill_Sale(){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\tALL MEDICINES DETAILS");
		System.out.println("Medicine ID: \t\tMedicine Name: \t\tMedicine Price: \t\tMedicine Quantity");
		System.out.println("------------------------------------------------------------------------------");
		for(Medicines medicine : medicines){
		System.out.println(medicine.getItemCode() + "\t\t\t" + medicine.getItemName() + "\t\t\t" + medicine.getItemPrice() + "\t\t\t" + medicine.getItemStock());
		}
		 System.out.println("Enter Medicine ID: ");
			itemCode = sc.nextInt();
		    for(Medicines medicine : medicines){
		    if(medicine.getItemCode()==itemCode){
		    System.out.println("Drug Name: " + medicine.getItemName());
			System.out.println("Drug Price: " + medicine.getItemPrice());
			System.out.println("Drug Quantity:");
			quantitys = sc.nextInt();
			int x = medicine.getItemStock();
			int y = x - quantitys;
			medicine.setItemStock(y);
			mquantity=medicine.getItemStock()-quantitys;
			totalprice=(medicine.getItemPrice()*quantitys);
			if(quantitys>medicine.getItemStock()){
			System.out.println("Not enough Stock");
			status = true;
			}else{
			System.out.println("Total Amount: "+totalprice);
		    System.out.print("ENTER PAYMENT:");   
			pay=sc.nextDouble();
		    if(pay<totalprice){
			System.out.println("NOT ENOUGH PAYMENT "); 
		    }else{
		    total=pay-totalprice;
		    System.out.println("TOTAL CHANGE IS :$"+ total);
			   }
			 }
		   }
	   }
	}
	 private void Receipt(){
	for(Medicines medicine :medicines) {
		
	    System.out.print("\n===============================================\n");
	    System.out.println("Pharmacy Management System");
        System.out.println("Cotumer Reciept");
        System.out.println("Location:Carmen CDOC");
		System.out.println("==========================================\n"
				            +"\nDrug Name:"+medicine.getItemName()
				            +"\nItem Price:"+medicine.getItemPrice()
				            +"\nItem Quantity:"+quantitys
				            +"\nItem Amount:"+totalprice
				            +"\nCostumer Change:"+total);
		System.out.println("\n=======================================");
	}
   }
}