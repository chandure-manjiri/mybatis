package mybatis.com.mybatis.ManagementController;

import mybatis.com.mybatis.ManagementDto.MessOwnerCreationDto;
import mybatis.com.mybatis.ManagementDto.MessOwnerDto;
import mybatis.com.mybatis.ManagementDto.MessOwnersDto;
import mybatis.com.mybatis.ManagementService.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mess_owner")
public class MessOwnerController {
    @Autowired
    MessOwnerService messOwnerService;
    @GetMapping("")
    public ResponseEntity<List<MessOwnerDto>> getMessOwners(){
        List<MessOwnerDto> messOwners = this.messOwnerService.getMessOwners();
        return ResponseEntity.ok(messOwners);
    }

    @PostMapping("")
    public ResponseEntity<MessOwnerDto> createMessOwner(@RequestBody MessOwnerCreationDto messOwnerCreationDto){
        MessOwnerDto messOwnerDto = this.messOwnerService.createMessOwner(messOwnerCreationDto);
        return new ResponseEntity<>(messOwnerDto, HttpStatus.CREATED);
    }
}
