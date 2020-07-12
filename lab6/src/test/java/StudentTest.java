import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    Student student = new Student();

    @Test (expected = Exception.class)
    public void setStudentName_EmptyName_ShouldThrowsException() throws Exception{
        String name = "";
        student.setStudentName(name);
    }

    @Test (expected = Exception.class)
    public void setStudentName_NameWithSpaces_ShouldThrowsException() throws Exception{
        String name = "    ";
        student.setStudentName(name);
    }

    @Test (expected = Exception.class)
    public void setStudentName_NameWithSpacesAndDigits_ShouldThrowsException() throws Exception{
        String name = "  13  23ds   . , !";
        student.setStudentName(name);
    }

    @Test (expected = Exception.class)
    public void setStudentName_NameWithSpacesInStartAndEnd_ShouldThrowsException() throws Exception{
        String name = "  sdf  ";
        student.setStudentName(name);
    }

    @Test (expected = Exception.class)
    public void setStudentName_NameWithSpacesBetweenWords_ShouldThrowsException() throws Exception{
        String name = "sdf    sdf";
        student.setStudentName(name);
    }

    @Test
    public void setStudentName_RightName_ShouldsetStudentName() throws Exception{
        String name = "Андлей";
        student.setStudentName(name);
        assertEquals(name, student.getName());
    }

    @Test (expected = Exception.class)
    public void setStudentSurname_EmptySurname_ShouldThrowException() throws Exception {
        String surname = "";
        student.setStudentSurname(surname);
    }

    @Test (expected = Exception.class)
    public void setStudentSurname_SurnameWithSpaces_ShouldThrowException() throws Exception {
        String surname = "    ";
        student.setStudentSurname(surname);
    }

    @Test (expected = Exception.class)
    public void setStudentSurname_SurnameWithSpacesBetweenWord_ShouldThrowException() throws Exception {
        String surname = "   jkdsd  ";
        student.setStudentSurname(surname);
    }

    @Test (expected = Exception.class)
    public void setStudentSurname_SurnameWithSpacesBetweenWords_ShouldThrowException() throws Exception {
        String surname = "   jkdsd  sdf ";
        student.setStudentSurname(surname);
    }

    @Test
    public void setStudentSurname_RightSurname_ShouldsetStudentSurname() throws Exception {
        String surname = "Бутиков";
        student.setStudentSurname(surname);
        assertEquals(surname, student.getSurname());
    }

    @Test
    public void setStudentPatronymic_EmptyPatronymic_ShouldsetStudentSurname() throws Exception{
        String patronymic = "";
        student.setStudentPatronymic(patronymic);
        assertEquals("", student.getPatronymic());
    }

    @Test (expected = Exception.class)
    public void setStudentPatronymic_PatronymicWithSpaces_ShouldThrowException() throws Exception{
        String patronymic = "  ";
        student.setStudentPatronymic(patronymic);
    }

    @Test (expected = Exception.class)
    public void setStudentPatronymic_PatronymicWithSpacesBetweenWords_ShouldThrowException() throws Exception{
        String patronymic = "sdf sdf";
        student.setStudentPatronymic(patronymic);
    }

    @Test (expected = Exception.class)
    public void setStudentPatronymic_PatronymicWithSpacesAfterWord_ShouldThrowException() throws Exception{
        String patronymic = " sdf ";
        student.setStudentPatronymic(patronymic);
    }

    @Test
    public void setStudentPatronymic_RightPatronymic_ShouldSetStudentPatronymic() throws Exception{
        String patronymic = "Саныч";
        student.setStudentPatronymic(patronymic);
        assertEquals(patronymic, student.getPatronymic());
    }

    @Test
    public void setStudentPatronymic_RightPatronymic_ShouldSetStudentPatronymic2() throws Exception{
        String patronymic = "Вальерович";
        student.setStudentPatronymic(patronymic);
        assertEquals(patronymic, student.getPatronymic());
    }

    @Test
    public void setStudentAge() throws Exception{
        int age = 14;
        student.setStudentAge(age);
        assertEquals(age, student.getAge());
    }

    @Test
    public void setMiddleAge() throws Exception{
        int age = 25;
        student.setStudentAge(age);
        assertEquals(age, student.getAge());
    }

    @Test
    public void setStudentAge2() throws Exception{
        int age = 60;
        student.setStudentAge(age);
        assertEquals(age, student.getAge());
    }

    @Test (expected = Exception.class)
    public void setNonValidAge() throws Exception{
        int age = 61;
        student.setStudentAge(age);
    }

    @Test
    public void renameStudent() throws Exception{
        String name = "Мишаня";
        String surname = "Лоскутков";
        String patronymic = "Вальерович";
        student.renameStudent(name, surname, patronymic);
        assertEquals(name, student.getName());
        assertEquals(surname, student.getSurname());
        assertEquals(patronymic, student.getPatronymic());
    }

    @Test (expected = Exception.class)
    public void renameStudent_NonValidName() throws Exception{
        String name = "Мишаня ";
        String surname = "Лоскутков";
        String patronymic = "Вальерович";
        student.renameStudent(name, surname, patronymic);
    }

    @Test (expected = Exception.class)
    public void renameStudent_NonValidSurname() throws Exception{
        String name = "Мишаня";
        String surname = "";
        String patronymic = "Вальерович";
        student.renameStudent(name, surname, patronymic);
    }

    @Test
    public void renameStudent_NonValidPatronymic() throws Exception{
        String name = "Мишаня";
        String surname = "Лоскутков";
        String patronymic = "";
        student.renameStudent(name, surname, patronymic);
        assertEquals(name, student.getName());
        assertEquals(surname, student.getSurname());
        assertEquals(patronymic, student.getPatronymic());
    }
}