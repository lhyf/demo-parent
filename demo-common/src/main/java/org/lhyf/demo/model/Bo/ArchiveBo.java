package org.lhyf.demo.model.Bo;

import lombok.Data;
import org.lhyf.demo.model.Vo.ContentVo;

import java.io.Serializable;
import java.util.List;

@Data
public class ArchiveBo implements Serializable {

    private String date;
    private String count;
    private List<ContentVo> articles;
}
