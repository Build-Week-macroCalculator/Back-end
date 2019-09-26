package com.lambdaschool.macroCalc.services;

import com.lambdaschool.macroCalc.StartHereApplication;
import com.lambdaschool.macroCalc.models.User;
import com.lambdaschool.macroCalc.models.UserRoles;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.repository.UsermetricsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMetricsServiceImplUnitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UsermetricsService umService;

    @Mock
    private UsermetricsRepository umRepo;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void C_findAll()
    {
        assertEquals(2, umService.findAll().size());
    }

    @Test
    public void B_findUserMetricsById()
    {
        assertEquals("male", umService.findUserMetricsById(9).getGender());
    }

    @WithUserDetails("testdog")
    @Transactional
    @Test
    public void D_delete()
    {
        Usermetrics testUm = umService.findUserMetricsById(9);
        umService.delete(testUm.getUsermetricsid());
        assertEquals(1, umService.findAll().size());
    }

    @WithUserDetails("testbarn")
    @Transactional
    @Test
    public void F_save()
    {
        User testBarn = userService.findByName("testbarn");

        Usermetrics testUm = new Usermetrics(testBarn, "male", 25, "72", 210, "1-2 per week", "Lose weight moderately", "3 meals a day");

        Usermetrics saveTestMetrics = umService.save(testUm);

        System.out.println("*** DATA ***");
        System.out.println(saveTestMetrics);
        System.out.println("*** DATA ***");

    }

    @WithUserDetails("testbarn")
    @Transactional
    @Test
    public void Z_update() {

        User testBarn = userService.findByName("testbarn");

        Usermetrics testUm = new Usermetrics(testBarn, "male", 25, "72", 210, "1-2 per week", "Lose weight moderately", "3 meals a day");

        Usermetrics saveTestMetrics = umService.save(testUm);

        Usermetrics updatedUm = umService.update(saveTestMetrics, testUm.getUsermetricsid());

        assertEquals("3 meals a day", updatedUm.getMeals());

    }
}
