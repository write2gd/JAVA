/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.dao;

import org.gd.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dasg
 */
@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{   

    @Override
    public void delete(Student t);

    @Override
    public void delete(Long id);

    @Override
    public long count();

    @Override
    public Iterable<Student> findAll();

    @Override
    public boolean exists(Long id);

    @Override
    public Student findOne(Long id);

    @Override
    public <S extends Student> S save(S s);
    
}
