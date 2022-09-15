package cn.netkiller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.netkiller.LogMarker;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/")
	public String index() {

		Marker finance = MarkerFactory.getMarker(LogMarker.finance.toString());
		Marker customer = MarkerFactory.getMarker(LogMarker.customer.toString());
		Marker market = MarkerFactory.getMarker(LogMarker.market.toString());
		logger.info("AAAAAAAAA");
		logger.info(finance, "BBBBBBBBB");
		// logger.error(finance, "This is a serious an error requiring the admin's attention", new Exception("Just testing"));
		logger.info(finance, "BBBBBBBBB");
		logger.info(customer, "BBBBBBBBB");
		logger.info(market, "BBBBBBBBB");

		MDC.put("userId", "0001");
		logger.info("0001用户");
		MDC.clear();

		MDC.put("userId", "0002");
		logger.info("0002用户");
		MDC.clear();
		return "Hello world!!!";
	}

	@GetMapping("/info")
	public String info(@RequestParam("msg") String msg) {
		logger.info(msg);
		return msg;
	}
}
