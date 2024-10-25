package asdasf.daf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import asdasf.daf.dao.UsuarioDao;
import asdasf.daf.entities.Usuario;

@Controller
public class UsuarioController {

	@Autowired()
	private UsuarioDao usuariorepositorio;

	@GetMapping("/inserirUsuario")
	public ModelAndView InsertUsuario(Usuario IdUsuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Inserir/FormUsuario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("InsertUsuario")
	public ModelAndView inserirUsuario(@Valid Usuario IdUsuario, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("/Inserir/FormUsuario");
			mv.addObject("usuario");
		} else {
			mv.setViewName("redirect:/ListarUsuario");
			usuariorepositorio.save(IdUsuario);
		}
		return mv;
	}

	@GetMapping("/ListarUsuario")
	public ModelAndView ListUsuario() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Listar/ListUsuario");
		mv.addObject("usuariosList", usuariorepositorio.findAll());
		return mv;
	}

	@GetMapping("/alterarUsuario/{id}")
	public ModelAndView alterarUsuario(@PathVariable Integer id) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alterar/alterarUsuario");
		Usuario usuario = usuariorepositorio.getReferenceById(id);
		mv.addObject("usuario", usuario);
		return mv;
	}

	@PostMapping("/alterar_usuario")
	public ModelAndView alterarUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		usuariorepositorio.save(usuario);
		mv.setViewName("redirect:/ListarUsuario");
		return mv;
	}

	@GetMapping("/excluirUsuario/{id}")
	public String excluirUsuario(@PathVariable Integer id) {
		usuariorepositorio.deleteById(id);
		return "redirect:/ListarUsuario";
	}

}