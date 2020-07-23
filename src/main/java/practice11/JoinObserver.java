package practice11;

import practice11.Student;

/****
 *@author:cmh
 *@date: 2020/7/230054
 *@descrption:
 */
public interface JoinObserver {
    void notifyLeaderAssgin(Student student);
    void notifyMemberAppend(Student student);

}
