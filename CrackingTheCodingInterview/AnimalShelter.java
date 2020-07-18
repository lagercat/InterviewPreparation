import java.util.LinkedList;
import java.lang.IllegalStateException;

public class AnimalShelter {

    public static interface Animal {} 
    public static class Dog implements Animal {}
    public static class Cat implements Animal {}

    private class Pair<K, T> {
        public K first;
        public T second;

        public Pair(K first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    private int length;
    private LinkedList<Pair<Dog, Integer>> dogs;
    private LinkedList<Pair<Cat, Integer>> cats;

    public AnimalShelter() {
        length = 0;
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public int getLength() {
        return length;
    }

    public void enqueue(Dog newAnimal) {
        dogs.push(new Pair<>(newAnimal, length));
        length++;
    }

    public void enqueue(Cat newAnimal) {
        cats.push(new Pair<>(newAnimal, length));
        length++;
    }

    public Animal dequeueAny() {
        if (length == 0) {
            throw new IllegalStateException("You are trying to pop and empty shelter.");
        }


        length--;
        if (cats.isEmpty() || (!dogs.isEmpty() && dogs.peekLast().second > cats.peekLast().second)) {
            return dogs.pop().first;
        }

        return cats.pop().first;
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            throw new IllegalStateException("There are no dogs in this shelter");
        }

        length--;
        return dogs.pop().first;
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            throw new IllegalStateException("There are no cats in this shelter");
        }

        length--;
        return cats.pop().first;
    }

    public static void main(String args[]) {
        AnimalShelter shelter = new AnimalShelter();
        try {
            shelter.dequeueAny();
        } catch (IllegalStateException e) {
            Dog d1 = new Dog();
            Dog d2 = new Dog();
            Cat c1 = new Cat();

            shelter.enqueue(c1);
            shelter.enqueue(d1);
            shelter.enqueue(d2);

            System.out.println(shelter.dequeueCat() == c1);
            System.out.println(shelter.dequeueAny() == d2);
            System.out.println(shelter.dequeueDog() == d1);
        }
    }
}