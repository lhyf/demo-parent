package org.lhyf.demo.service;

import org.lhyf.demo.message.vo.PictureVO;
import org.lhyf.demo.pojo.TPicture;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-29 21:19
 * @desc PictureService
 *
 **/
public interface PictureService {
    List<TPicture> getAllPicture();

    int savePicture(PictureVO picture);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PictureVO pic);
}
