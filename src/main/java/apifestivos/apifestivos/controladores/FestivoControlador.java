package apifestivos.apifestivos.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<List<Festivo>> listar(@PathVariable String año) {
        try {
            // Intenta convertir la cadena de año a un Integer
            Integer year = Integer.parseInt(año);

            // Verifica si el año es válido
            if (esAnioValido(year)) {
                List<Festivo> festivos = festivoServicio.obtenerFestivos(year);
                return ResponseEntity.ok(festivos);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (NumberFormatException e) {
            // Captura la excepción si la conversión falla
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("verificar/{year}/{month}/{day}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String verificarFestivo(
            @PathVariable Integer year,
            @PathVariable String month,
            @PathVariable String day) {

        try {
            int parsedMonth = Integer.parseInt(month);
            int parsedDay = Integer.parseInt(day);

            if (esFechaValida(year, parsedMonth, parsedDay)) {
                String fecha = String.format("%04d/%02d/%02d", year, parsedMonth, parsedDay);

                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                Date fechaVer = formatoFecha.parse(fecha);

                return festivoServicio.esFestivo(fechaVer) ? "Es festivo." : "No es festivo.";
            }

            return "Fecha no válida.";
        } catch (NumberFormatException | ParseException e) {
            return "Solicitud inválida. Por favor, revise el formato. Debe seguir el patrón yyyy/MM/dd.";
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

    private boolean esAnioValido(int year) {
        return year >= 0;
    }

}
