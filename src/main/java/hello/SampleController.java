package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Controller
@EnableAutoConfiguration
public class SampleController {

    private final MeterRegistry registry;
    private final Counter someCounter;

    public SampleController(MeterRegistry registry) {
        this.registry = registry;
        this.someCounter = Counter.builder("company.some.value.total").description("A value meaning something for us").tag("country", "france").register(registry);
    }


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome at home";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/company")
    @ResponseBody
    String lyreco() {
        return "our company!";
    }

    @RequestMapping("/simulate")
    @ResponseBody
    String doSomethingForFun() {
        double someValue = getRandomDoubleBetweenRange(0, 100);
        someCounter.increment(someValue);
        return "Generated value " + someValue;
    }

    public static double getRandomDoubleBetweenRange(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
