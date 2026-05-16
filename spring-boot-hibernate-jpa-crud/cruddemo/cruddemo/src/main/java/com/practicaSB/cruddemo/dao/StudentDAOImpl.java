package com.practicaSB.cruddemo.dao;

import com.practicaSB.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // Definir campo para el entity manager
    private EntityManager entityManager;

    //Inyectar entity manager usando constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementar el metodo save()

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Crear una consulta
        TypedQuery<Student> laConsulta = entityManager.createQuery("FROM Student", Student.class);

        // Devolver los resultados de la consulta
        return  laConsulta.getResultList();
    }

    @Override
    public List<Student> findByLastName(String elApellido) {
        // Crear consulta
        TypedQuery<Student> laConsulta = entityManager.createQuery(
                "FROM Student WHERE lastName=:losDatos", Student.class);

        // Establecer los parametros de la consulta
        laConsulta.setParameter("losDatos", elApellido);

        // Devolver los parametros de la consulta
        return laConsulta.getResultList();
    }

    @Override
    @Transactional
    public void update(Student elEstudiante) {
        entityManager.merge(elEstudiante);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // Recuperar al estudiante
        Student elEstudiante = entityManager.find(Student.class, id);

        // Borrar al estudiante
        entityManager.remove(elEstudiante);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }



}
