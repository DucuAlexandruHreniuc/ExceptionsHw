import org.apache.logging.log4j.LogManager;
public class StudentRepository extends Student {
    public StudentRepository(String firstName, String lastName, String dateOfBirth, Gender gender, String cnp) {
        super(firstName, lastName, dateOfBirth, gender, cnp);
    }

    public static void main(String[] args) {
        try {
            Student s1 = new Student("Bogdan", "Hreniuc", "1998-03-03", Gender.Male, "1980303244501");
            addStudent(s1);
            addStudent(new Student("Viorel", "Viorescu", "2007-06-21", Gender.Male, "105213125125"));
            addStudent(new Student("Rebeca", "Stanescu", "1991-12-15", Gender.Female, ""));
            addStudent(new Student("Alex", "Alexescu", "2003-02-14", Gender.Male, "120041412431"));
            addStudent(new Student("Bogdana", "Bogdanovici", "1953-01-01", Gender.Female, "12313541251"));
            addStudent(new Student("Oldie", "McOldingson", "1900-01-01", Gender.Female, "193949129431"));
            addStudent(new Student("Ricardo", "Esteban", "2003-03-05", Gender.Male, "198313141214"));
            addStudent(new Student("Impostor", "Impostorovic", "1998-03-03", Gender.Male, "1980303244501"));
            //listAllStudentsByAge(19);
            deleteStudentByCnp("1980303244501");
            listStudentsByDateOfBirth();
        }catch (Exception e){
            org.apache.logging.log4j.Logger log4jlogger = LogManager.getLogger(StudentRepository.class);
            log4jlogger.error("Error");

        }
        }

    }
