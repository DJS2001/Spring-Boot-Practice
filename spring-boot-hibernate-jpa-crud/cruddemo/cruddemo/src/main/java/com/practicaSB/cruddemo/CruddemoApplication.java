package com.practicaSB.cruddemo;

import com.practicaSB.cruddemo.dao.StudentDAO;
import com.practicaSB.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner -> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);

			createMultimpleStudents(studentDAO);
		};
	}

	private void createMultimpleStudents(StudentDAO studentDAO) {
		Student st1 = new Student("Jimeno","Jimenez","jj@email.com");
		Student st2 = new Student("alba","albez","aa@gmail.com");
		Student st3 = new Student("daniel","danielez","dd@gmail.com");

		studentDAO.save(st1);
		studentDAO.save(st2);
		studentDAO.save(st3);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Borrando todos los estudiantes");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Numero de filas borradas: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 2;
		System.out.println("Borrando el estudiante con id: " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Recuperar el estudiante en funcion de su ID
		int studentID = 1;
		System.out.println("Obteniendo el estudiante con ID: " + studentID);
		Student miEstudiante = studentDAO.findById(studentID);

		// Cambiar el nombre a "Scooby"
		System.out.println("Actualizando estudiante...");
		miEstudiante.setFirstName("Scooby");

		// Actualizar el estudiante
		studentDAO.update(miEstudiante);
		// MOstar el estudiante actualizado
		System.out.println("Estudiante actualizado: " + miEstudiante);
	}

	private void queryForStudentsLastName(StudentDAO studentDAO) {
		// Obtener la lista de estudiantes
		List<Student> losEstudiantes = studentDAO.findByLastName("Duck");

		// Mostar la lista de estudiantes
		for (Student tempStudent : losEstudiantes){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Obtener una lista de estudiante
		List<Student> losEstudiantes = studentDAO.findAll();

		// Mostar lista de estudiantes
		for (Student tempStudent : losEstudiantes) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Crear un objeto estudiante
		System.out.println("Creando un nuevo objeto de estudiante...");
		Student tempStudent = new Student("Daffy","Duck","corredodavid@gmail.com");

		// Guardar el estudiante
		System.out.println("Guardando el estudiante");
		studentDAO.save(tempStudent);

		// Mostrar el id del estudiante guardado
		int id = tempStudent.getId();
		System.out.println("Estudiante guardado. Id generado: " + id);

		// Obtener el objeto estudiante en base a su id
		System.out.println("Obteniendo estudiante con id: " + id);
		Student miEstudiante = studentDAO.findById(id);

		// Mostar el estudiante
		System.out.println("Estudiante encontrado: " + miEstudiante);
	}

	private void createStudent(StudentDAO studentDAO) {
		// crear el objeto student
		System.out.println("Creando un nuevo objeto de estudiante...");
		Student tempStudent = new Student("David","Jimenez","correodavid@gmail.com");

		// guardar el objeto student
		System.out.println("Guardando un nuevo objeto de estudiante...");
		studentDAO.save(tempStudent);

		// mostar el id del student guardado
		System.out.println("Estudiante guardado. Mostrando el id generado: " + tempStudent.getId());
	}
}
