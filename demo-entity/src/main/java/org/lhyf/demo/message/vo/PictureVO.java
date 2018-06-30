package org.lhyf.demo.message.vo;

import org.springframework.web.multipart.MultipartFile;

/****
 * @author YF
 * @date 2018-06-30 01:35
 * @desc PictureVO
 *
 **/
public class PictureVO {
    private String title;
    private String intro;
    private String location;
    private MultipartFile picture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }
}
