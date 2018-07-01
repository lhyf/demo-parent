package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TArticleTagMapper;
import org.lhyf.demo.mapper.TTagMapper;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.pojo.TArticleTag;
import org.lhyf.demo.pojo.TArticleTagExample;
import org.lhyf.demo.service.ArticleTagService;
import org.lhyf.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TagService tagService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int insert(TArticleTag articleTag) {

        //插入两者关联关系到中间表
        int i = articleTagMapper.insert(articleTag);

        //更新tag表对应标签的统计数值
        tagService.incrTagCountByPrimaryKey(articleTag.getTagId());
        return i;
    }

    /**
     * 通过aritcleId 查询 t_article_tag表对应的id 与 t_tag中存放的name
     *
     * @param aritcleId
     * @return
     */
    @Override
    public Map<Integer, String> getArticleTagIdAndTagName(Integer aritcleId) {

        List<Map<String, Object>> list = articleTagMapper.selectArticleTagIdAndTagName(aritcleId);

        Map<Integer, String> fkIdAndTagNames = new HashMap<>();
        Integer id = null;
        String tagName = null;
        for (Map<String, Object> map : list) {

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if ("id".equals(entry.getKey())) {
                    id = (Integer) entry.getValue();
                }
                if ("name".equals(entry.getKey())) {
                    tagName = (String) entry.getValue();
                }
            }
            fkIdAndTagNames.put(id, tagName);
        }

        return fkIdAndTagNames;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteArticleAndTagById(Integer id) {

        TArticleTag articleTag = articleTagMapper.selectByPrimaryKey(id);
        tagService.decrTagCountByPrimaryKey(articleTag.getTagId());
        return articleTagMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteArticleAndTagMappingByArticleId(Integer articleId) {
        List<TArticleTag> articleTags = getArticleTagByArticleId(articleId);

        for (TArticleTag tag : articleTags) {
            tagService.decrTagCountByPrimaryKey(tag.getTagId());
        }
        int i = deleteArticleTagByArticleId(articleId);
        return i;
    }

    @Override
    public List<TArticleTag> getArticleTagByArticleId(Integer articleId) {
        TArticleTagExample example = new TArticleTagExample();
        example.createCriteria().andArticleIdEqualTo(articleId);
        List<TArticleTag> list = articleTagMapper.selectByExample(example);
        return list;
    }

    @Override
    public int deleteArticleTagByArticleId(Integer articleId) {
        TArticleTagExample example = new TArticleTagExample();
        example.createCriteria().andArticleIdEqualTo(articleId);
        return articleTagMapper.deleteByExample(example);
    }

    @Override
    public int deleteArticleTagByTagId(Integer tagId) {
        TArticleTagExample example = new TArticleTagExample();
        example.createCriteria().andTagIdEqualTo(tagId);
        return articleTagMapper.deleteByExample(example);
    }

}
