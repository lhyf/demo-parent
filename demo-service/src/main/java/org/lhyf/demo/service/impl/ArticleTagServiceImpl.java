package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TArticleTagMapper;
import org.lhyf.demo.mapper.TTagMapper;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.pojo.TArticleTag;
import org.lhyf.demo.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @author YF
 * @date 2018-06-21 11:03
 * @desc ArticleTagServiceImpl
 *
 **/

@Service(value = "articleTagService")
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    private TArticleTagMapper articleTagMapper;


    @Autowired
    private TTagMapper tagMapper;

    @Override
    public int insert(TArticleTag articleTag) {
        int i = articleTagMapper.insert(articleTag);
        tagMapper.incrTagCountByPrimaryKey(articleTag.getTagId());
        return i;
    }

}
