import com.mapper.io.InstanceOverFlowException;
import com.mapper.io.LoadBalancer;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class LoadBalancerTest {

    @InjectMocks
    private LoadBalancer loadBalancer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterInstance(){
        String instanceName = loadBalancer.register();
        assertNotNull(instanceName);
    }

    @Test
    void testRegisterInstance_whenMoreThanTenInstancesRegistered_shouldThrowException(){
        InstanceOverFlowException instanceOverFlowException = assertThrows(
                InstanceOverFlowException.class,
                ()-> {
                    for(int i =0; i <= 11; i++)
                        loadBalancer.register();
                });
        assertEquals("Can not have more than 10 instances", instanceOverFlowException.getMessage());
    }

    @Test
    void testRegisterInstance_whenLessThenOrEqualToTenInstancesRegistered_shouldRegisterSuccessfully(){
        int count = 0;
        for (int i=0; i<10; i++){
            loadBalancer.register();
            count++;
        }
        assertEquals(10, count);
    }
}
