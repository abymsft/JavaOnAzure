package com.monitoring.azuremonitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;


@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);
    private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

    @GetMapping("/")
    public String main(Model model) {

        // pre-java 8
        if (logger.isDebugEnabled()) {
            logger.debug("Hello from Log4j 2 - num : {}", num);
        }

        // java 8 lambda, no need to check log level
        logger.debug("Hello from Log4j2: printing a debug message");
        logger.info("Hello from Log4j2: printing an info message");
        logger.error("Hello from Log4j2:printing an error message");
        model.addAttribute("tasks", num);

        return "index"; //view name should match the static template in resources/static folder
    }

    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
