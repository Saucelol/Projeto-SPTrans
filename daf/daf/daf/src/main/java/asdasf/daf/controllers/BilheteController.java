package asdasf.daf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import asdasf.daf.dao.BilheteDao;
import asdasf.daf.entities.Bilhete;

@Controller
public class BilheteController {

	@Autowired()
	private BilheteDao bilheterepositorio;
//	private UsuarioDao usuariorepositorio;

	@GetMapping("/inserirBilhete")
	public ModelAndView InsertBilhete(Bilhete IdBilhete) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Inserir/FormBilhete");
		mv.addObject("bilhete", new Bilhete());
		return mv;
	}

	@PostMapping("InsertBilhete")
	public ModelAndView inserirBilhete(@Valid Bilhete IdBilhete, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("/Inserir/FormBilhete");
			mv.addObject("bilhete");
		} else {
			mv.setViewName("redirect:/ListarBilhete");
			bilheterepositorio.save(IdBilhete);
		}
		return mv;
	}

	@GetMapping("/ListarBilhete")
	public ModelAndView ListBilhete() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Listar/ListBilhete");
		mv.addObject("bilhetesList", bilheterepositorio.findAll());
//		mv.addObject("usuariosList", usuariorepositorio.findAll());
		return mv;
	}

	@GetMapping("/alterarBilhete/{id}")
	public ModelAndView alterarBilhete(@PathVariable Integer id) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alterar/alterarBilhete");
		Bilhete bilhete = bilheterepositorio.getReferenceById(id);
		mv.addObject("bilhete", bilhete);
		return mv;
	}

	@PostMapping("/alterarBilhete")
	public ModelAndView alterarBilhete(@Valid Bilhete IdBilhete, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("Alterar/alterarBilhete");
			mv.addObject("bilhete");
		} else {
			mv.setViewName("redirect:/ListarBilhete");
			bilheterepositorio.save(IdBilhete);
		}
		return mv;
	}

	@GetMapping("/excluirBilhete/{id}")
	public String excluirBilhete(@PathVariable Integer id) {
		bilheterepositorio.deleteById(id);
		return "redirect:/ListarBilhete";
	}

}