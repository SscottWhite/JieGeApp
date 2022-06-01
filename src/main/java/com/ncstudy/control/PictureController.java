package com.ncstudy.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ncstudy.toolutils.StringUtil;
import com.ncstudy.toolutils.ResultCode;
import com.ncstudy.toolutils.ResultDO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("/upload")
public class PictureController {
	
	@ApiOperation(value = "OssWms文件上传", httpMethod = "POST", notes = "测试教程")
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResultDO<String> OssWmsUpload(HttpServletRequest request,
	          @ApiParam(name = "file", value = "文件对象", required = true) MultipartFile file,
	          @ApiParam(name = "versionNo",value = "版本号", required = true) String versionNo)
	{
		ResultDO<String> result = null;
	      String err=null;
	      try {
	         if(versionNo == null){
	            return new ResultDO<>(ResultCode.COMMON_FAIL,"请注明版本号",false);
	         }
	         byte[] byteArray = file.getBytes();
	         String remoteFile = request.getParameter("key");
	         String filename = file.getOriginalFilename();
//	         if(!FileUtil.checkFileType(byteArray, filename)) {
//	            return new ResultDO<>(ResultCode.COMMON_FAIL,"文件格式不被允许上传", false);
//	         }
//	         long fileSize = file.getSize();
//	         if(!FileUtil.checkFileSize(fileSize)) {
//	            return new ResultDO<>(ResultCode.COMMON_FAIL,"文件大小超出范围", false);
//	         }
//	         if(FileUtil.checkPhotoType(byteArray) && !FileUtil.checkImageSize(fileSize)) {
//	            return new ResultDO<>(ResultCode.COMMON_FAIL,"图片大小超出范围", false);
//	         }
	         //filename =  "bsdyun_ecom_wms_"+version+".apk";
	         //String newFileName = String.format("%s.%s", StringUtil.getUniqueCode(),FileUtil.getFileSuffix(filename));
	        // String newFileName = String.format("%s.%s", "bsdyun_ecom_wms_"+versionNo,FileUtil.getFileSuffix(filename));
	         //String newFileName = "bsdyun_ecom_wms_"+version+"."+FileUtil.getFileSuffix(filename);
	         //remoteFile = "wms/"+newFileName;
//	       if(StringUtils.isEmpty(remoteFile)){
//	          remoteFile = "oms/"+file.getOriginalFilename();
//	       }
	      //   result = fileService.uploadByMf(null,remoteFile,byteArray,"public-read");         
	      } catch (Exception e) {
	         err = StringUtil.getExecptionMessage(e);
	      } finally {
	         if (result == null) {
	           // result = new ResultDO<>(ResultCode.COMMON_FAIL,StringUtils.isEmpty(err)?"未知错误":err, false);
	         }
	      }
	      return result;
	   }
}
