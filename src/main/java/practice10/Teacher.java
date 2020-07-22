package practice10;

import java.util.List;

public class Teacher extends Person {
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
}
