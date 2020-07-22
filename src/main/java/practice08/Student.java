package practice08;

public class Student extends Person {
    public Klass klass;
    public Student(int id ,String name, int age, Klass klass){
        super(id,name,age);
        this.klass=klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        if(getKlass().getLeader()==null||!getKlass().getLeader().equals(this))
            return super.introduce()+" I am a Student. I am at "+klass.getDisplayName()+".";
        else return super.introduce()+" I am a Student. I am Leader of "+klass.getDisplayName()+".";

    }
}
