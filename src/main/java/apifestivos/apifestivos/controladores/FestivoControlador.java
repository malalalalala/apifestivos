package apifestivos.apifestivos.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import apifestivos.apifestivos.interfaces.IFestivoServicio;
import apifestivos.apifestivos.vistas.Vista;
import apifestivos.apifestivos.entidades.Festivo;

@RestController
@RequestMapping("/festivos")
public class FestivoControlador {

    @Autowired
    private IFestivoServicio festivoServicio;

    @JsonView(Vista.SimplifiedView.class)
    @GetMapping("listar/{año}")
    public List<Festivo> listar(@PathVariable Integer año) {
        System.out.println(año);
        System.out.println("controller" + festivoServicio.obtenerFestivos(año));
        return festivoServicio.obtenerFestivos(año);
    }

    @GetMapping("verificar/{year}/{month}/{day}")
    public String validarFestivo(
            @PathVariable Integer year,
            @PathVariable Integer month,
            @PathVariable Integer day) throws ParseException {

        try {
            String fecha = String.format("%04d/%02d/%02d", year, month, day);

            System.out.println(fecha);

            if (festivoServicio.esFechaCorrecta(fecha)) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                Date fechaVer = formatoFecha.parse(fecha);
                return festivoServicio.esFestivo(fechaVer) ? "Es festivo." : "No es festivo.";
            }

            return "Fecha no válida.";
        } catch (ParseException e) {
            return "Error al procesar la fecha.";
        }

    }
}
