package com.dao;
import com.model.Student;
import java.util.List;
public interface StudentDao extends Dao{
    public boolean addStudent(Student s) throws DaoException;
    public List<Student> listStudent() throws DaoException;
    public int removeStudent(int id) throws DaoException;

}
