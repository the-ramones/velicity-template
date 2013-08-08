package sp.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 * Home controller test
 *
 * @author the-ramones
 */
public class HomeControllerTest {

    public HomeControllerTest() {
    }

    /**
     * Test of home method, of class HomeController.
     */
    @Test
    public void testHome() {
        Model model = null;
        HomeController instance = new HomeController();
        String result = instance.home(model);
        assertEquals("home", result);
    }
    /* Mock and POJOs
     * public classHomeControllerTest{
     @Test
   
     public void shouldDisplayRecentSpittles() {
     List<Spittle> expectedSpittles = asList(newSpittle(),newSpittle(),newSpittle());
     SpitterServicespitterService = mock(SpitterService.class);
     when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);
     HomeControllercontroller = new HomeController(spitterService);
     HashMap<String,Object> model = newHashMap<String,Object>();
     String viewName = controller.showHomePage(model);
     assertEquals("home",viewName);
     assertSame(expectedSpittles,model.get("spittles"));
     verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
     }
     }
     */
}