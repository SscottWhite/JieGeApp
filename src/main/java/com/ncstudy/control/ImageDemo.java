package com.ncstudy.control;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ncstudy.toolutils.DBUtil;
import com.ncstudy.toolutils.ImageUtil;


/*
 *
 *
CREATE TABLE `photo` ( 
	`id` INT(11) NOT NULL, 
	`name` VARCHAR(255) DEFAULT NULL, 
	`photo` LONGBLOB, 
	PRIMARY KEY (`id`) 
) ENGINE=INNODB DEFAULT CHARSET=utf8;
 */
public class ImageDemo
{
    // 将图片插入数据库
    public static void readImage2DB()
    {
        String path = "D:\\Users\\kjs_352\\Desktop\\pic4.png";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try
        {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into photo (id,name,photo)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "Tom");
            ps.setBinaryStream(3, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0)
            {
                System.out.println("插入成功！");
            }
            else
            {
                System.out.println("插入失败！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConn(conn);
            if (null != ps)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
 
    }
 
    // 读取数据库中图片
    public static void readDB2Image()
    {
        String targetPath = "D:/demo.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = DBUtil.getConn();
            String sql = "select * from photo where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next())
            {
                InputStream in = rs.getBinaryStream("photo");
                ImageUtil.readBin2Image(in, targetPath);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConn(conn);
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (ps != null)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
 
        }
    }
 
    //测试
    public static void main(String[] args)
    {
        /*
        备注：先执行readImage2DB();
              后执行readDB2Image();
         */
        //readImage2DB();   //图片插入数据库方法
        //readDB2Image();     //读取数据库图片到指定位置
//        test1();
        test2();
    }

    public static void test1(){
        System.out.println(Integer.SIZE - 3);
        System.out.println(3 >> 2);
        Thread thread = new Thread(() -> {
            System.out.println("123");
        });
        thread.setDaemon(true);
        System.out.println(thread.isDaemon());
        thread.start();
    }

    public static void test2() {
        ExecutorService es = new ThreadPoolExecutor(2, 4,
                0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i <= 10; i++) {
            es.submit(() -> {
                try {
                    Thread.sleep(0);
                    System.out.println("222---" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("kandao " + i);
        }
        es.shutdown();
    }
}
