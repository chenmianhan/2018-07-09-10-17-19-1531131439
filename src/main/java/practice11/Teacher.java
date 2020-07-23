package practice11;

import java.util.List;

public class Teacher extends Person implements JoinObserver, AssignObserver {
    public List<Klass> classes;

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass aClass : classes) {
            aClass.getJoinObservers().add(this);
            aClass.getAssignObservers().add(this);
        }
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
            intro += "I teach Class " + classNum + ".";
        }
        return intro;
    }

    public String introduceWith(Student student) {
        String intro = super.introduce() + " I am a Teacher. ";
        if (!isTeaching(student)) {
            intro += "I don't teach " + student.getName() + ".";
        } else {
            intro += "I teach " + student.getName() + ".";
        }
        return intro;
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (klass.isIn(student)) return true;
        }
        return false;
    }

    @Override
    public void notifyLeaderAssign(Student student) {
        System.out.print(String.format("I am %s. I know %s become Leader of Class %s.\n",
                getName(), student.getName(), student.getKlass().getNumber()));
    }

    @Override
    public void notifyMemberAppend(Student student) {
        System.out.print(String.format("I am %s. I know %s has joined Class %s.\n",
                getName(), student.getName(), student.getKlass().getNumber()));
    }
}