package mybatis.com.mybatis.ManagementController;

import io.swagger.v3.oas.models.security.SecurityScheme;
import mybatis.com.mybatis.ManagementDto.MessCreationDto;
import mybatis.com.mybatis.ManagementDto.MessDto;
import mybatis.com.mybatis.ManagementDto.MessOwnersDto;
import mybatis.com.mybatis.ManagementService.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MessController {

    @Autowired
    MessService messService;
    @GetMapping("/mess")
    public ResponseEntity<List<MessDto>> getmess(){
        List<MessDto> mess = this.messService.getAllMess();
        return ResponseEntity.ok(mess);
    }

    @PostMapping("/mess")
    public ResponseEntity<MessDto> createMess(@RequestBody MessCreationDto messCreationDto){
        MessDto messDto = this.messService.createMess(messCreationDto);
        return new ResponseEntity<>(messDto, HttpStatus.CREATED);
    }

    @GetMapping("/mess/{mess_id}/owners")
    public ResponseEntity<MessOwnersDto> getAllOwners(@PathVariable ("mess_id") Integer mess_id){
        MessOwnersDto messOwnersDto = this.messService.getAllOwners(mess_id);
        return ResponseEntity.ok(messOwnersDto);
    }
}
