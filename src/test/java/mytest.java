import com.XS.controller.ClassController;
import com.XS.service.ClassService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

@Controller
public class mytest {
    @Autowired
    private ClassService testService;
    @Test
    public void test1(){
        ClassController classController = new ClassController();
        Model model = new Model() {
            public Model addAttribute(String s, Object o) {
                return null;
            }

            public Model addAttribute(Object o) {
                return null;
            }

            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            public boolean containsAttribute(String s) {
                return false;
            }

            public Map<String, Object> asMap() {
                return null;
            }
        };
        System.out.println(classController.showClassInfo(1,model));
        System.out.println(classController.ExamInfo(1,model));


    }
}
