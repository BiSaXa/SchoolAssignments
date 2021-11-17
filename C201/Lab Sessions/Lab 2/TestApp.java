// Test program for Lab 4 - Generic Box Using Array List
public class TestApp {
   public static void main(String[] args) {
      // creating the first box for storing Chocolate objects, adding objects to
      // the box and printing information about the contents of the box
      Box<Chocolate> myBox1 = new Box<>();
      myBox1.add(new Chocolate("Lindt", "Bitter"));
      myBox1.add(new Chocolate("Milka", "Milk"));
      myBox1.add(new Chocolate("Godiva", "Bitter"));
      myBox1.add(new Chocolate("Lindt", "White"));
      myBox1.add(new Chocolate("Cadbury", "Bitter"));
      myBox1.add(new Chocolate("Cadbury", "Milk"));
      System.out.println(myBox1); // using toString method of the Box class

      // creating the second box for storing Pen objects, adding objects to
      // the box and printing information about the contents of the box
      Box<Pen> myBox2 = new Box<>();
      myBox2.add(new Pen("Lamy", "Technical"));
      myBox2.add(new Pen("Lamy", "Ballpoint"));
      myBox2.add(new Pen("Faber", "Colored"));
      System.out.println(myBox2); // using toString method of the Box class

      // creating the third box for storing Chocolate objects, adding objects to
      // the box and printing information about the contents of the box
      Box<Chocolate> myBox3 = new Box<>();
      myBox3.add(new Chocolate("Guylian", "Bitter"));
      myBox3.add(new Chocolate("Guylian", "Milk"));
      myBox3.add(new Chocolate("Guylian", "White"));
      System.out.println(myBox3); // using toString method of the Box class

      // creating a Person object named Alice, adding her boxes and printing info
      Person p = new Person("Alice");
      p.addBox(myBox1);
      p.addBox(myBox2);
      p.addBox(myBox3);
      p.printPerson();
   }
}