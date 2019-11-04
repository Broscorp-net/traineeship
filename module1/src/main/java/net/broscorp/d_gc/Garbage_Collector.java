public class Garbage_Collector {

	public static void main(String[] args) {

	showRoom();
	
	}
public void finalize() {
	
	System.out.println("Garbage Collector is runing");
}
public static void showRoom() {	
for (int i = 0; i<=100; i++) {
	Garbage_Collector gc = new Garbage_Collector();
	System.out.println(gc.hashCode()+" number "+i);
	gc = null;
}
System.gc();
}
}