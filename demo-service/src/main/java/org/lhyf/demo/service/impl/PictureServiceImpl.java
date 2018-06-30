package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TPictureMapper;
import org.lhyf.demo.message.vo.PictureVO;
import org.lhyf.demo.pojo.TPicture;
import org.lhyf.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/****
 * @author YF
 * @date 2018-06-29 21:19
 * @desc PictureServiceImpl
 *
 **/

@Service(value = "pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    private TPictureMapper pictureMapper;

    @Override
    public List<TPicture> getAllPicture() {

        List<TPicture> list = pictureMapper.findAll();

        return list;
    }

    @Override
    public int savePicture(PictureVO picture) {
        TPicture p = new TPicture();
        p.setAddTime(new Date());
        p.setTitle(picture.getTitle());
        p.setIntro(picture.getIntro());
        p.setLocation(picture.getLocation());
        p.setUrl(picture.getUri());

        return pictureMapper.insertSelective(p);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
           return pictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PictureVO pic){
        TPicture p = new TPicture();
        p.setId(pic.getId());
        p.setTitle(pic.getTitle());
        p.setIntro(pic.getIntro());
        p.setLocation(pic.getLocation());
        p.setUrl(pic.getUri());
        p.setUpdateTime(new Date());
        return pictureMapper.updateByPrimaryKeySelective(p);
    }
}
