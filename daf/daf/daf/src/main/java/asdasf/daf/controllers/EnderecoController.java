package asdasf.daf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import asdasf.daf.dao.EnderecoDao;
import asdasf.daf.entities.Endereco;

@Controller
public class EnderecoController {

	@Autowired()
	private EnderecoDao enderecorepositorio;

	@GetMapping("/inserirEndereco")
	public ModelAndView InsertEndereco(Endereco IdEndereco) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Inserir/FormEndereco");
		mv.addObject("endereco", new Endereco());
		return mv;

	}

	@PostMapping("InsertEndereco")
	public ModelAndView inserirEndereco(@Valid Endereco IdEndereco, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("/Inserir/FormEndereco");
			mv.addObject("endereco");
		} else {
		mv.setViewName("redirect:/ListarEndereco");
		enderecorepositorio.save(IdEndereco);}
		return mv;
	}

	@GetMapping("/ListarEndereco")
	public ModelAndView ListEndereco() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Listar/ListEndereco");
		mv.addObject("enderecosList", enderecorepositorio.findAll());
		return mv;
	}

	@GetMapping("/alterarEndereco/{id}")
	public ModelAndView alterarEndereco(@PathVariable Integer id) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alterar/alterarEndereco");
		Endereco endereco = enderecorepositorio.getReferenceById(id);
		mv.addObject("endereco", endereco);
		return mv;
	}

	@PostMapping("/alterarEndereco")
	public ModelAndView alterarEndereco(@Valid Endereco IdEndereco, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("Alterar/alterarEndereco");
			mv.addObject("endereco");
		} else {
		mv.setViewName("redirect:/ListarEndereco");
		enderecorepositorio.save(IdEndereco);}
		return mv;
	}

	@GetMapping("/excluirEndereco/{id}")
	public String excluirEndereco(@PathVariable Integer id) {
		enderecorepositorio.deleteById(id);
		return "redirect:/ListarEndereco";
	}
}
