package practice06;

public class Teacher extends Person {
    public int klass;

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
        klass = -1;
    }

    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String intro = super.introduce() + " I am a Teacher. ";
        if (klass == -1) intro += "I teach No Class.";
        else intro += String.format("I teach Class %s.", klass);
        return intro;
    }
}
