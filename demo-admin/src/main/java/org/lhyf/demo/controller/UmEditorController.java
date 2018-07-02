package org.lhyf.demo.controller;

import org.lhyf.demo.utils.Uploader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * @author YF
 * @date 2018-07-02 18:02
 * @desc UmEditorController
 *
 **/

@Controller
@RequestMapping("/umeditor")
public class UmEditorController {

    @RequestMapping("imageUp")
    public String imageUp(MultipartFile upfile, HttpServletRequest request, HttpServletResponse response, org.springframework.ui.Model modelMap) {

        Uploader up = new Uploader(request);
        up.setSavePath("upload");
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        try {
            up.upload();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String callback = request.getParameter("callback");

        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";

        result = result.replaceAll( "\\\\", "\\\\" );

        if(callback == null ){
            return result ;
        }else{
            return "<script>"+ callback +"(" + result + ")</script>";
        }
    }
}
