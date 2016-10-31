package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value="/1", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("1", new Greeting());
        model.addAttribute("3", new ProField());
        return "1";
    }

    @RequestMapping(value="/1", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ProField proField, Greeting greeting, Model model) {

       // pField.setStr1("fsdfsdfsdfsd");
        model.addAttribute("1", greeting);
        model.addAttribute("3", proField);

        return "2";
    }
    @RequestMapping(value="/3", method=RequestMethod.POST)
    public void greetingSubmit2(@ModelAttribute ProField proField, Model model) {


        model.addAttribute("3", proField);

        //return "3";
    }

}
