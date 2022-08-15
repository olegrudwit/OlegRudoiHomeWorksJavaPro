package apps.inheritance;

public class Main {
    public Dog dog;
    public static void main(String[] args) {

        Cat cat1 = new Cat("Luna");
        System.out.println("Cat 1: " + cat1.getName());
        System.out.println(cat1.run(150));
        System.out.println(cat1.swim(15));
        System.out.println();

        Cat cat2 = new Cat(" Milo");
        System.out.println("Cat 2: " + cat2.getName());
        System.out.println(cat2.run(250));
        System.out.println(cat2.run(-15));
        System.out.println(cat2.swim(0));
        System.out.println();


        Cat cat3 = new Cat(" ");
        System.out.println();

        Cat cat4 = new Cat();
        cat4.setName("");
        System.out.println();

        System.out.println("Cats total: " + Cat.getCount() + "\n");

        Dog dog1 = new Dog("Charlie");
        System.out.println("Dog 1: " + dog1.getName());
        System.out.println(dog1.run(350));
        System.out.println(dog1.swim(8));
        System.out.println();

        Dog dog2 = new Dog();
        dog2.setName("Bella  ");
        System.out.println("Dog 2: " + dog2.getName());
        System.out.println(dog2.run(600));
        System.out.println(dog2.swim(-20));
        System.out.println();

        System.out.println("Dogs total: " + Dog.getCount() + "\n");

        Animal duck = new Animal("Lucy");
        System.out.printf("""
                Duck: %s
                %s
                %s
                """,
                duck.getName(), duck.run(1000), duck.swim(2000));
    }
}