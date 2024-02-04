package com.ncstudy.service;

import java.util.List;

public interface RedPacketService {

    public void sendRedPacket(String redPacketId, double totalAmount, int totalPeople);
    public String grabRedPacket(String redPacketId);
    public String grabRedPacket(String redPacketId, String userId);
    public String grabRedPacket2(String redPacketId, String userId);
    public List<String> getRedPacketRecords(String redPacketId);
}
