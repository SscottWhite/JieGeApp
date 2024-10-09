package com.ncstudy.democollections;


import org.apache.tika.exception.TikaException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;
import ws.schild.jave.info.VideoSize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://mp.weixin.qq.com/s?__biz=MzI1NDY0MTkzNQ==&mid=2247508701&idx=1&sn=abaa3740c8ede32c46e933145fa4ee69&chksm=e8627b4ce6c2fbe66386d0bb50d6364e2612e77204118f4608bf0c43f819dc69519ee218e3d2&scene=90&xtrack=1&sessionid=1726627926&subscene=93&clicktime=1726627928&enterid=1726627928&flutter_pos=0&biz_enter_id=4&ranksessionid=1726625223&ascene=56&devicetype=iOS17.6.1&version=1800332c&nettype=WIFI&abtest_cookie=AAACAA%3D%3D&lang=zh_CN&countrycode=CN&fontScale=100&exportkey=n_ChQIAhIQGFJFzcQ5w%2BRC1gf0L45WshLZAQIE97dBBAEAAAAAAAyUBlkDZKQAAAAOpnltbLcz9gKNyK89dVj0CquMDo0ABbMe7ZVd09IRor508KGl3scB25M41J3RvoRefFdhLmFg3gwjCK4MDjk1sagz5m4PwajgOptl6egynxMw71OPSQGlnruHEqvUktY37vueLByDNzTNMO5WPXuu0UHR8AFKrqfdgWudSqLSkUAqJ9%2Bt6jjM%2BHOtdMeTdz%2FhGH71OSEDGe2uS7srrM0dO48Aby6At6RsRvuu7FFu%2BdfZNU3dMdQlNeGA3XqTPzvS0No%3D&pass_ticket=mHxHNa5nLARMnXfCEH0SwQqrnWFjwO4tRuFBeifvHakNVQAW%2Bfw%2FIciQLR8xIh5l&wx_header=3
@RestController
@RequestMapping
public class Schild {

    static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm:ss");

    @GetMapping("/schild1")
    @ResponseBody
    public void test1() throws TikaException, IOException, EncoderException {
        File source = new File("D:\\AI智能体\\mp4\\01.大模型有什么缺陷.mp4");
        File target = new File("D:\\AI智能体\\mp4\\01.大模型有什么缺陷.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(128000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setOutputFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(new MultimediaObject(source), target, attrs);
    }



    @GetMapping("/schild2")
    @ResponseBody
    public void test2() throws TikaException, IOException, EncoderException {
        File source = new File("D:\\AI智能体\\mp4\\01.大模型有什么缺陷.mp4");
        File target = new File("D:\\AI智能体\\mp4\\01.大模型有什么缺陷.flv");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);
        audio.setChannels(1);
        audio.setSamplingRate(22050);
        VideoAttributes video = new VideoAttributes();
        video.setCodec("flv");
        video.setBitRate(160000);
        video.setFrameRate(15);
        video.setSize(new VideoSize(400, 300));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setOutputFormat("flv");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        encoder.encode(new MultimediaObject(source), target, attrs);
    }


    @GetMapping("/schild3")
    @ResponseBody
    public void test3() throws TikaException, IOException, EncoderException {

        System.out.println("输入视频目录：");
        String dir = new Scanner(System.in).next();
        File folder = new File(dir);
        List<String> files = sort(folder);
        outputVideoTime(files);
    }

    private static void outputVideoTime(List<String> files) throws EncoderException {
        for (String file : files) {
            File video = new File(file);
            if (video.isFile() && !video.getName().startsWith(".") && video.getName().endsWith(".mp4")) {
                MultimediaObject multimediaObject = new MultimediaObject(video);
                long duration = multimediaObject.getInfo().getDuration();
                String s = "%s    %s";
                System.out.println(String.format(s, video.getName(), DATE_FORMAT.format(duration)));
            } else if (video.isDirectory()) {
                System.out.println(video.getName());
                outputVideoTime(sort(video));
            }
        }
    }
    public static List<String> sort(File folder) {
        return Arrays.stream(folder.listFiles()).map(f -> f.getAbsolutePath()).sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
    }
}
