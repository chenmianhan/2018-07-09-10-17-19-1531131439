package practice10;

import java.util.List;

public class Teacher extends Person {
    private List<Klass> classes;

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.classes = klasses;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = null;
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        String intro = super.introduce() + " I am a Teacher. ";
        if (classes == null || classes.size() == 0) intro += "I teach No Class.";
        else {
            StringBuilder classNum = new StringBuilder();
            for (Klass klass : classes) {
                classNum.append(klass.getNumber()).append(", ");
            }
            classNum = new StringBuilder(classNum.substring(0, classNum.length() - 2));
            intro += String.format("I teach Class %s.", classNum.toString());
        }
        return intro;
    }

    public String introduceWith(Student student) {
        String intro = super.introduce() + " I am a Teacher. ";
        if (!isTeaching(student)) {
            intro += String.format("I don't teach %s.", student.getName());
        } else {
            intro += String.format("I teach %s.", student.getName());
        }
        return intro;
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (klass.isIn(student)) return true;
        }
        return false;
    }
}
