import com.revature.models.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee setTester = new Employee();
    Employee getTester = new Employee(1,"testUser","testPass","test","user","testEmail",4);

    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void getId() {
        int assertedID = 1;
        assert(getTester.getId() == assertedID);
    }

    @Test
    public void setId() {
        int assertedID = 1;
        setTester.setId(1);
        assert(setTester.getId() == assertedID);
    }

    @Test
    public void getFirstName() {
        String assetedName = "testUser";
        assert(assetedName.equals(getTester.getFirstName()));
    }

    @Test
    public void setFirstName() {
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void setLastName() {
    }

    @Test
    public void getUsername() {
    }

    @Test
    public void setUsername() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void getUserRole() {
    }

    @Test
    public void setUserRole() {
    }
}