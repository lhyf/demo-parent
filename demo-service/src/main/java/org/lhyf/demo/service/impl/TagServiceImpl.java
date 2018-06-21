package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TTagMapper;
import org.lhyf.demo.pojo.TTag;
import org.lhyf.demo.pojo.TTagExample;
import org.lhyf.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/****
 * @author YF
 * @date 2018-06-21 10:37
 * @desc TagServiceImpl
 *
 **/

@Service(value = "tagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TTagMapper tagMapper;

    @Transactional
    @Override
    public TTag saveOrUpdate(TTag tag) {

        TTagExample example = new TTagExample();
        example.createCriteria().andNameEqualTo(tag.getName());
        List<TTag> tags = tagMapper.selectByExample(example);

        if(tags != null && tags.size() > 0){
            return tags.get(0);
        }

        tagMapper.insert(tag);
        return tag;
    }

    /**
     * 通过文章id 查找文章对应的标签列表
     * @param id
     * @return
     */
    @Override
    public List<TTag> selectTagLisByArticleId(Integer id){
       return tagMapper.selectTagLisByArticleId(id);
    }

}
