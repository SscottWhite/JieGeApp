package com.ncstudy.control;

import com.ncstudy.task.FileInsertCallable;
import com.ncstudy.vo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping
public class FileInsertController {

    @GetMapping("fileinsert")
    public void fileInsert() throws ExecutionException, InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(
                2,4,60, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        List<Future<String>> fList = new ArrayList<>();
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < 20000; i++) {
            list.add(new Person(""+i,"jack"+i, i));
        }


        int size = list.size();
        int sunSum = 2 * 2;
        int listStart,listEnd;

        if(sunSum > size) {
            sunSum = size;
        }

        FileInsertCallable FIC;
        for(int i = 0; i < sunSum; i++){
            listStart = size / sunSum * i;
            listEnd = size / sunSum * (i+1);
            if( i == sunSum-1) listEnd = size;
            List<Person> sunList = list.subList(listStart,listEnd);
            FIC = new FileInsertCallable(i,sunList);
            Future<String> futures = es.submit(FIC);
            fList.add(futures);
        }

       // es.shutdown();
        for (Future future: fList) {
            try {
                String str ;
                if(null != future ){
                    str = future.get().toString();
                    System.out.println("##############current thread id ="+Thread.currentThread().getName()+",result="+str);
                }else{
                    System.err.println("失败");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        es.shutdown();
        if(es.isShutdown())
            log.info("完成");
    }
}
