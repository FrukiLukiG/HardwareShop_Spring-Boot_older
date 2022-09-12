package hr.tvz.plese.hardwareapp.hardware_controller;

import hr.tvz.plese.hardwareapp.hardware_classes.HardwareDTO;
import hr.tvz.plese.hardwareapp.hardware_service.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService){
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code){
        return hardwareService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity
                        .notFound()
                        .build()
                );
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand hardwareCommand){
        return hardwareService.save(hardwareCommand)
                .map(hardwareDTO -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(hardwareDTO)
                )
                .orElseGet( () -> ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build()
                );
    }

    @PutMapping("/{code}")
    public ResponseEntity<HardwareDTO> update(@Valid @RequestBody final HardwareCommand hardwareCommand, @PathVariable String code){
        return hardwareService.update(hardwareCommand, code)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity
                        .notFound()
                        .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable final String code){
        hardwareService.deleteByCode(code);
    }

}
