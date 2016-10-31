package hello;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MyController {
    private ProField pf;
    ArrayList<ProField> al;
    @RequestMapping(value="/1", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        al = new ArrayList<>();
        model.addAttribute("1", new Greeting());
        model.addAttribute("3", new ProField());
        return "1";
    }

    @RequestMapping(value="/1", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ProField proField, Greeting greeting, Model model) {


//        proField.setStr1("asdasd");
//        proField.setStr2("cvxcvxcv");
        al.add(pf);
        al.add(proField);
        al.add(proField);

        model.addAttribute("1", greeting);
        model.addAttribute("al1", al);

        return "2";
    }
    @RequestMapping(value="/3", method=RequestMethod.POST)
    public void greetingSubmit2(@ModelAttribute ProField proField, Model model, HttpServletRequest request) {
        String s = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        proField.setStr1(s);
        proField.setStr2(s2);
        pf = proField;
        model.addAttribute("3", proField);
    }

}
