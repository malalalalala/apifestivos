package apifestivos.apifestivos.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "*")
    @GetMapping("verificar/{year}/{month}/{day}")
    public ResponseEntity<String> verificarFestivo(
            @PathVariable Integer year,
            @PathVariable String month,
            @PathVariable String day) {

        try {
            int parsedMonth = Integer.parseInt(month);
            int parsedDay = Integer.parseInt(day);

            if (esFechaValida(year, parsedMonth, parsedDay)) {
                String fecha = String.format("%04d/%02d/%02d", year, parsedMonth, parsedDay);

                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                Date fechaParseada = formatoFecha.parse(fecha);

                System.out.println(fechaParseada);
                return festivoServicio.esFestivo(fechaParseada) ? ResponseEntity.ok("Es festivo.")
                        : ResponseEntity.ok("No es festivo.");
            }

            return ResponseEntity.badRequest().body("Fecha no válida.");
        } catch (NumberFormatException | ParseException e) {
            return ResponseEntity.badRequest()
                    .body("Solicitud inválida. Por favor, revise el formato. Debe seguir el patrón yyyy/MM/dd.");
        }
    }

    private boolean esFechaValida(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    @CrossOrigin(origins = "*")
    @JsonView(Vista.SimplifiedView.class)
    @GetMapping("listar/{año}")
    public List<Festivo> listar(@PathVariable String año) {
        Integer year = Integer.parseInt(año);
        return festivoServicio.obtenerFestivos(year);
    }

}
