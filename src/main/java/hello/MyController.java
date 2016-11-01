package hello;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {
    private ProField pf;
    public ArrayList<ProField> al;
    SaverClass saverClass = new SaverClass();
    @RequestMapping(value="/1", method= RequestMethod.GET)
    public String greetingForm(Model model, @ModelAttribute ProField proField) {
       // al = new ArrayList<>();
        al = new ArrayList<>();
        al.add(proField);
        model.addAttribute("1", new Greeting());
//        model.addAttribute("3", new ProField());
        System.out.println("pr str1 = " + proField.getStr1());
        return "1";
    }

    @RequestMapping(value="/1", method=RequestMethod.POST)
    public String greetingSubmit(Model model, HttpServletRequest hsr, @ModelAttribute ProField proField, Greeting greeting) {

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
//        while (hsr.getParameter("p_new_" + i))
        String s = hsr.getParameter("p_new_2");
        String s1 = hsr.getParameter("p_new_3");
        String n = hsr.getParameter("l_2");
        String n1 = hsr.getParameter("l_3");
        String s2 = hsr.getParameter("p_new_4");
        String n2 = hsr.getParameter("l_4");

//        proField.setStr1("asdasd");
//        proField.setStr2("cvxcvxcv");
//        al.add(pf);
//        al.add(proField);
//        al.add(proField);

        saverClass.setS(proField);
        System.out.println(proField.getStr1());
        System.out.println(proField.getStr2());
        System.out.println("s is " + s);
        System.out.println("n is " + s1);
        System.out.println("s2 is " + n);
        System.out.println("n2 is " + n1);
        System.out.println("s3 is " + s2);
        System.out.println("n3 is " + n2);
//        System.out.println("LAST => " + d.toString());
//        System.out.println("SIZE isss - " + d.size());
//        al.add(proField);
        model.addAttribute("1", greeting);
        model.addAttribute("al1", al);
//        model.addAttribute("al2", sc);

        return "2";
    }
    @RequestMapping(value="/3", method=RequestMethod.GET)
    public String greetingSubmit2(Model model, @ModelAttribute ProField proField, HttpServletRequest request) {
//        String s = request.getParameter("s1");
//        String s2 = request.getParameter("s2");
//        pField.setStr1(s);
//        pField.setStr2(s2);
//        pf = pField;
//        sc.setS(pField);

        saverClass.setS(proField);
        al.add(proField);
        model.addAttribute("sc", al);
        System.out.println(proField.getStr1());
        System.out.println(proField.getStr2());
//        sc.setS(new ProField());
//        System.out.println(sc.getS().get(0).getStr1());
//        System.out.println(sc.getS().get(0).getStr2());

//        model.addAttribute("sc", );
        return "3";
    }
    @RequestMapping(value="/3", method=RequestMethod.POST)
    public String greetingSubmit3( @ModelAttribute ProField proField, Model model) {
//        String s = request.getParameter("s1");
//        String s2 = request.getParameter("s2");
//        proField.setStr1(s);
//        proField.setStr2(s2);
//        pf = proField;
//        sc.setS(proField);
//        System.out.println(sc.getS().size() + " -str1");
//
//        SaverClass sc = (SaverClass)model.asMap().get("sc");
        saverClass.setS(proField);
        System.out.println(proField.getStr1());
        System.out.println(proField.getStr2());
        al.add(proField);
//
//  model.addAttribute("",);
//        sc.setS(proField);
        model.addAttribute("1", al);
        return "1";
    }

}
