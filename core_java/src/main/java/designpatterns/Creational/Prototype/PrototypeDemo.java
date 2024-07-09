package designpatterns.Creational.Prototype;

public class PrototypeDemo {
	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		FileImporter fl=new FileImporter();
		fl.setName("abc.txt");
		fl.setLocation("c://d");
		fl.setLoading("tryu");
		
		System.out.println(fl.toString());
		
		FileImporter fl2=(FileImporter) fl.clone();
		System.out.println(fl2.toString());
	}
}
