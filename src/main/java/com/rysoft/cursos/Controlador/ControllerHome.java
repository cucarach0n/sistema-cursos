package com.rysoft.cursos.Controlador;

import com.rysoft.cursos.Controlador.Util.SessionUtil;
import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.CategoriaCursos;
import com.rysoft.cursos.Entidades.ProgramasCursos;
import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Interfaces.IinscripcionesService;

import com.rysoft.cursos.Modelos.Categoria;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Inscripciones;
import com.rysoft.cursos.Modelos.Programa;
import com.rysoft.cursos.Servicios.MailService;
import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerHome {

    @Autowired
    private ICursoService cursoServicio;
    @Autowired
    private ICategoriaService categoriaServicio;
    @Autowired
    private IinscripcionesService InscripcionesServicio;
    @Autowired
    private IProgramaService programaServicio;
    @Autowired
    private MailService mailService;

    //private ICursoService service1;
    @GetMapping("/")
    public String Home(Model model, HttpSession session) {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        List<Curso> cursos = cursoServicio.listarCursosCategoria();
        List<Categoria> categorias = categoriaServicio.listarCategoriasLimite(2);
        List<CategoriaCursos> categoriasCursos = new ArrayList<CategoriaCursos>();
        List<Programa> programas = programaServicio.listarProgramas();
        List<ProgramasCursos> programasCursos = new ArrayList<ProgramasCursos>();
        programas.forEach((programa) -> {
            ProgramasCursos pc = new ProgramasCursos();
            pc.setId_programa(programa.getId_programa());
            pc.setDesc_programa(programa.getDesc_programa());
            pc.setNom_programa(programa.getNom_programa());
            pc.setPrec_programa(programa.getPrec_programa());
            pc.setDescu_programa(programa.getDescu_programa());
            pc.setFoto_programa(programa.getFoto_programa());
            pc.setVigencia_programa(programa.getVigencia_programa());
            pc.setAct_programa(programa.getAct_programa());
            pc.setCantCurso_programa(cursoServicio.filtrarCursosByPrograma(programa.getId_programa()).size());
            programasCursos.add(pc);
        });

        categorias.forEach(categoria -> {
            CategoriaCursos cc = new CategoriaCursos();
            cc.setId_categoria(categoria.getId_categoria());
            cc.setNom_categoria(categoria.getNom_categoria());
            cc.setAct_categoria(categoria.getAct_categoria());
            cc.setCursos(cursoServicio.filtrarCursosByCategoria(categoria.getId_categoria()));
            categoriasCursos.add(cc);
        });
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursos);
        model.addAttribute("categoriasCursos", categoriasCursos);
        model.addAttribute("programas", programasCursos);
        model.addAttribute("servicios", carrito.getServicios());
        return "index";
    }

    @RequestMapping(value = "/guardarIns", method = RequestMethod.POST)
    public String guardarIns(@RequestParam("nombres") String nombres,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("celular") String celular,
            @RequestParam("email") String email,
            @RequestParam("curso") String curso,
            Model model, HttpSession session) throws MessagingException, MalformedURLException {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        List<Curso> cursosList = cursoServicio.listarCursosCategoria();
        if (chkNamVldFnc(nombres) && chkNamVldFnc(apellidos) && chkMailVldFnc(email) && chkPhonVldFnc(celular)) {//Error al validar email, ver en la funcion validacion, Resposable: Dilam Chuquilin
            Inscripciones p = new Inscripciones(nombres,
                    apellidos,
                    celular,
                    email,
                    ControllerCurso.buscarCurs(cursosList, curso));
            InscripcionesServicio.Guardar(p);
            mailService.sendEmail(p.email, "Inscripcion registrada", p.toString());
        } else {
            System.out.println("Error en la validacion");
        }
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursosList);
        model.addAttribute("servicios", carrito.getServicios());
        return "index";

    }

    @GetMapping("/terminos")
    public String Terminos() {
        return "termns";
    }

    private Curso buscarCurs(List<Curso> cursos, String buscado) {
        Curso c = new Curso();
        for (int i = 0; i < cursos.size(); i++) {
            if (buscado.equals(cursos.get(i).getNom_curso())) {
                c = cursos.get(i);
                break;
            }
        }
        return c;
    }

    public static boolean chkNamVldFnc(String namVar) {
        String namRegExpVar = "^[A-Z][a-z]{2,}(?: [A-Z][a-z]*)*$";
        Pattern pVar = Pattern.compile(namRegExpVar);
        Matcher mVar = pVar.matcher(namVar);
        return mVar.matches();
    }

    public static boolean chkMailVldFnc(String mailVar) {
        String namRegExpVar = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pVar = Pattern.compile(namRegExpVar);
        Matcher mVar = pVar.matcher(mailVar);
        return mVar.matches();
    }

    public static boolean chkPhonVldFnc(String phonVar) {
        String namRegExpVar = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        Pattern pVar = Pattern.compile(namRegExpVar);
        Matcher mVar = pVar.matcher(phonVar);
        return mVar.matches();
    }

}
