package com.konex.servapp.controller;

import com.konex.servapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

/**
 * Created by kneimad on 28.09.2016.
 */
@Controller
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;

    //@Autowired
    //private AccessDecisionManager accessDecisionManager;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        System.out.println("=============> REGISTRATION GET");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);

//        String defaultCharacterEncoding = System.getProperty("file.encoding");
//        System.out.println("defaultCharacterEncoding by property: " + defaultCharacterEncoding);
//        System.out.println("defaultCharacterEncoding by charSet: " + Charset.defaultCharset());
//        System.setProperty("file.encoding", "UTF-8");
//        System.out.println("defaultCharacterEncoding by property after updating file.encoding : " + System.getProperty("file.encoding"));

//        String arg = userForm.getUserPIB();
//        System.out.println("PIB: " + arg );
//        try {
//            arg = new String (arg.getBytes("UTF-8"), "ISO-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("PIB: " + arg );
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        System.out.println("=============> REGISTRATION POST");
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
            System.out.println("=============> LOGIN GET ==== ERROR");
        }

        if (logout != null) {
            model.addAttribute("message", "Вихід успішний");
            System.out.println("=============> LOGIN GET ==== LOGOUT");
        }
        System.out.println("=============> LOGIN GET");
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        System.out.println("=============> WELCOME GET");
        //System.err.println(accessDecisionManager);
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model, Map<String, Object> map) {
        map.put("user", new User());

//        map.put("userList", userService.listUsers());

        System.out.println("=============> ADMIN GET");
        //System.err.println(accessDecisionManager);
        return "admin";
    }

    @RequestMapping(value = "/delete/{user.id}", method = RequestMethod.GET)
    public String delete(@PathVariable("user.id") Long id) {

//        userService.delete(id);

        System.out.println("=============> DELETE GET");
        //System.err.println(accessDecisionManager);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public ModelAndView accessdenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
//            model.addObject("errorMsg", user.getName() + ", у вас немає доступу до цієї сторінки");
            model.addObject("errorMsg", " у вас немає доступу до цієї сторінки");
        } else {
            model.addObject("errorMsg", "У вас немає доступу до цієї сторінки");
        }
        model.setViewName("/accessdenied");
        System.out.println("=============> ACCESS DENIED GET");
        return model;
    }
}
