package practice11;

public class Teacher extends Person implements JoinObserver {
    public List<Klass> classes;
    public Teacher(int id,String name, int age ,List<Klass> klasses){
        super(id,name, age);
        this. classes=klasses;
    }
    public Teacher(int id,String name,int age){
        super(id,name,age);
        classes=null;
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        String intro=super.introduce()+" I am a Teacher. ";
        if(classes==null||classes.size()==0)intro+="I teach No Class.";
        else {
            String classNum="";
            for (Klass klass:classes) {
                classNum+=klass.getNumber()+",";
            }
            classNum=classNum.substring(0,classNum.length()-1);
            intro+="I teach Class "+ classNum+".";
        }
        return intro;
    }
    public String introduceWith(Student student){
        String intro=super.introduce()+" I am a Teacher. ";
        if(!isTeaching(student))
        {
            intro+="I don't teach "+student.getName()+".";
        }
        else {
            intro+="I teach "+student.getName()+".";
        }
        return intro;
    }
    public boolean isTeaching(Student student){
        for(Klass klass :classes) {
            if (klass.isIn(student)) return true;
        }
        return false;
    }

    @Override
    public void notifyLeaderAssgin(Student student) {
        System.out.println(String.format("I am %s. I know %s become Leader of Class %s.",
                getName(),student.getName(),student.getKlass()));
    }

    @Override
    public void notifyMemberAppend(Student student) {
        System.out.println(String.format("I am %s. I know %s has joined Class %s.",
                getName(),student.getName(),student.getKlass()));
    }
}