package org.lhyf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lhyf.demo.message.vo.PictureVO;
import org.lhyf.demo.model.Bo.RestResponseBo;
import org.lhyf.demo.pojo.TPicture;
import org.lhyf.demo.service.PictureService;
import org.lhyf.demo.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/****
 * @author YF
 * @date 2018-06-29 21:17
 * @desc PictureController
 *
 **/
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Value("${picture.save-path}")
    private String PICTURE_SAVE_PATH  ;

    @Autowired
    private PictureService pictureService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        PageHelper.startPage(page, 10);
        List<TPicture> list = pictureService.getAllPicture();
        PageInfo<TPicture> pi = new PageInfo<>(list);

        model.addAttribute("piclist",pi);
        return "admin/picture";
    }

    @ResponseBody
    @PostMapping("/save")
    public RestResponseBo save(PictureVO pictureVO) throws IOException {
        String path =  PICTURE_SAVE_PATH ;

        String url = savePic(path,pictureVO.getPicture());



//        pictureService.savePicture(pictureVO);

        return RestResponseBo.ok();
    }


    /**
     * 转储图片
     * @param savePath
     * @param picture
     */
    private String savePic(String savePath ,MultipartFile picture){
        String originalFilename = picture.getOriginalFilename();

        // .jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String picName = RandomUtils.getGUID() + suffix;
        File path = new File(savePath,picName);

        //判断路径是否存在，如果不存在就创建一个
        if (!path.getParentFile().exists()) {
            path.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return savePath + picName;
    }

}
