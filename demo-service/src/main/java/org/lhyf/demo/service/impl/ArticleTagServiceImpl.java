package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TArticleTagMapper;
import org.lhyf.demo.mapper.TTagMapper;
import org.lhyf.demo.message.vo.ArticleVo;
import org.lhyf.demo.pojo.TArticleTag;
import org.lhyf.demo.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TTagMapper tagMapper;

    @Override
    public int insert(TArticleTag articleTag) {

        //插入两者关联关系到中间表
        int i = articleTagMapper.insert(articleTag);

        //更新tag表对应标签的统计数值
        tagMapper.incrTagCountByPrimaryKey(articleTag.getTagId());
        return i;
    }

    /**
     * 通过aritcleId 查询 t_article_tag表对应的id 与 t_tag中存放的name
     * @param aritcleId
     * @return
     */
    @Override
    public Map<Integer, String> selectArticleTagIdAndTagName(Integer aritcleId) {

        List<Map<String, Object>> list = articleTagMapper.selectArticleTagIdAndTagName(aritcleId);

        Map<Integer, String> fkIdAndTagNames = new HashMap<>();
        Integer id = null;
        String tagName = null;
        for (Map<String, Object> map: list ) {

            for(Map.Entry<String , Object> entry:map.entrySet()){
                if("id".equals(entry.getKey())){
                    id = (Integer)entry.getValue();
                }
                if("name".equals(entry.getKey())){
                    tagName = (String)entry.getValue();
                }
            }
            fkIdAndTagNames.put(id,tagName);
        }

        return fkIdAndTagNames;
    }

}
