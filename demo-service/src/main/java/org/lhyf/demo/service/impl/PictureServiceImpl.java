package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TPictureMapper;
import org.lhyf.demo.pojo.TPicture;
import org.lhyf.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int savePicture() {
        return 0;
    }
}
