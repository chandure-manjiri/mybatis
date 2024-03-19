package mybatis.com.mybatis.ManagementController;

import mybatis.com.mybatis.ManagementDto.HostelCreationDto;
import mybatis.com.mybatis.ManagementDto.HostelDto;
import mybatis.com.mybatis.ManagementService.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HostelController{

    @Autowired
    HostelService hostelService;
    @GetMapping("/hostels")
    public ResponseEntity<List<HostelDto>> gethostels(){
        List<HostelDto> hostels = this.hostelService.getAllHostels();
        return ResponseEntity.ok(hostels);
    }

    @PostMapping("/hostels")
    public ResponseEntity<HostelDto> createHostel(@RequestBody HostelCreationDto hostelCreationDto){
        HostelDto hostelDto = this.hostelService.createHostel(hostelCreationDto);
        return new ResponseEntity<>(hostelDto, HttpStatus.CREATED);
    }
}
