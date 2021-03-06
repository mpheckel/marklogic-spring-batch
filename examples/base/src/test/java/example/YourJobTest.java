package example;

import com.marklogic.junit.ClientTestHelper;
import com.marklogic.spring.batch.test.AbstractJobTest;
import org.junit.Before;
import org.junit.Test;

public class YourJobTest extends AbstractJobTest {

    private ClientTestHelper client;
    
    @Before
    public void setup() {
        client = new ClientTestHelper();
        client.setDatabaseClientProvider(getClientProvider());
    }

    @Test
    public void findZeroMonstersInDatabaseTest() {
        runJob(
                YourJobConfig.class,
                "--output_collections", "monster");
        client.assertCollectionSize("Expecting 1 items in monster collection", "monster", 1);
    }
}
