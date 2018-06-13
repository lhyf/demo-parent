package org.lhyf.demo.service.impl;

import org.lhyf.demo.dto.MetaDto;
import org.lhyf.demo.model.Bo.ArchiveBo;
import org.lhyf.demo.model.Bo.BackResponseBo;
import org.lhyf.demo.model.Bo.StatisticsBo;
import org.lhyf.demo.model.Vo.CommentVo;
import org.lhyf.demo.model.Vo.ContentVo;
import org.lhyf.demo.service.ISiteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "iSiteService")
public class ISiteServiceImpl implements ISiteService {
    @Override
    public List<CommentVo> recentComments(int limit) {
        return null;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        return null;
    }

    @Override
    public CommentVo getComment(Integer coid) {
        return null;
    }

    @Override
    public BackResponseBo backup(String bk_type, String bk_path, String fmt) throws Exception {
        return null;
    }

    @Override
    public StatisticsBo getStatistics() {
        return null;
    }

    @Override
    public List<ArchiveBo> getArchives() {
        return null;
    }

    @Override
    public List<MetaDto> metas(String type, String orderBy, int limit) {
        return null;
    }
}
