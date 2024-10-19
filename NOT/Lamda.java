public class Lamda {
    public static void main(String...args) {
        // Walk obj = new WalkFast();
        // obj.walking(9);

        Walk obj = (step) -> {
            System.out.println(step);
            return step;
        };
        obj.walking(0);

        Walk obj2 = (steps) -> steps;
    }
}

// Functional Interface - interface having only one method
interface Walk {
    int walking(int stpes); 
}

class WalkFast implements Walk {
    @Override
    public int walking(int steps) {
        System.out.println(steps);
        return steps;
    }
}
