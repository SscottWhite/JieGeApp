package com.ncstudy.control;

import com.ncstudy.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redpacket")
public class RedPacketController {
    @Autowired
    private RedPacketService redPacketService;

    @PostMapping("/send")
    public void sendRedPacket(@RequestParam String redPacketId, @RequestParam double totalAmount, @RequestParam int totalPeople) {
        redPacketService.sendRedPacket(redPacketId, totalAmount, totalPeople);
    }

    @PostMapping("/grab")
    public String grabRedPacket(@RequestParam String redPacketId) {
        return redPacketService.grabRedPacket(redPacketId);
    }

    @PostMapping("/grab2")
    public String grabRedPacket2(@RequestParam String redPacketId,@RequestParam String userId) {
        return redPacketService.grabRedPacket(redPacketId,userId);
    }



    @GetMapping("/records")
    public List<String> getRedPacketRecords(@RequestParam String redPacketId) {
        return redPacketService.getRedPacketRecords(redPacketId);
    }
}
