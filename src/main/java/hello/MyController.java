package hello;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {
    private ProField pf;
    public ArrayList<ProField> al;
    @RequestMapping(value="/1", method= RequestMethod.GET)
    public String greetingForm(Model model, @ModelAttribute ProField proField) {

        al = new ArrayList<>();
        al.add(proField);
        model.addAttribute("1", new Greeting());

        System.out.println("pr str1 = " + proField.getStr1());
        return "1";
    }

    @RequestMapping(value="/1", method=RequestMethod.POST)
    public String greetingSubmit(Model model, HttpServletRequest hsr, @ModelAttribute Greeting greeting) {

        if (hsr.getParameterValues("lastField") != null) {


            String[] lastF = null;
            lastF = hsr.getParameterValues("lastField");
            List<String> d = new ArrayList<>();

            d = Arrays.asList(lastF);
            int count = d.size() + 1;
            for (int i = 2; i < count+1; i++) {
                ProField pf = new ProField();
                String s1 = hsr.getParameter("p_new_" + String.valueOf(i));
                String s2 = hsr.getParameter("l_" + String.valueOf(i));
                pf.setStr1(s2);
                pf.setStr2(s1);
                al.add(pf);
            }
        }
        model.addAttribute("1", greeting);
        model.addAttribute("al1", al);

        return "2";
    }
}
