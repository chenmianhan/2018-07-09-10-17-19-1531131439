package practice08;

public class Teacher extends Person {
    public Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klass = null;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String intro = super.introduce() + " I am a Teacher. ";
        if (klass == null) intro += "I teach No Class.";
        else intro += String.format("I teach Class %s.", klass.getNumber());
        return intro;
    }

    public String introduceWith(Student student) {
        String intro = super.introduce() + " I am a Teacher. ";
        if (getKlass().getNumber() != student.getKlass().getNumber()) {
            intro += "I don't teach " + student.getName() + ".";
        } else {
            intro += String.format("I teach %s.", student.getName());
        }
        return intro;
    }
}
