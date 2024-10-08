package com.ncstudy.control;

import com.ncstudy.config.jwtconfig.JWTConfig;
import com.ncstudy.service.ExcelService;
import com.ncstudy.service.TuserService;
import com.ncstudy.toolutils.ExcelSheetUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.*;

import com.ncstudy.pojo.Tuser;

@Slf4j
@RestController
@RequestMapping("excel")
public class ExcelTestController {
	
	@Autowired
	private JWTConfig jWTConfig;

	private final JWTConfig jwtConfig;
	private final ExcelService excelService;

	@Autowired
	private TuserService tuserService;

	@GetMapping("save")
	public void saveTuser(){
		long startTime = System.currentTimeMillis();
		for (int i=0;i<=1;i++) {
			tuserService.saveTuser(new Tuser(i, "jake"+i, (int)(Math.random() * 100)));
		}
		System.out.println(System.currentTimeMillis()-startTime);
	}

	@GetMapping("saveList/{nums1}/{nums2}")
	public void saveList(@PathVariable("nums1") Integer nums1, @PathVariable("nums2") Integer nums2){
		ExecutorService es = new ThreadPoolExecutor(10, 20,
				0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		long startTime = System.currentTimeMillis();
		List<Tuser> list = new ArrayList<>();
		List<List<Tuser>> lists = new ArrayList<>();

		for (int i=1;i<=nums1;i++) {
			list.add(new Tuser(i, "jake"+i, (int)(Math.random() * 100)));
			if(i % nums2 == 0){
				lists.add(list);
				list = new ArrayList<>();
			}
		}

		for (int i = 0; i < lists.size(); i++) {
			List<Tuser>  newList = lists.get(i);
			es.execute(() -> {
				tuserService.saveList(newList);
			});
		}

		es.shutdown();
		System.out.println(System.currentTimeMillis()-startTime);
	}

	@Autowired
	public ExcelTestController(JWTConfig jwtConfig, ExcelService excelService){
		this.jwtConfig = jwtConfig;
		this.excelService = excelService;
	}


	@PostMapping("getInfo")
	public void getExcelContent(@RequestParam("file") MultipartFile file) {
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
	}

	@PostMapping("import")
	public void importExcel(@RequestParam("file") MultipartFile file) {
//		List<List<String>> list = ExcelUtil.parse(file);
//		for (int i = 0; i < list.size(); i++) {
//			List<String> list1 = list.get(i);
//			excelService.excelImport(list1);
//		}
		try {
			InputStream inputStream = file.getInputStream();
			List<String> list = new ArrayList<>();
			List<List<String>> listAll = new ArrayList<>();
			XSSFWorkbook book = null;
			XSSFSheet sheet = null;

			Long begin = new Date().getTime();
			book = new XSSFWorkbook(inputStream);
			sheet = book.getSheetAt(0); //取第一个表格
			System.out.println("sheet.getLastRowNum():"+sheet.getLastRowNum());

			int split = 500;
			for(int i=0; i < (sheet.getLastRowNum()/split)+1; i++){
				list = new ArrayList<>();
				int max = i*split;
				for(int j=max;j<(i+1)*split;j++){
					XSSFRow row = sheet.getRow(j);
					list.add(ExcelSheetUtil.getCellValue(row.getCell(0)));
				}
				listAll.add(list);
			}
			System.out.println("时间差:"+ (new Date().getTime()-begin));
			System.out.println(listAll.size());
//			for (int i = 0; i < listAll.size(); i++) {
//				for(int j=0;j<listAll.get(i).size();j++){
//					System.out.println(listAll.get(i).get(j));
//				}
//			}
			book.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
			throw new RuntimeException(e);
		}

	}
	
	@PostMapping("getConfig")
	public void getConfig(HttpServletRequest request, HttpSession session) {
		
		log.info(request.getHeader(jWTConfig.getTokenHeader()));
	}
	
	@PostMapping("getHeader")
	public void getHeader(HttpServletRequest request, HttpSession session) {
	    //获取客户端向服务器端传送数据的协议名称
	    System.out.println("rotocol: " + request.getProtocol());
	    //返回的协议名称.默认是http
	    System.out.println("Scheme: " + request.getScheme());
	    //可以返回当前页面所在的服务器的名字;如果你的应用部署在本机那么其就返回localhost或者127.0.0.1 ，这两个是等价的
	    System.out.println("ServerName: " + request.getServerName());
	    //可以返回当前页面所在的服务器使用的端口,就是8083
	    System.out.println("ServerPort: " + request.getServerPort());
	    //request.getRemoteAddr()是获得客户端的ip地址
	    System.out.println("RemoteAddr: " + request.getRemoteAddr());
	    //request.getRemoteHost()是获得客户端的主机名。
	    System.out.println("RemoteHost: " + request.getRemoteHost());
	    //返回字符编码
	    System.out.println("CharacterEncoding: " + request.getCharacterEncoding());
	    //描述HTTP消息实体的传输长度
	    System.out.println("ContentLength: " + request.getContentLength());
	    //定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件，
	    System.out.println("ContentType: " + request.getContentType());
	    //如果servlet由一个鉴定方案所保护，如HTTP基本鉴定，则返回方案名称
	    System.out.println("AuthType: " + request.getAuthType());
	    //返回HTTP请求方法（例如GET、POST等等）
	    System.out.println("HttpMethod: " + request.getMethod());
	    //返回在URL中指定的任意附加路径信息。
	    System.out.println("pathInfo: " + request.getPathInfo());
	    //返回在URL中指定的任意附加路径信息，被子转换成一个实际路径
	    System.out.println("pathTrans: " + request.getPathTranslated());
	    //返回查询字符串，即URL中?后面的部份。
	    System.out.println("QueryString: " + request.getQueryString());
	    //如果用户通过鉴定，返回远程用户名，否则为null。
	    System.out.println("RemoteUser: " + request.getRemoteUser());
	    //返回客户端的会话ID
	    System.out.println("SessionId: " + request.getRequestedSessionId());
	    //返回URL中一部分，从“/”开始，包括上下文，但不包括任意查询字符串。
	    System.out.println("RequestURI: " + request.getRequestURI());
	    //返回请求URI上下文后的子串
	    System.out.println("ServletPath: " + request.getServletPath());
	    //返回指定的HTTP头标指。如果其由请求给出，则名字应为大小写不敏感。
	    System.out.println("Accept: " + request.getHeader("Accept"));
	    //获取请求的头部信息
	    System.out.println("Host: " + request.getHeader("Host"));
	    //获取来源页地址
	    System.out.println("Referer : " + request.getHeader("Referer"));
	    //获取请求方地址
	    System.out.println("Origin : " + request.getHeader("Origin"));
	    //获取请求方语言
	    System.out.println("Accept-Language : " + request.getHeader("Accept-Language"));
	    //浏览器支持的编码类型
	    System.out.println("Accept-Encoding : " + request.getHeader("Accept-Encoding"));
	    //浏览器标识
	    System.out.println("User-Agent : " + request.getHeader("User-Agent"));
	    //在浏览器中不设置Connection，会默认是keep-alive（长连接）
	    System.out.println("Connection : " + request.getHeader("Connection"));
	    //获取请求方Cookie
	    System.out.println("Cookie : " + request.getHeader("Cookie"));
	    //获取请求方时间
	    System.out.println("Created : " + session.getCreationTime());
	    System.out.println("LastAccessed : " + session.getLastAccessedTime());
	 
	 
	    System.out.println("------获取单个请求头name对应的value值--------");
	    String headValue = request.getHeader("Accept-Encoding");
	    System.out.println(headValue);
	 
	    System.out.println("------获取多个同名请求头对应的一组value值，因此返回枚举类型数据--------");
	    /**
	     * 获取多个同名请求头对应的一组value值，因此返回枚举类型数据
	     */
	    Enumeration enumeration = request.getHeaders("Accept-Encoding");
	    /**
	     * 将数据遍历出来
	     */
	    while (enumeration.hasMoreElements()) {
	        //遍历枚举中存储的每一个元素
	        String value = (String) enumeration.nextElement();
	        //将值输出
	        System.out.println(value);
	    }
	 
	    System.out.println("-----获取请求头的所有name值,返回的数据也是一个枚举类型的数据，将枚举中的元素依次遍历出来，根据name获取对应的value值，即可得到Http请求头的所有信息-----------");
	 
	    Enumeration er = request.getHeaderNames();
	    while (er.hasMoreElements()) {
	        String name = (String) er.nextElement();
	        String value = request.getHeader(name);
	        System.out.println(name + "=" + value);
	    }	
	}
}
