package in.rajarshichakrabarty.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.rajarshichakrabarty.service.QrCodeGeneratorServiceImpl;

@Controller
public class QRGeneratorController {

	@RequestMapping("/generate")
	public void generateQrCode(@RequestParam String url, HttpServletResponse response, HttpServletRequest request) {
		QrCodeGeneratorServiceImpl codeGeneratorServiceImpl = new QrCodeGeneratorServiceImpl();
		byte[] imagearr = codeGeneratorServiceImpl.generateQRCode(url);
		
//		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.setContentType("image/png");
		try {
			response.getOutputStream().write(imagearr);
			response.getOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(@RequestParam String url) {
		
		return new ModelAndView("welcome", "message", "Nahi chala");
	}
}
