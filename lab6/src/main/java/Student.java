public class Student {
    public final String INVALID_NAME = "Invalid name.";
    public final String INVALID_SURNAME = "Invalid surname.";
    public final String INVALID_PATRONYMIC = "Invalid patronymic.";
    public final String INVALID_AGE = "Invalid age.";
    public final String INVALID_ARGUMENT = "Invalid argument.";
    private final int MIN_AGE = 13;
    private final int MAX_AGE = 61;
    private String name;
    private String surname;
    private String patronymic;
    private int age;

    public Student(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Student() { }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentName(String name) throws Exception {
        if (!name.matches("\\S+")) {
            throw new Exception(INVALID_NAME);
        }
        setName(name);
    }

    public void setStudentSurname(String surname) throws Exception {
        if (!surname.matches("\\S+")) {
            throw new Exception(INVALID_SURNAME);
        }
        setSurname(surname);
    }

    public void setStudentPatronymic(String patronymic) throws Exception{
        if (!patronymic.matches("\\S*")) {
            throw new Exception(INVALID_PATRONYMIC);
        }
        setPatronymic(patronymic);
    }

    public void setStudentAge(int age) throws Exception{
        if (!(age > MIN_AGE && age < MAX_AGE)) {
            throw new Exception(INVALID_AGE);
        }
        setAge(age);
    }

    public void renameStudent(String name, String surname, String patronymic) throws Exception {
        if (name.matches("\\S+") && surname.matches("\\S+") && patronymic.matches("\\S*")) {
            setName(name);
            setSurname(surname);
            setPatronymic(patronymic);
        } else {
            throw  new Exception(INVALID_ARGUMENT);
        }
    }
}
