import com.hcltech.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    void contextLoads(){
        Assertions.assertNotNull(DatabaseUtil.getConnection());
    }
}
